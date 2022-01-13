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

    public List<RaceDTO> getAll(){
        return all;
    }
}
