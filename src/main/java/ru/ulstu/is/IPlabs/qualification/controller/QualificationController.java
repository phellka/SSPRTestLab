package ru.ulstu.is.IPlabs.qualification.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ulstu.is.IPlabs.qualification.model.Collector;
import ru.ulstu.is.IPlabs.qualification.model.Qualification;
import ru.ulstu.is.IPlabs.qualification.service.QualificationService;

import java.util.List;

@RestController
@RequestMapping("/qualification")
public class QualificationController {
    private final QualificationService qualficationService;


    public QualificationController(QualificationService qualificationService) {
        this.qualficationService = qualificationService;
    }

    @GetMapping("/{id}")
    public Qualification getQualification(@PathVariable Long id) {
        return qualficationService.findQualification(id);
    }

    @GetMapping("/")
    public List<Qualification> getQualifications() {
        return qualficationService.findAllQualifications();
    }
    @PostMapping("/")
    public Qualification createQualification(@RequestParam("category") int category,
                                       @RequestParam("name") String name) {
        return qualficationService.addQualification(category, name);
    }
    @PatchMapping("/{id}")
    public Qualification updateQualification(@PathVariable Long id,
                                       @RequestParam("category") int category,
                                       @RequestParam("name") String name) {
        return qualficationService.updateQualification(id, category, name);
    }
    @DeleteMapping("/{id}")
    public Qualification deleteQualification(@PathVariable Long id) {
        return qualficationService.deleteQualification(id);
    }

    @GetMapping("/c{id}")
    public Collector getCollector(@PathVariable Long id) {
        return qualficationService.findCollector(id);
    }

    @GetMapping("/c")
    public List<Collector> getCollectors() {
        return qualficationService.findAllCollectors();
    }
    @PostMapping("/c")
    public Collector createCollector(@RequestParam("experience") int experience,
                                     @RequestParam("name") String name,
                                     @RequestParam("qualificationId") long qualificationId) {
        return qualficationService.addCollector(experience, name, qualificationId);
    }
    @PatchMapping("/c{id}")
    public Collector updateCollector(@PathVariable Long id,
                                     @RequestParam("experience") int experience,
                                     @RequestParam("name") String name,
                                     @RequestParam("qualificationId") long qualificationId) {
        //return qualficationService.findCollector(id);
        return qualficationService.updateCollector(id, experience, name, qualificationId);
    }
    @GetMapping("/test/{id}")
    public Collector updateTestCollector(@PathVariable Long id,
                                     @RequestParam("experience") int experience,
                                     @RequestParam("name") String name,
                                     @RequestParam("qualificationId") long qualificationId) {
        return qualficationService.updateCollector(id, experience, name, qualificationId);
    }
    @DeleteMapping("/c{id}")
    public Collector deleteCollector(@PathVariable Long id) {
        return qualficationService.deleteCollector(id);
    }
}