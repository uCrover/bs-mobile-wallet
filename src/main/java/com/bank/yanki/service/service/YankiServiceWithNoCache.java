package com.bank.yanki.service.service;

import com.bank.yanki.service.model.Yanki;
import com.bank.yanki.service.redis.Util.EntityDtoUtil;
import com.bank.yanki.service.redis.YankiDto.YankiDto;
import com.bank.yanki.service.repository.YankiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RequiredArgsConstructor
@Service
@ConditionalOnProperty(name = "cache.enabled", havingValue = "false")
public class YankiServiceWithNoCache implements IYankiService {

    private final YankiRepository repository;


    @Override
    public Flux<Yanki> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Yanki> save(Yanki yanki) {
        return repository.save(yanki);
    }


    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Void> update(String id, Mono<YankiDto> mono) {
        return this.repository.findById(id)
                .zipWith(mono)
                .doOnNext(t -> t.getT1().setAmount(t.getT2().getAmount()))
                .map(Tuple2::getT1)
                .flatMap(this.repository::save)
                .then();
    }


    @Override
    public Mono<YankiDto> getYanki(String id) {
        return repository.findById(id).map(EntityDtoUtil::toDto);
    }


}
