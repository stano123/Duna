package com.kohan.duna.service;

import com.kohan.duna.domain.hagalcard.HagalCard;
import com.kohan.duna.domain.hagalcard.HagalCardManager;
import com.kohan.duna.domain.hagalcard.dto.HagalCardDto;
import com.kohan.duna.domain.hagalcard.mapper.HagalCardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HagalCardService {

    private final HagalCardManager hagalCardManager;
    private final HagalCardMapper hagalCardMapper;

    public Optional<HagalCardDto> getSpecificHagalCard(Long id) {
        HagalCard hagalCard = hagalCardManager.getSpecificHagalCard(id);
        return Optional.ofNullable(hagalCardMapper.toDto(hagalCard));
    }

    public Optional<List<HagalCardDto>> getAllHagalCards() {
        List<HagalCard> hagalCards = hagalCardManager.getAllHagalCards();
        return Optional.ofNullable(hagalCards.stream().map(hagalCardMapper::toDto).toList());
    }
}
