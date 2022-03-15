package ru.ulstu.is.IPlabs.speaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ulstu.is.IPlabs.speaker.service.SpeakerService;

@RestController
public class SpeakerController {
    private final SpeakerService speakerService;
    public SpeakerController(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "Мир") String name,
                        @RequestParam(value = "size", defaultValue = "up") String size) {
        return speakerService.say(name, size);
    }
}