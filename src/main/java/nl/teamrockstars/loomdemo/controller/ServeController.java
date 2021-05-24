package nl.teamrockstars.loomdemo.controller;

import nl.teamrockstars.loomdemo.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServeController {
    private final HelloWorldService service;

    @Autowired
    public ServeController(HelloWorldService service) {
        this.service = service;
    }

    @GetMapping("/v1/hello")
    public String hello() {
        service.wasteTime();

        return "hello";
    }

    @GetMapping("/v2/hello")
    public String helloFast() {
        service.wasteTime2();

        return "world";
    }
}
