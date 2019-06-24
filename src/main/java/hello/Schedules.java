package hello;

import java.util.ArrayList;
import java.util.List;

public class Schedules {
    private List<Schedule> scheduleList;

    // getter method
    public List<Schedule> getScheduleList() {
        if(scheduleList == null) {
            return new ArrayList<>();
        } else {
            return scheduleList;
        }
    }

    // setter method
    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
