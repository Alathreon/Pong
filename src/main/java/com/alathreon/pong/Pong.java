package com.alathreon.pong;

import com.alathreon.pong.controller.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Pong extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewManager viewManager = new ViewManager(primaryStage);
        primaryStage.setTitle("Pong");
        viewManager.switchView("/MainMenu.fxml", null);
        primaryStage.show();
    }
}
