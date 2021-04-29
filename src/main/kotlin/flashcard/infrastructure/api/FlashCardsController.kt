package com.zborowski.bartek.flashcard.infrastructure.api

import com.zborowski.bartek.flashcard.domain.DeckDetails
import com.zborowski.bartek.flashcard.domain.FlashCardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/flashcards")
class FlashCardsController(private val flashCardService: FlashCardService) {

    @PostMapping("/transfer")
    fun transferFlashCards(@RequestBody deckDetails: DeckDetails): ResponseEntity<Unit> {
        flashCardService.performTransferFromNotionToAnki(deckDetails)
        print("Transfer completed!")
        return ResponseEntity.ok().build()
    }
}