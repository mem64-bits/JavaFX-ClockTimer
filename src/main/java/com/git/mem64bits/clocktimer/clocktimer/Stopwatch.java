package com.git.mem64bits.clocktimer.clocktimer;

public class Stopwatch extends Timer{
 
    public Stopwatch(long hours, long mins, long secs, long millis){
        super(hours, mins, secs, millis);
        this.totalElapsedMillis = 0;
    }

    public Stopwatch(){
        super(0, 0, 0, 0);
        this.totalElapsedMillis = 0;
    }

    public Stopwatch(TimeFormat time){
        super(time);
        this.totalElapsedMillis = 0;
    }

    @Override
    public void update(){
        if(!isActive())
            return;
        totalElapsedMillis++;
        calculateTimeUnits(totalElapsedMillis);
    }


    @Override
    public void reset(){
        this.totalElapsedMillis = 0;
        updateDisplayedTime(new TimeFormat(0, 0, 0, 0));

    }

    @Override
    public void start(){
        setActive(true);
    }

    @Override
    public void stop(){
        setActive(false);
    }

}