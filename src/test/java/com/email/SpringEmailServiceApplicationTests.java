package com.email;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.email.controller.mailController;

@SpringBootTest
class SpringEmailServiceApplicationTests {

	Logger logger=LoggerFactory.getLogger(SpringEmailServiceApplicationTests.class);
	@Test
	void contextLoads() {
		logger.info("Test has been executed");
		assertEquals(true, true);
	}

}
