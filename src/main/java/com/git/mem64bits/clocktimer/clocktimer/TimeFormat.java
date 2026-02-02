package com.git.mem64bits.clocktimer.clocktimer;

public record TimeFormat(long hours, long minutes, long seconds, long millis){
    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d:%03d",
                hours, minutes, seconds, millis);
    }
}
