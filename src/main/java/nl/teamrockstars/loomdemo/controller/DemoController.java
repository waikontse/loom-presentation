package nl.teamrockstars.loomdemo.controller;

import nl.teamrockstars.loomdemo.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class DemoController {
    private final HelloWorldService service;

    @Autowired
    public DemoController(HelloWorldService service) {
        this.service = service;
    }

    // A simple GET method trying to simulate a task costing 1 sec.
    @GetMapping("/v1/hello")
    public String hello() {
        service.wasteTime();

        return "hello";
    }

    // A simple GET method trying to simulate a task costing 1 sec.
    // Using async backed by a Virtual thread executor, which is unlimited, to
    // showcase the high throughput capabilities enabled by loom.
    @Async("myVirtualThreadExecutor")
    @GetMapping("/v2/hello")
    public Future<String> helloFaster() {
        service.wasteTime();

        return new AsyncResult<>("Wakanda!!");
    }
}
