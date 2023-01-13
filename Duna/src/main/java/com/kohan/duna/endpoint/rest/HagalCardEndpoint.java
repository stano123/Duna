package com.kohan.duna.endpoint.rest;

import com.kohan.duna.domain.hagalcard.dto.HagalCardDto;
import com.kohan.duna.service.HagalCardService;
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
@Slf4j
@Validated
@RequestMapping(path = "/api/hagalCard")
@RequiredArgsConstructor
public class HagalCardEndpoint {

    private final HagalCardService hagalCardService;

    @GetMapping
    public ResponseEntity<HagalCardDto> getHagalCard(@NotBlank @Min(1) @RequestParam("id") Long id) {
        return hagalCardService.getSpecificHagalCard(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<HagalCardDto>> getAllCards() {
        return hagalCardService.getAllHagalCards().map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
