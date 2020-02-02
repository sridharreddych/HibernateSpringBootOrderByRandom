package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            // trigger three queries to see if shuffling is working
            for (int i = 1; i <= 3; i++) {
                bookstoreService.fetchBooksOrderByRnd();
            }
        };
    }
}

/*
 * 
 * 
 * How To Shuffle Small Result Sets

Description: This application is an example of shuffling small results sets. DO NOT USE this technique for large results sets, since is extremely expensive.

Key points:

write a JPQL SELECT query and append to it ORDER BY RAND()
each RDBMS support a function similar to RAND() (e.g., in PostgreSQL is random())
 * 
 */
