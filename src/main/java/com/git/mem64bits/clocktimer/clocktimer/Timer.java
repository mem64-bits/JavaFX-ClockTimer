package com.git.mem64bits.clocktimer.clocktimer;


public abstract class Timer{
    private TimeFormat displayedTime;
    protected long totalElapsedMillis;
    private boolean active;

    public Timer(long hrs, long mins, long secs, long millis){

        this.displayedTime = new TimeFormat(hrs, mins, secs, millis);
    }

    public Timer(TimeFormat time){

        this.displayedTime = time;
    }

    public TimeFormat getDisplayedTime(){
        return this.displayedTime;
    }

    public void updateDisplayedTime(long hours, long mins, long secs, long millis){
        this.displayedTime = new TimeFormat(hours, mins, secs, millis);
    }

    public void updateDisplayedTime(TimeFormat time){
        this.displayedTime = time;
    }

    public boolean isActive(){
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    @Override
    public String toString(){
        return String.format(
                "%02d:%02d:%02d:%03d", displayedTime.hrs(), displayedTime.mins(),
                displayedTime.secs(), displayedTime.ms());
    }

    protected void calculateTimeUnits(long elapsedMillis){
        if(!active)
            return;

        if(elapsedMillis < 0){
            elapsedMillis = 0;
        }
        long totalSecs = elapsedMillis / 1_000;
        long totalMins = totalSecs / 60;

        long h = totalMins / 60;
        long m = totalMins % 60;
        long s = totalSecs % 60;
        long ms = elapsedMillis % 1000;

        updateDisplayedTime(h, m, s, ms);
    }

    public abstract void update();

    public abstract void start();

    public abstract void stop();

    public abstract void reset();

}
