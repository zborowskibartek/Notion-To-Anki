package com.zborowski.bartek.flashcard.infrastructure.client.anki

import com.google.gson.Gson
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class AnkiFlashCardPublisherConfig {

    @Bean
    fun ankiFlashCardPublisher(): AnkiFlashCardPublisher {
        val restTemplate = RestTemplate()
        val gson = Gson()
        return AnkiFlashCardPublisher(restTemplate, gson)
    }
}