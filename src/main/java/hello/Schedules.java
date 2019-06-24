package hello;

import java.util.ArrayList;
import java.util.List;

public class Schedules
{
    private List<Schedule> scheduleList;

    public List<Schedule> getScheduleList() {
        if(scheduleList == null) {
            scheduleList = new ArrayList<>();
        }
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
