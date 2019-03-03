package com.miage.altea.tp.trainer_api.controller;

import com.miage.altea.tp.trainer_api.bo.Trainer;
import com.miage.altea.tp.trainer_api.service.TrainerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping("/")
    public Iterable<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{name}")
    public Trainer getTrainer(@PathVariable String name){
        return trainerService.getTrainer(name);
    }

    @PostMapping(value="/")
    public Trainer createTrainer(@RequestBody Trainer trainer){
        trainerService.createTrainer(trainer);
        return trainer;
    }

    @PutMapping("/")
    public Trainer updateTrainer(@RequestBody Trainer trainer) {
        trainerService.update(trainer);
        return trainer;
    }

    @DeleteMapping("/{name}")
    public String deleteTrainer(@PathVariable("name") String trainerName) {
        trainerService.deleteByName(trainerName);
        return trainerName + " was deleted";
    }
}
