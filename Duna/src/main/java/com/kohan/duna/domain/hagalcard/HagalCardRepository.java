package com.kohan.duna.domain.hagalcard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HagalCardRepository extends JpaRepository<HagalCard, Long> {

    List<HagalCard> findAllByNumberOfPlayersIsLessThanEqual(int numberOfPlayers);
}
