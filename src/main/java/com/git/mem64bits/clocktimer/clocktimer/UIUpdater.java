package com.git.mem64bits.clocktimer.clocktimer;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class UIUpdater{

    enum AppState{
        RUNNING,
        PAUSED,
        NEUTRAL
    }

    private AppState currentState = AppState.NEUTRAL;


    public Label timerLabel;
    public Button startButton;
    public Button pauseButton;
    public Button resetButton;

    private final Stopwatch stopwatch = new Stopwatch(0, 0, 0, 0);
    private long lastTime = 0;
    private double accumulator = 0;

    private final AnimationTimer timeUpdater = new AnimationTimer(){
        @Override
        public void handle(long now){
            if(lastTime == 0){
                lastTime = now;
                return;
            }

            double deltaTime = (now - lastTime) / 1_000_000_000.0;
            lastTime = now;

            double timeMultiplier = 1.0;
            accumulator += (deltaTime * timeMultiplier);

            while(accumulator >= 0.001){
                stopwatch.updateStopwatch();
                accumulator -= 0.001;
            }
            timerLabel.setText(stopwatch.getDisplayedTime().toString());
        }
    };

    @FXML
    protected void onStartButtonClick(){
        stopwatch.reset();
        currentState = AppState.RUNNING;
        lastTime = 0;
        timeUpdater.start();
        stopwatch.setActive(true);
        updateButtonVisibility();
    }

    @FXML
    protected void onPauseButtonClick(){
        if(currentState == AppState.RUNNING){
            currentState = AppState.PAUSED;
            timeUpdater.stop();
            stopwatch.setActive(false);
            pauseButton.setText("Pause");
        } else if(currentState == AppState.PAUSED){
            currentState = AppState.RUNNING;
            lastTime = 0;
            timeUpdater.start();
            stopwatch.setActive(true);
        }

        updateButtonVisibility();
    }

    @FXML
    private void onResetButtonClick(){
        currentState = AppState.NEUTRAL;
        timeUpdater.stop();
        stopwatch.setActive(false);
        lastTime = 0;

        pauseButton.setText("Pause");
        stopwatch.updateDisplayedTime(0, 0, 0, 0);
        timerLabel.setText(stopwatch.getDisplayedTime().toString());
        updateButtonVisibility();
    }

    void updateButtonVisibility(){
        switch(currentState){

            case NEUTRAL -> {
                startButton.setDisable(false);
                resetButton.setDisable(false);
                pauseButton.setDisable(true);
                pauseButton.setText("Pause");

            }
            case RUNNING -> {
                resetButton.setDisable(true);
                pauseButton.setDisable(false);
                startButton.setDisable(true);
                pauseButton.setText("Pause");
            }
            case PAUSED -> {
                resetButton.setDisable(false);
                pauseButton.setText("Resume");
            }
        }
    }
}