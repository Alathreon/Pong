package com.alathreon.pong.controller;

import javafx.scene.Scene;

public record View<T>(Scene scene, Controller<T> controller) {
}
