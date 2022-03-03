package com.bank.yanki.service.service;

import com.bank.yanki.service.model.Yanki;
import com.bank.yanki.service.redis.YankiDto.YankiDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IYankiService {

     Flux<Yanki> findAll();

     Mono<Yanki> save(Yanki yanki);

     Mono<Void> update(String id, Mono<YankiDto> mono);

     Mono<Void> delete(String id);

     Mono<YankiDto> getYanki(String id);

    
}
