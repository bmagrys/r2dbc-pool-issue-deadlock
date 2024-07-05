package com.bmagrys.r2dbc.locked

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@Service
class Demo2Service {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    suspend fun test(): String {
        val delay = (Math.random() * 500).toLong()
        logger.info { "⏳ Delaying #2 for $delay ms" }
        delay(delay)

        return "2".also { logger.info { it } }
    }
}
