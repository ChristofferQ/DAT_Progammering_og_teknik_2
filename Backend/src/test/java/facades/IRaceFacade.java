package facades;

import dtos.RaceDTO;

public interface IRaceFacade {

    public RaceDTO addRace(int id, String name, String date, String time, String location) throws Exception;
    public RaceDTO deleteRace(int id) throws Exception;
    public RaceDTO getRace(int id) throws Exception;


}
