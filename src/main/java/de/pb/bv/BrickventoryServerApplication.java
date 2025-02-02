package de.pb.bv;

import de.pb.bv.crawler.BrickSetCrawler;
import de.pb.bv.data.BrickSetWriter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@SpringBootApplication
@EnableJpaRepositories
public class BrickventoryServerApplication {

    public static void main(String[] args) {
        // ToDo create database
        SpringApplication.run(BrickventoryServerApplication.class, args);
    }


}
