package com.git.mem64bits.clocktimer.clocktimer;

public class CountDown extends Timer{

    public CountDown(int hours, int mins, int secs){
        super(hours, mins, secs, 0);
    }

    public CountDown(){
        super(0, 0, 0, 0);
    }
}
