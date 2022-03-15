package ru.ulstu.is.IPlabs.speaker.configuration;

import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import ru.ulstu.is.IPlabs.speaker.domain.SpeakerLower;
import ru.ulstu.is.IPlabs.speaker.domain.SpeakerUpper;

@Configuration
public class SpeakerConfiguration {
    private final Logger log = LoggerFactory.getLogger(SpeakerConfiguration.class);

    @Bean(value = "low", initMethod = "init", destroyMethod = "destroy")
    public SpeakerLower createLowerSpeaker() {
        log.info("Call createLowerSpeaker()");
        return new SpeakerLower();
    }
    @Bean(value = "up", initMethod = "init", destroyMethod = "destroy")
    public SpeakerUpper createUpperSpeaker() {
        log.info("Call createUpperSpeaker()");
        return new SpeakerUpper();
    }
}
