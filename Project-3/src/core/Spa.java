package core;

import utils.TimeRange;

public class Spa extends Service{

    public Spa(double price, TimeRange range) {
        super(null, price, null, range);
    }

    @Override
    public String toString() {
        return "Spa :: price: " + price() + ", available schedules: " + timeRange();
    }
}
