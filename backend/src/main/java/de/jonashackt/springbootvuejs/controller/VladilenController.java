package de.jonashackt.springbootvuejs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import de.jonashackt.springbootvuejs.domain.Vladilen;
import de.jonashackt.springbootvuejs.domain.Views;
import de.jonashackt.springbootvuejs.repository.VladilenRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/vladilen")
public class VladilenController {
    private final VladilenRepo vladilenRepo;

    @Autowired
    public VladilenController(VladilenRepo vladilenRepo) {
        this.vladilenRepo = vladilenRepo;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Vladilen> list() {
        return vladilenRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullVladilen.class)
    public Vladilen getOne(@PathVariable("id") Vladilen vladilen) {
        return vladilen;
    }

    @PostMapping
    public Vladilen create(@RequestBody Vladilen vladilen) {
//        vladilen.setCreationDate(LocalDateTime.now());
        return vladilenRepo.save(vladilen);
    }

    @PutMapping("{id}")
    public Vladilen update(
            @PathVariable("id") Vladilen vladilenFromDb,
            @RequestBody Vladilen vladilen
    ) {
        BeanUtils.copyProperties(vladilen, vladilenFromDb, "id");

        return vladilenRepo.save(vladilenFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Vladilen vladilen) {
        vladilenRepo.delete(vladilen);
    }
}
