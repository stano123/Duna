package com.kohan.duna.domain.game;

import com.kohan.duna.domain.hagalcard.HagalCard;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

@Data
@AllArgsConstructor
public class Game {

    private int nunmberOfPlayers;
    private LinkedList<HagalCard> gameCards;
    private HagalCard actualCard;
}
