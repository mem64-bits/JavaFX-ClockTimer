package com.git.mem64bits.clocktimer.clocktimer;

public abstract class Timer{
    long totalHours;
    long totalMinutes;
    long totalSeconds;
    long totalMillis;


    TimeFormat displayedTime;
    boolean active;

    public Timer(long hours, long mins, long secs, long millis){
        this.totalHours = hours;
        this.totalMinutes = mins;
        this.totalSeconds = secs;
        this.totalMillis = millis;

        displayedTime = new TimeFormat(totalHours, totalMinutes, totalSeconds,
                totalMillis);
    }

    public Timer(){
        this.totalHours = 0;
        this.totalMinutes = 0;
        this.totalSeconds = 0;
    }

    public TimeFormat getDisplayedTime(){
        return displayedTime;
    }

    public void updateDisplayedTime(long hours, long mins, long secs, long millis){
        this.totalHours = hours;
        this.totalMinutes = mins;
        this.totalSeconds = secs;
        this.totalMillis = millis;
        displayedTime = new TimeFormat(hours, mins, secs, millis);
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public void reset(){
        updateDisplayedTime(0, 0, 0, 0);
    }

    @Override
    public String toString(){
        return String.format(
                "%02d:%02d:%02d:%03d", totalHours, totalMinutes, totalSeconds, totalMillis);
    }
}
