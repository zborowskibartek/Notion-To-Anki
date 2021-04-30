package com.zborowski.bartek.flashcard.domain

class FlashCardFacade(private val flashCardService: FlashCardService) {

    fun transferFlashCards(deckDetails: DeckDetails) {
        flashCardService.performTransferFromNotionToAnki(deckDetails)
    }
}