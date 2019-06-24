package hello;

import org.springframework.stereotype.Repository;
import hello.Schedules;
import hello.Schedule;

@Repository
public class ScheduleDAO {
    private static Schedules list = new Schedules();

    static {
        list.getScheduleList().add(new Schedule(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getScheduleList().add(new Schedule(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getScheduleList().add(new Schedule(3, "David", "Kameron", "titanic@gmail.com"));
    }

    public Schedules getAllSchedules() {
        return list;
    }

    public void addSchedule(Schedule schedule) {
        list.getScheduleList().add(schedule);
    }
}
