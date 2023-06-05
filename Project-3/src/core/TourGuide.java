package core;

import utils.TimeRange;

import java.util.ArrayList;

public class TourGuide extends Service{
    public TourGuide(double price,  TimeRange range) {
        super(null, price, null, range);
    }

    @Override
    public String toString() {
        return "Tour guide :: price: " + price() + ", available schedules: " + timeRange();
    }
}
