package com.miage.altea.tp.trainer_api.repository;

import com.miage.altea.tp.trainer_api.bo.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TrainerRepository extends CrudRepository<Trainer, String> {
}
