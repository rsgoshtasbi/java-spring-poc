package hello;

import org.springframework.stereotype.Repository;
import hello.Schedules;
import hello.Schedule;

@Repository
public class ScheduleDAO
{
    private static Schedules schedulesList = new Schedules();

    static {
        schedulesList.getScheduleList().add(new Schedule(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        schedulesList.getScheduleList().add(new Schedule(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        schedulesList.getScheduleList().add(new Schedule(3, "David", "Kameron", "titanic@gmail.com"));
    }

    public Schedules getAllEmployees() {
        return schedulesList;
    }

    public void addEmployee(Schedule schedule) {
        schedulesList.getScheduleList().add(schedule);
    }

    @Override
    public String toString() {
        return schedulesList.toString();
    }
}
