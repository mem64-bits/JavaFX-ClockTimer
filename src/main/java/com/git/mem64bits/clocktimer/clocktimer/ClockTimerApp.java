package com.git.mem64bits.clocktimer.clocktimer;

import atlantafx.base.theme.CupertinoDark;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class ClockTimerApp extends Application{
    @Override
    public void start(Stage stage) throws IOException{
        Application.setUserAgentStylesheet(new CupertinoDark().getUserAgentStylesheet());
        FXMLLoader fxmlLoader = new FXMLLoader(ClockTimerApp.class.getResource("UI/ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setResizable(false);
        stage.setTitle("Clock Stopwatch");
        stage.setScene(scene);
        stage.show();
    }
}
