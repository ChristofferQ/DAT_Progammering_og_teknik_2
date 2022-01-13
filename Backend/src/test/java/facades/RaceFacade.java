package facades;

import dtos.RaceDTO;
import entities.Race;
import groovy.lang.MissingFieldException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RaceFacade implements IRaceFacade {

    private static RaceFacade instance;
    private static EntityManagerFactory emf;

    private RaceFacade() {
    }

    public static RaceFacade getRaceFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RaceFacade();
        }
        return instance;
    }

    @Override
    public RaceDTO addRace(int id, String name, String date, String time, String location) throws Exception {
        if (name == null || date == null || time == null || location == null) {
            throw new Exception();
        }
        Race r = new Race(id, name, date, time, location);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new RaceDTO(r);
    }

    @Override
    public RaceDTO deleteRace(int id) throws Exception {
        EntityManager em = emf.createEntityManager();
        Race race;
        try {
            em.getTransaction().begin();
            race = em.find(Race.class, id);
            if (race == null) {
                throw new Exception();
            }
            em.remove(race);
            em.getTransaction().commit();
            return new RaceDTO(race);
        } finally {
            em.close();
        }
    }

    @Override
    public RaceDTO getRace(int id) throws Exception {
        EntityManager em = emf.createEntityManager();
        Race r = em.find(Race.class, id);
        if (r == null) {
            throw new Exception();
        } else {
            return new RaceDTO(r);
        }
    }
}
