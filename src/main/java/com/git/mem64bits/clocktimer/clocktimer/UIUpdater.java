package com.git.mem64bits.clocktimer.clocktimer;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class UIUpdater{
    enum TimerState{
        RUNNING,
        PAUSED,
        NEUTRAL
    }

    /*enum TimerMode{
        STOPWATCH,
        TIMER
    }
*/
    private TimerState currentState = TimerState.NEUTRAL;
    // private TimerMode timerMode = TimerMode.STOPWATCH;
    private Timer timerEngine;
    private AnimationTimer timeUpdater;

    public Label clockLabel;
    //public ClockFace clockFace;

    //public Button timerModeButton;
    public Button startButton;
    public Button pauseButton;
    public Button resetButton;

    private long lastTime = 0;
    private double accumulator = 0;

    private void updateTimerEngine(long nanoTime){
        if(!timerEngine.isActive()){
            return;
        }

        if(lastTime == 0){
            lastTime = nanoTime;
            return;
        }

        double deltaTime = (nanoTime - lastTime) / 1_000_000_000.0;
        lastTime = nanoTime;

        double timeMultiplier = 1.0;
        accumulator += (deltaTime * timeMultiplier);

        while(accumulator >= 0.001){
            timerEngine.update();
            accumulator -= 0.001;
        }
        clockLabel.setText(timerEngine.getDisplayedTime().toString());
    }

    @FXML
    void initialize(){
        this.timerEngine = new Stopwatch(0, 0, 0, 0);
        this.timeUpdater = new AnimationTimer(){
            @Override
            public void handle(long now){
                if(!timerEngine.isActive()){
                    return;
                }
                updateTimerEngine(now);
            }
        };
    }

    @FXML
    protected void onStartButtonClick(){
        timerEngine.start();
        currentState = TimerState.RUNNING;

        lastTime = 0;
        accumulator = 0.0;

        timeUpdater.start();
        timerEngine.setActive(true);
        updateButtonVisibility();
    }

    @FXML
    protected void onPauseButtonClick(){
        if(currentState == TimerState.RUNNING){
            currentState = TimerState.PAUSED;
            timerEngine.stop();
            timeUpdater.stop();
            pauseButton.setText("Pause");

            lastTime = 0;
            accumulator = 0.0;


        } else if(currentState == TimerState.PAUSED){
            currentState = TimerState.RUNNING;
            timerEngine.start();
            timeUpdater.start();
            pauseButton.setText("Resume");
            accumulator = 0.0;
            lastTime = 0;
        }
        updateButtonVisibility();
    }

    @FXML
    private void onResetButtonClick(){
        timerEngine.setActive(false);
        pauseButton.setText("Pause");
        currentState = TimerState.NEUTRAL;

        timeUpdater.stop();
        lastTime = 0;
        accumulator = 0.0;

        timerEngine.reset();
        clockLabel.setText(timerEngine.getDisplayedTime().toString());
        updateButtonVisibility();
    }


 /*   public void switchTimerMode(){
        switch(timerMode){
            case STOPWATCH -> {
                timerMode = TimerMode.TIMER;
                //timerModeButton.setText("Timer");
            }
            case TIMER -> {
                timerMode = STOPWATCH;
                //timerModeButton.setText("Stopwatch");
            }
        }
    }*/


  /*  @FXML
    private void onModeButtonClick(){
        //switchTimerMode();
        changeTimerEngine(timerMode);
    }*/

    public void updateButtonVisibility(){
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

    /*public void changeTimerEngine(TimerMode mode){
        switch(mode){
            case STOPWATCH -> {
                timerEngine = new Stopwatch(0, 0, 0, 0);
            }
            case TIMER -> {
                timerEngine = new Countdown(0, 0, 0);
            }

        }
    }*/


}