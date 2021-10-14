package com.zborowski.bartek.flashcard.domain

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FlashCardFacadeConfiguration {

    @Bean
    fun createFlashCardFacade(flashCardProvider: FlashCardProvider, flashCardPublisher: FlashCardPublisher): FlashCardFacade {
        val flashCardService = FlashCardService(flashCardProvider, flashCardPublisher)
        return FlashCardFacade(flashCardService)
    }
}