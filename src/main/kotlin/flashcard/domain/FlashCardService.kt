package com.zborowski.bartek.flashcard.domain

class FlashCardService(
        private val flashCardProvider: FlashCardProvider,
        private val flashCardPublisher: FlashCardPublisher) {

    fun performTransferFromNotionToAnki(deckDetails: DeckDetails) {
        val flashCards = getAllFlashCardsFromNotion(deckDetails.questionColumn, deckDetails.answerColumn, deckDetails.table)
        return putAllFlashCardsToAnki(flashCards, deckDetails)
    }

    private fun getAllFlashCardsFromNotion(questionColumn: String, answerColumn: String, table: String) =
            flashCardProvider.getAllFlashCardsFromNotion(questionColumn, answerColumn, table)

    private fun putAllFlashCardsToAnki(flashCards: List<FlashCard>, deckDetails: DeckDetails) =
            flashCardPublisher.putAllFlashCardsToAnki(flashCards, deckDetails)
}