package com.zborowski.bartek.flashcard.domain

class DeckDetails(
        val deckName: String,
        val modelName: String,
        val allowDuplicate: Boolean,
        val questionColumn: String,
        val answerColumn: String,
        val table: String,
)
