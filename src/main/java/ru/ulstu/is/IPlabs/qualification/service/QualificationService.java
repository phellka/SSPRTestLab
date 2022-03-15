package ru.ulstu.is.IPlabs.qualification.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.ulstu.is.IPlabs.qualification.model.Collector;
import ru.ulstu.is.IPlabs.qualification.model.Qualification;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class QualificationService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Qualification addQualification(int category, String name) {
        if (category <= 0 || !StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Qualification name is null or empty or category <= 0");
        }
        final Qualification qualification = new Qualification(category, name);
        em.persist(qualification);
        return qualification;
    }

    @Transactional(readOnly = true)
    public Qualification findQualification(Long id) {
        final Qualification qualification = em.find(Qualification.class, id);
        if (qualification == null) {
            throw new EntityNotFoundException(String.format("Qualification with id [%s] is not found", id));
        }
        return qualification;
    }

    @Transactional(readOnly = true)
    public List<Qualification> findAllQualifications() {
        return em.createQuery("select q from Qualification q", Qualification.class)
                .getResultList();
    }

    @Transactional
    public Qualification updateQualification(Long id, int category, String name) {
        if (category <= 0 || !StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Qualification name is null or empty or category <= 0");
        }
        final Qualification currentQualification = findQualification(id);
        currentQualification.setCategory(category);
        currentQualification.setName(name);
        return em.merge(currentQualification);
    }

    @Transactional
    public Qualification deleteQualification(Long id) {
        final Qualification currentQualification = findQualification(id);
        em.remove(currentQualification);
        return currentQualification;
    }

    @Transactional
    public void deleteAllQualifications() {
        em.createQuery("delete from Qualification").executeUpdate();
    }

    @Transactional
    public Collector addCollector(int experience, String name, long qualificationId) {
        if (experience < 0 || !StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Qualification name is null or empty or experience < 0");
        }
        Qualification qualification = findQualification(qualificationId);
        final Collector collector = new Collector(experience, name, findQualification(qualificationId));
        em.persist(collector);
        return collector;
    }

    @Transactional(readOnly = true)
    public Collector findCollector(Long id) {
        final Collector collector = em.find(Collector.class, id);
        if (collector == null) {
            throw new EntityNotFoundException(String.format("Collector with id [%s] is not found", id));
        }
        return collector;
    }

    @Transactional(readOnly = true)
    public List<Collector> findAllCollectors() {
        return em.createQuery("select c from Collector c", Collector.class)
                .getResultList();
    }

    @Transactional
    public Collector updateCollector(Long id, int experience, String name, long qualificationId) {
        if (experience < 0 || !StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Qualification name is null or empty or experience < 0");
        }
        final Collector currentCollector = findCollector(id);
        currentCollector.setExperience(experience);
        currentCollector.setName(name);
        currentCollector.setQualification(findQualification(qualificationId));
        return em.merge(currentCollector);
    }

    @Transactional
    public Collector deleteCollector(Long id) {
        final Collector currentCollector = findCollector(id);
        em.remove(currentCollector);
        return currentCollector;
    }

    @Transactional
    public void deleteAllCollectors() {
        em.createQuery("delete from Collector").executeUpdate();
    }
}
