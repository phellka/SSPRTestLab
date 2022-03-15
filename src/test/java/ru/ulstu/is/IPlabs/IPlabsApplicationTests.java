package ru.ulstu.is.IPlabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ulstu.is.IPlabs.speaker.service.SpeakerService;

@SpringBootTest
class IPlabsApplicationTests {
	@Autowired
	SpeakerService speakerService;

	@Test
	void testSpeakerLow() {
		final String res = speakerService.say("Мир", "low");
		Assertions.assertEquals("привет мир!", res);
	}
	@Test
	void testSpeakerUp() {
		final String res = speakerService.say("Мир", "up");
		Assertions.assertEquals("ПРИВЕТ МИР!", res);
	}
	@Test
	void testSpeakerErrorWired() {
		//Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> speakerService.say("Мир", "up"));
	}
}
