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

    public List<Schedule> getScheduleList(Integer userId) {
        List<Schedule> result = new ArrayList<>();
        if(scheduleList == null) {
            scheduleList = new ArrayList<>();
        } else {
            for(Schedule schedule: scheduleList) {
                if(userId.equals(schedule.getUserId())) {
                    result.add(schedule);
                }
            }
        }
        return result;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
