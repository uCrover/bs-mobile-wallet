package com.bank.yanki.service.repository;

import com.bank.yanki.service.model.Yanki;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YankiRepository extends ReactiveMongoRepository<Yanki, String> {


}