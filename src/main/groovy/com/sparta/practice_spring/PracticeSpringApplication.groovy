package com.sparta.practice_spring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class PracticeSpringApplication {

    static void main(String[] args) {
        SpringApplication.run(PracticeSpringApplication, args)
    }

}
