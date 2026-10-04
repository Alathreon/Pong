package com.alathreon.pong;

import com.alathreon.pong.controller.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.io.UncheckedIOException;

public class IOUtil {
    private IOUtil() {}

    public static <T> View<T> loadView(String path) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root;
        try {
            root = fxmlLoader.load(Pong.class.getResourceAsStream(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return new View<>(new Scene(root), fxmlLoader.getController());
    }
}
