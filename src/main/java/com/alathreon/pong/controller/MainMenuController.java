package com.alathreon.pong.controller;

import com.alathreon.pong.logic.PlayerKind;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Controller<Void> {

    private ViewManager manager;

    @FXML
    private void onVSBot(ActionEvent actionEvent) {
        loadGame(PlayerKind.BOT);
    }

    @FXML
    private void onVSPlayer(ActionEvent actionEvent) {
        loadGame(PlayerKind.HUMAN);
    }

    @FXML
    private void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    private void loadGame(PlayerKind playerKind) {
        manager.switchView("/Game.fxml", playerKind);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setManager(ViewManager manager) {
        this.manager = manager;
    }

    @Override
    public void init(Void o) {
    }
}
