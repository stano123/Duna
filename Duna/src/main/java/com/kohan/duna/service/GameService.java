package com.kohan.duna.service;

import com.kohan.duna.domain.game.GameManager;
import com.kohan.duna.domain.hagalcard.HagalCard;
import com.kohan.duna.domain.hagalcard.dto.HagalCardDto;
import com.kohan.duna.domain.hagalcard.mapper.HagalCardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GameService {

    private final GameManager gameManager;
    private final HagalCardMapper hagalCardMapper;

    public Optional<HagalCardDto> initGame(int numberOfPlayers) {
        final HagalCard hagalCard = gameManager.initGame(numberOfPlayers);
        return Optional.of(hagalCardMapper.toDto(hagalCard));
    }

    public Optional<HagalCardDto> shuffleCards() {
        final HagalCard actualCardAfterShuffle = gameManager.shuffle();
        return Optional.of(hagalCardMapper.toDto(actualCardAfterShuffle));
    }

    public Optional<HagalCardDto> getActualCard() {
        final HagalCard actualCard = gameManager.getActualCard();
        return Optional.of(hagalCardMapper.toDto(actualCard));
    }

    public Optional<HagalCardDto> getNextCard() {
        final HagalCard nextCard = gameManager.getNextCard();
        return Optional.ofNullable(hagalCardMapper.toDto(nextCard));
    }

    public Optional<List<HagalCardDto>> getGameCards() {
        final List<HagalCard> gameCards = gameManager.getGameCards();
        return Optional.ofNullable(gameCards.stream().map(hagalCardMapper::toDto).toList());
    }
}
