//package test;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class GreetingController implements ErrorController {
//
//    private static final String template = "Hello, %s, with id: %s!";
//    private final AtomicLong counter = new AtomicLong();
//
//    @RequestMapping("/test")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name,
//                             @RequestParam(value="id", defaultValue="World") String id) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name, id));
//    }
//
////    @PostMapping("/schedule")
////    public ResponseEntity<Object> addSchedule(
////            @RequestBody Schedule schedule) {
////        return new Object();
////    }
//
//
//    @RequestMapping("/error")
//    public String error() {
//        return "Error handling";
//    }
//
//    @Override
//    public String getErrorPath(){
//        return "";
//    }
//}