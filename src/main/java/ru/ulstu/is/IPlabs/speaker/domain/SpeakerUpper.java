package ru.ulstu.is.IPlabs.speaker.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class SpeakerUpper implements Speaker{
    private final Logger log = LoggerFactory.getLogger(SpeakerUpper.class);
    @Override
    public String say(String name) {
        return "ПРИВЕТ " + name.toUpperCase();
    }

    public void init() {
        log.info("SpeakerUpper.init()");
    }

    public void destroy() {
        log.info("SpeakerUpper.destroy()");
    }
}
