package dtos;

import entities.Race;
import java.util.ArrayList;
import java.util.List;

public class RacesDTO {

    List<RaceDTO> all = new ArrayList<>();

    public RacesDTO(List<Race> raceEntities) {
        raceEntities.forEach((p) -> {
            all.add(new RaceDTO(p));
        });
    }

    //Created constructor to get the endpoint "/race" working in RenameMeResource. This might not be correct.
    public RacesDTO(RacesDTO allRaces) {
    }

    public List<RaceDTO> getAll(){
        return all;
    }
}
