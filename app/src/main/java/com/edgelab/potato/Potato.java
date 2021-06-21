package com.edgelab.potato;

import com.edgelab.potato.Potato.Config;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(Config.class)
@RequiredArgsConstructor
public class Potato {

    private final Config config;

    @GetMapping("/bar")
    String getBar() {
        return config.getBar();
    }

    @ConfigurationProperties("foo")
    static class Config {

        @Getter
        @Setter
        private String bar;

    }

    public static void main(String[] args) {
        run(Potato.class, args);
    }

}
