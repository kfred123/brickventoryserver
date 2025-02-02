package de.pb.bv;

import de.pb.bv.crawler.BrickSetCrawler;
import de.pb.bv.data.BrickSetWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@SpringBootApplication
public class CmdLine {
    @Autowired
    private ApplicationContext applicationContext;
    public static void main(String[] args) throws IOException {
        SpringApplication.run(CmdLine.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            BrickSetCrawler brickSetCrawler = new BrickSetCrawler();
            var brickSet = brickSetCrawler.retrieveFromBrickLink("https://www.bricklink.com/v2/catalog/catalogitem.page?S=10273-1#T=I");
            applicationContext.getBean(BrickSetWriter.class).insertOrUpdate(brickSet.get());
        };
    }
}