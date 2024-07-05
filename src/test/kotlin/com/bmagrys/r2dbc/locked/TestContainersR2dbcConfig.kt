package com.bmagrys.r2dbc.locked

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@EnableR2dbcRepositories
@Testcontainers
@TestConfiguration
class TestContainersR2dbcConfig {

    companion object {

        @Container
        @ServiceConnection
        @JvmStatic
        val postgres = PostgreSQLContainer("postgres:14.9")
            .withReuse(true)
    }
}
