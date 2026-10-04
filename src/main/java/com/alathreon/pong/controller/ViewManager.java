package com.alathreon.pong.controller;

import com.alathreon.pong.IOUtil;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class ViewManager {

    private final Stage stage;
    private final Map<String, View<?>> views = new HashMap<>();

    public ViewManager(Stage stage) {
        this.stage = stage;
    }

    private void load(String path) {
        View<?> view = IOUtil.loadView(path);
        views.put(path, view);
        view.controller().setManager(this);
    }

    @SuppressWarnings("unchecked")
    public void switchView(String path, Object arg) {
        if(!views.containsKey(path)) {
            load(path);
        }
        View<?> view = views.get(path);
        Controller<Object> controller = (Controller<Object>) view.controller();
        controller.init(arg);
        stage.setScene(view.scene());
    }
}
