package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.domain.Vladilen;
import de.jonashackt.springbootvuejs.repository.VladilenRepo;
import org.springframework.stereotype.Service;

@Service
public class VladilenService {

    private final VladilenRepo vladilenRepo;

    public VladilenService(VladilenRepo vladilenRepo) {
        this.vladilenRepo = vladilenRepo;
    }


    public Vladilen patchupdate(Vladilen vladilenFromDb, Vladilen vladilen) {

        vladilenFromDb.setLastname4(vladilen.getLastname4());

        return vladilenRepo.save(vladilenFromDb);
    }


}
