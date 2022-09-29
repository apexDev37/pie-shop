package com.demo.pieshop;

import com.demo.pieshop.Pie.model.Pie;
import com.demo.pieshop.Pie.repository.PieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PieShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PieShopApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PieRepository pieRepository) {
        return args -> {
            Pie applePie = new Pie(
                    "Apple Pie",
                    12.85,
                    "Try our famous apple pie!",
                    true
            );

            Pie blueberryPie = new Pie(
                    "Blueberry Pie",
                    13.50,
                    "Try our loved blueberry pie!",
                    true
            );

            Pie butterPie = new Pie(
                    "Butter Pie",
                    14.00,
                    "Try our sweet butter pie!",
                    true
            );


            Pie carrotPie = new Pie(
                    "Carrot Pie",
                    15.50,
                    "Try our famous carrot pie!",
                    true
            );

            Pie cherryPie = new Pie(
                    "Cherry Pie",
                    11.75,
                    "Try our new cherry pie!",
                    false
            );

            pieRepository.save(applePie);
            pieRepository.save(blueberryPie);
            pieRepository.save(butterPie);
            pieRepository.save(carrotPie);
            pieRepository.save(cherryPie);
        };
    }
}
