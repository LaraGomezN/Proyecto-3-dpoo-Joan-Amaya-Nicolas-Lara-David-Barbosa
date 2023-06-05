package utils;

import java.time.LocalTime;
import java.util.logging.Logger;

/**
 * range by hours
 */
public final class TimeRange {
    private LocalTime _start;
    private LocalTime _end;
    public TimeRange(LocalTime start, LocalTime end){
        _start = start;
        _end = end;
    }
    public TimeRange(String start, String end){
        _start = LocalTime.parse(start);
        _end = LocalTime.parse(end);
    }
    public TimeRange(String[] range){
        _start = LocalTime.parse(range[0]);
        _end = LocalTime.parse(range[1]);
    }
    public TimeRange(String range){
        String[] strRange = range.split("-");
        _start = LocalTime.parse(strRange[0]);
        _end = LocalTime.parse(strRange[1]);
    }
    public TimeRange(){
        _start = null;
        _end = null;
    }
    public boolean rangeInRange(TimeRange range){
        return _start.isBefore(range._start) && _end.isAfter(range._end);
    }
    public boolean rangeInRange(String[] range){
        return _start.isBefore(LocalTime.parse(range[0])) && _end.isAfter(LocalTime.parse(range[1]));
    }
    public boolean timeInRange(LocalTime time){
        return _start.isBefore(time) && _end.isAfter(time);
    }
    public boolean timeInRange(String time){
        return _start.isBefore(LocalTime.parse(time)) && _end.isAfter(LocalTime.parse(time));
    }
    public void setRange(LocalTime start, LocalTime end){
        setStart(start);
        setEnd(end);
    }
    public void setRange(String start, String end){
        setStart(LocalTime.parse(start));
        setEnd(LocalTime.parse(end));
    }
    private void setStart(LocalTime time){
        _start = time;
    }
    private void setEnd(LocalTime time){
        _end = time;
    }
    @Override
    public String toString(){
        return "<" + _start + "-" + _end + ">";
    }
}
