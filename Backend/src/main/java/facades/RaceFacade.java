package facades;

import dtos.RaceDTO;
import dtos.RacesDTO;
import entities.Race;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public RaceDTO editRace(RaceDTO r) throws Exception {
        if (r.getName() == null || r.getDate() == null || r.getLocation() == null) {
            throw new Exception();
        }
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Race tmpRace = em.find(Race.class, r.getId());
            tmpRace = tmpRace.updateFromDto(r);
            em.getTransaction().commit();
            return new RaceDTO(tmpRace);
        } finally {
            em.close();
        }
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

    @Override
    public RacesDTO getAllRaces() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Race> query = em.createQuery("SELECT r FROM Race r", Race.class);
        List<Race> races = query.getResultList();
        return new RacesDTO(races);
    }

    public void createRace(RaceDTO rDTO) {
        EntityManager em = emf.createEntityManager();
        Race race = em.find(Race.class, rDTO.getId());
        if (race != null) {
            Race race = new Race(rDTO.getId(), rDTO.getName(), rDTO.getDate(), rDTO.getTime(), rDTO.getLocation());
            race.addRaceInfo();

            em.getTransaction().begin();
            em.merge(race);
            em.getTransaction().commit();

        }


    }
}
