package com.capgemini.bootcamp.java.excersicetwo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class ExcersicetwoApplicationTests {

	@Test
	void contextLoads() {
		String[] args = {};
		assertDoesNotThrow(() -> ExcersicetwoApplication.main(args));
	}

}
