package com.zborowski.bartek.flashcard.domain

interface FlashCardPublisher {

    fun putAllFlashCardsToAnki(flashCards: List<FlashCard>, deckDetails: DeckDetails)
}