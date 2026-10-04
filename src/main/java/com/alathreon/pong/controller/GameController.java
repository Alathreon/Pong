package com.alathreon.pong.controller;

import com.alathreon.pong.logic.PlayerKind;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Controller<PlayerKind> {

    @FXML
    public Canvas canvas;
    @FXML
    public AnchorPane gamePane;
    @FXML
    public AnchorPane pauseMenu;

    private ViewManager manager;

    private PlayerKind playerKind;
    private volatile boolean paused;

    @FXML
    private void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ESCAPE) {
            togglePause();
        }
    }

    @FXML
    private void onKeyReleased(KeyEvent keyEvent) {
    }

    @FXML
    private void onResume(ActionEvent actionEvent) {
        togglePause();
    }

    @FXML
    private void onRestart(ActionEvent actionEvent) {
        // TODO
    }

    @FXML
    private void onReturnToMainMenu(ActionEvent actionEvent) {
        manager.switchView("/MainMenu.fxml", null);
    }

    @FXML
    private void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    private void togglePause() {
        paused = !paused;
        if (paused) {
            pauseMenu.setVisible(true);
        } else {
            pauseMenu.setVisible(false);
        }
        // TODO
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        canvas.widthProperty().bind(gamePane.widthProperty());
        canvas.heightProperty().bind(gamePane.heightProperty());
        pauseMenu.setVisible(false);
    }

    @Override
    public void setManager(ViewManager manager) {
        this.manager = manager;
    }

    @Override
    public void init(PlayerKind playerKind) {
        this.playerKind = playerKind;
        if(paused) {
            togglePause();
        }
    }
}
