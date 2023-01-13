package com.kohan.duna.domain.hagalcard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class HagalCardManager {

    private final HagalCardRepository hagalCardRepository;

    @Transactional(readOnly = true)
    public HagalCard getSpecificHagalCard(Long id) {
        log.info("Get hagal card : '{}'", id);
        return hagalCardRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<HagalCard> getAllHagalCards() {
        return hagalCardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<HagalCard> findCardsByNumberOfPLayers(int numberOfPlayers) {
        return hagalCardRepository.findAllByNumberOfPlayersIsLessThanEqual(numberOfPlayers);
    }
}
