package com.bmagrys.r2dbc.locked

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@Service
class DemoService(private val demo2Service: Demo2Service) {

    @Transactional
    suspend fun test(): String {
        val delay = (Math.random() * 500).toLong()
        logger.info { "⏳ Delaying #1 for $delay ms" }
        delay(delay)

        return ("1" + demo2Service.test()).also { logger.info { it } }
    }
}
