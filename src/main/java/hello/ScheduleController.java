package hello;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hello.ScheduleDAO;
import hello.Schedule;
import hello.Schedules;


@RestController
@RequestMapping(path = "/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @GetMapping(path = "/", produces = "application/json")
    public Schedules getSchedules() {
        return scheduleDAO.getAllSchedules();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addSchedule(@RequestBody Schedule schedule) {
        Integer id = scheduleDAO.getAllSchedules().getScheduleList().size() + 1;
        schedule.setId(id);

        scheduleDAO.addSchedule(schedule);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(schedule.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
