package com.alathreon.pong.controller;

import javafx.fxml.Initializable;

public interface Controller<T> extends Initializable {
    void setManager(ViewManager manager);
    void init(T t);
}
