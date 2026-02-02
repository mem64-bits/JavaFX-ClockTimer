package com.git.mem64bits.clocktimer.clocktimer;

public class Stopwatch extends Timer{
    private long startNano;

    public Stopwatch(long hours, long mins, long secs, long millis){
        super(hours, mins, secs, millis);
        resetStartNano();
    }

    public Stopwatch(){
        super(0, 0, 0, 0);
        resetStartNano();
    }

    public void resetStartNano(){
        startNano = System.nanoTime();
    }

    public void updateStopwatch(){
        if(!active)
            return;

        long elapsedNano = System.nanoTime() - startNano;
        totalMillis = elapsedNano / 1_000_000;
        totalSeconds = totalMillis / 1_000;
        totalMinutes = totalSeconds / 60;
        totalHours = totalMinutes / 60;

        long displayedMillis = totalMillis % 1000;
        long displayedSeconds = totalSeconds % 60;
        long displayedMinutes = totalMinutes % 60;

        updateDisplayedTime(totalHours, displayedMinutes, displayedSeconds,
                displayedMillis);

    }

    @Override
    public void reset(){
        resetStartNano();
        updateDisplayedTime(0, 0, 0, 0);
    }

}