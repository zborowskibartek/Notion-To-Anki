package com.zborowski.bartek

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotionToAnkiApplication

fun main(args: Array<String>) {
    runApplication<NotionToAnkiApplication>(*args)
}