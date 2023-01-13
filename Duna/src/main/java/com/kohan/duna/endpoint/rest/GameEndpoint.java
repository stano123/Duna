package com.kohan.duna.endpoint.rest;

import com.kohan.duna.domain.hagalcard.dto.HagalCardDto;
import com.kohan.duna.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/game")
public class GameEndpoint {

    private final GameService gameService;

    @GetMapping(path = "initGame")
    public ResponseEntity<HagalCardDto> initGame(@NotBlank @Min(1) @RequestParam("num") int numberOfPlayers) {
        log.info("Init game for '{}' players.", numberOfPlayers);
        return gameService.initGame(numberOfPlayers)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "actualCard")
    public ResponseEntity<HagalCardDto> getActualCard() {
        log.info("Get actual card for game.");
        return gameService.getActualCard()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "nextCard")
    public ResponseEntity<HagalCardDto> getNextCard() {
        log.info("Get next card for game.");
        return gameService.getNextCard()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "shuffleCards")
    public ResponseEntity<HagalCardDto> shufflePackOfCards() {
        log.info("Shuffle cards.");
        return gameService.shuffleCards()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "cards")
    public ResponseEntity<List<HagalCardDto>> getGameCards() {
        return gameService.getGameCards()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}
