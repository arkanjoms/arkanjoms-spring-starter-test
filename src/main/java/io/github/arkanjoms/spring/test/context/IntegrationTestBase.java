package io.github.arkanjoms.spring.test.context;

import io.github.arkanjoms.spring.test.containers.PostgresContainer;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringBootTest
@AutoConfigureTestDatabase(replace = NONE)
public abstract class IntegrationTestBase {

    static final PostgresContainer POSTGRESQL_CONTAINER;

    static {
        POSTGRESQL_CONTAINER = PostgresContainer.getInstance();
        POSTGRESQL_CONTAINER.start();
    }

    protected IntegrationTestBase() {
    }
}
