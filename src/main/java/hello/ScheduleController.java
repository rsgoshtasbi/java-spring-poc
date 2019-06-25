package hello;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "schedule")
public class ScheduleController
{
    @Autowired
    private ScheduleDAO scheduleDAO;

    @GetMapping(produces = "application/json")
    public Schedules getEmployees() {
        return scheduleDAO.getAllSchedules();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Schedules getEmployees(@PathVariable("id") Integer userId) {
        return scheduleDAO.getAllSchedules(userId);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Schedule schedule) {
        Integer id = scheduleDAO.getAllSchedules().getScheduleList().size() + 1;

        scheduleDAO.addEmployee(schedule);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(schedule.getUserId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}