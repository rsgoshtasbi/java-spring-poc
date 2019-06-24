package hello;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/")
public class ScheduleController
{
    @Autowired
    private ScheduleDAO scheduleDAO;

    @GetMapping(path="schedule", produces = "application/json")
    public Schedules getEmployees() {
        return scheduleDAO.getAllEmployees();
    }

    @PostMapping(path= "/schedule", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Schedule employee) {
        Integer id = scheduleDAO.getAllEmployees().getScheduleList().size() + 1;
        employee.setId(id);

        scheduleDAO.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}