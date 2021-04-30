package com.zborowski.bartek.flashcard.infrastructure.client.anki

import com.google.gson.Gson
import com.zborowski.bartek.flashcard.domain.DeckDetails
import com.zborowski.bartek.flashcard.domain.FlashCard
import com.zborowski.bartek.flashcard.domain.FlashCardPublisher
import flashcard.infrastructure.client.anki.dto.*
import org.springframework.web.client.RestTemplate

class AnkiFlashCardPublisher(private val restTemplate: RestTemplate, private val gson: Gson) : FlashCardPublisher {

    companion object {
        private const val ACTION_TYPE = "addNote"
        private const val VERSION = 6
        private const val URI = "http://localhost:8765/"

    }

    override fun putAllFlashCardsToAnki(flashCards: List<FlashCard>, deckDetails: DeckDetails) {
        flashCards.stream()
                .map { mapToDto(it, deckDetails) }
                .forEach { restTemplate.postForEntity(URI, gson.toJson(it), String::class.java) }
    }

    private fun mapToDto(flashCard: FlashCard, deckDetails: DeckDetails): FlashCardDto {
        return FlashCardDto(ACTION_TYPE, VERSION,
                ParamsDto(NoteDto(deckDetails.deckName, deckDetails.modelName,
                        FieldsDto(flashCard.question, flashCard.answer),
                        OptionsDto(deckDetails.allowDuplicate, deckDetails.deckName,
                                DuplicateScopeOptionsDto(deckDetails.deckName, false)))))
    }
}