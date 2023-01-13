package com.kohan.duna.domain.game;

import com.kohan.duna.domain.hagalcard.HagalCard;
import com.kohan.duna.domain.hagalcard.HagalCardManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
@RequiredArgsConstructor
public class GameManager {
    private Game game;
    private final HagalCardManager hagalCardManager;

    public HagalCard initGame(int numberOfPlayers) {
        log.debug("Init game");
        LinkedList<HagalCard> gameCards = createPackOfCards(hagalCardManager.findCardsByNumberOfPLayers(numberOfPlayers));
        game = new Game(numberOfPlayers, gameCards, gameCards.getFirst());
        return game.getActualCard();
    }

    public HagalCard shuffle() {
        log.debug("Shuffle pack of cards");
        LinkedList<HagalCard> cardsByNumberOfPLayers = new LinkedList<>(hagalCardManager.findCardsByNumberOfPLayers(game.getNunmberOfPlayers()));
        Collections.shuffle(cardsByNumberOfPLayers);
        game.setGameCards(cardsByNumberOfPLayers);
        game.setActualCard(game.getGameCards().getFirst());
        return game.getActualCard();
    }

    public HagalCard getActualCard() {
        log.debug("Get actual card {}.", game.getActualCard());
        return game.getActualCard();
    }

    public HagalCard getNextCard() {
        game.getActualCard().markCardAsUsed();
        final HagalCard removedCard = game.getGameCards().removeFirst();
        log.debug("Removed card '{}'.", removedCard);
        if (game.getGameCards().isEmpty()) {
            log.info("All cards are used");
            return null;
        }
        game.setActualCard(game.getGameCards().getFirst());
        log.info("New actual card '{}'.", game.getActualCard());
        return game.getActualCard();
    }

    private LinkedList<HagalCard> createPackOfCards(List<HagalCard> dbHagalCards) {
        LinkedList<HagalCard> packOfCards = new LinkedList<>();
        dbHagalCards.forEach(hagalCard ->
                Stream.iterate(0, i -> i++)
                        .limit(hagalCard.getCount())
                        .forEach(x -> packOfCards.add(hagalCard)));
        Collections.shuffle(packOfCards);
        return packOfCards;
    }

    public List<HagalCard> getGameCards() {
        return game.getGameCards();
    }
}

