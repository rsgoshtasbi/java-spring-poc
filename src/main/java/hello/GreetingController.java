package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s, with id: %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name,
                             @RequestParam(value="id", defaultValue="World") String id) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name, id));
    }
}