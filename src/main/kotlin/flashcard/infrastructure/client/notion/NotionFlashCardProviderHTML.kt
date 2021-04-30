package com.zborowski.bartek.flashcard.infrastructure.client.notion

import com.zborowski.bartek.flashcard.domain.FlashCard
import com.zborowski.bartek.flashcard.domain.FlashCardProvider
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.File

class NotionFlashCardProviderHTML : FlashCardProvider {

    companion object {
        private const val ROW_TAG = "tr"
        private const val CHARACTER_ENCODING_TYPE = "UTF-8"
    }

    override fun getAllFlashCardsFromNotion(questionColumn: String, answerColumn: String, table: String): List<FlashCard> {
        val flashCardList = arrayListOf<FlashCard>()
        val document = parseHtml(table)
        val rows = retrieveTableRows(document)
        rows?.forEach {
            val question = getQuestionCell(it, questionColumn)
            val answer = getAnswerCell(it, answerColumn) ?: ""
            if (!question.isNullOrEmpty()) {
                flashCardList.add(FlashCard(question, answer))
            }
        }
        return flashCardList
    }

    private fun parseHtml(tableName: String): Document? {
        return Jsoup.parse(File(tableName), CHARACTER_ENCODING_TYPE)
    }

    private fun retrieveTableRows(document: Document?): Elements? {
        return document?.select(ROW_TAG)
    }

    private fun getQuestionCell(element: Element, questionColumn: String): String? {
        return getAnswerCell(element, questionColumn)
    }

    private fun getAnswerCell(element: Element, answerColumn: String): String? {
        return element.getElementsByClass(answerColumn).text()
    }
}