package com.zborowski.bartek.flashcard.domain

interface FlashCardProvider {

    fun getAllFlashCardsFromNotion(questionColumn: String, answerColumn: String, table: String): List<FlashCard>

}