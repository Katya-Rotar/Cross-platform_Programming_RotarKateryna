package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@SpringBootTest
@ActiveProfiles("spring-boot-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@TestConfiguration
	static class TestConfig {
		@Bean
		public DataSource dataSource() {
			return DataSourceBuilder.create()
					.driverClassName("org.testcontainers.jdbc.ContainerDatabaseDriver")
					.url("jdbc:tc:postgresql:12:///recipeBook_db?TC_TMPFS=/testtmpfs:rw")
					.username("user")
					.password("password")
					.build();
		}
	}
}
