package com.miage.altea.tp.trainer_api.service;

import com.miage.altea.tp.trainer_api.bo.Trainer;
import com.miage.altea.tp.trainer_api.repository.TrainerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TrainerServiceImpl implements TrainerService{
    private TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Iterable<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(String name) {
        Optional<Trainer> result = trainerRepository.findById(name);
        final Trainer[] t = {null};

        result.ifPresent(trainer -> {
            t[0] = trainer;});

        return t[0];
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
}
