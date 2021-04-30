package com.zborowski.bartek.flashcard.infrastructure.client.notion

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NotionFlashCardProviderConfig {

    @Bean
    fun notionFlashCardProviderHTML(): NotionFlashCardProviderHTML {
        return NotionFlashCardProviderHTML()
    }
}