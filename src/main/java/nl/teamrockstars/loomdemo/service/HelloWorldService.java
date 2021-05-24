package nl.teamrockstars.loomdemo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public void wasteTime() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
