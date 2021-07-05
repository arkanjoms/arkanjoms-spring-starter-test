package io.github.arkanjoms.spring.test.containers;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Objects;

@Slf4j
public class PostgresContainer extends PostgreSQLContainer<PostgresContainer> {

    private static final String IMAGE_VERSION = "postgres:13-alpine";
    private static PostgresContainer instance;

    private PostgresContainer() {
        super(IMAGE_VERSION);
    }

    public static PostgresContainer getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PostgresContainer();
            instance.withReuse(true);
        }
        return instance;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DATABASE_URL", instance.getJdbcUrl());
        System.setProperty("DATABASE_USER", instance.getUsername());
        System.setProperty("DATABASE_PASSWORD", instance.getPassword());
    }
}
