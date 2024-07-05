package com.bmagrys.r2dbc.locked

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.random.Random.Default.nextLong

@SpringBootTest
class DemoApplicationTests(@Autowired private val demoService: DemoService) {

    @Test
    fun contextLoads() {
        runBlocking {
            withContext(Dispatchers.IO) {
                (0..20).map {
                    async {
                        delay(nextLong(30)) // random delay to make sure the coroutines are running out of order
                        demoService.test()
                    }
                }.awaitAll()
            }
        }
    }
}
