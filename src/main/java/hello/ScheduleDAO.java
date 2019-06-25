package hello;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Repository;
import hello.Schedules;
import hello.Schedule;

@Repository
public class ScheduleDAO
{
    private static Schedules schedulesList = new Schedules();

    static {
        schedulesList.getScheduleList().add(new Schedule(1, "06/24/2019", 12, 00, "gym", 123456789L));
        schedulesList.getScheduleList().add(new Schedule(1, "06/24/2019", 18, 30, "work", 123456789L));
        schedulesList.getScheduleList().add(new Schedule(2, "06/24/2019", 12, 30, "work", 123456789L));
    }

    public Schedules getAllSchedules() {
        return schedulesList;
    }

    public Schedules getAllSchedules(Integer userId) {
        Schedules filteredScheduleList = new Schedules();
        filteredScheduleList.setScheduleList(schedulesList.getScheduleList(userId));
        return filteredScheduleList;
    }

    public void addEmployee(Schedule schedule) {
        schedulesList.getScheduleList().add(schedule);
    }

    @Override
    public String toString() {
        return schedulesList.toString();
    }
}
