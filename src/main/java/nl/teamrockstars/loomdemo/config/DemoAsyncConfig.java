package nl.teamrockstars.loomdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class DemoAsyncConfig {
    @Bean
    public ExecutorService myVirtualThreadExecutor() {
        return Executors.newVirtualThreadExecutor();
    }
}
