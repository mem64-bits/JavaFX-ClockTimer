package com.git.mem64bits.clocktimer.clocktimer;

public record TimeFormat(long hrs, long mins, long secs, long ms){

    public TimeFormat(TimeFormat time){
        this(time.hrs, time.mins, time.secs, time.ms);
    }

    public TimeFormat(long hrs, long mins, long secs){
        this(hrs, mins, secs, 0);
    }

    public long toTotalMillis(){
        return hrs * 3_600_000 + mins * 60000 + secs * 1000 + ms;
    }

    public static TimeFormat fromMillis(long totalMs){
        if(totalMs < 0)
            totalMs = 0;

        long hrs = totalMs / 3_600_000;
        long mins = totalMs / 60000;
        long secs = totalMs / 1000;
        long ms = totalMs % 1000;

        return new TimeFormat(hrs, mins, secs, ms);
    }

    public TimeFormat add(TimeFormat time){

        long totalMillis = toTotalMillis() + time.toTotalMillis();
        return new TimeFormat(fromMillis(totalMillis));
    }

    public TimeFormat sub(TimeFormat time){
        return new TimeFormat(hrs - time.hrs, mins - time.mins,
                secs - time.secs, ms - time.ms);
    }

    public TimeFormat mult(TimeFormat time){
        return new TimeFormat(hrs * time.hrs, mins * time.mins, secs * time.secs, ms * time.ms);
    }

    public TimeFormat div(TimeFormat time){
        return new TimeFormat(hrs / time.hrs, mins / time.mins, secs / time.secs, ms / time.ms);
    }

    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d:%03d",
                hrs, mins, secs, ms);
    }
}
