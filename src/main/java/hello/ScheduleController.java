package hello;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import hello.remote.SpringJDBCConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(path = "schedule")
public class ScheduleController
{
    @Autowired
    private ScheduleDAO scheduleDAO;

//    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//
//    SpringJDBCConfig studentJDBCTemplate = (SpringJDBCConfig)context.getBean("SpringJDBCConfig");

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
//        System.out.println("------Records Creation--------" );
//        studentJDBCTemplate.create("Zara", 11);
//        studentJDBCTemplate.create("Nuha", 2);
//        studentJDBCTemplate.create("Ayan", 15);

        Integer id = scheduleDAO.getAllSchedules().getScheduleList().size() + 1;

        scheduleDAO.addEmployee(schedule);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(schedule.getUserId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}