package com.kohan.duna.domain.hagalcard.dto;

import com.kohan.duna.domain.dto.SpecialFunctionDto;
import com.kohan.duna.domain.dto.TypeDto;
import lombok.Data;

import java.util.List;

@Data
public class HagalCardDto {
    private String name;
    private Integer numberOfPlayers;
    private Integer numberOfSwords;
    private Integer count;
    private Boolean isFight;
    private TypeDto type;
    private List<SpecialFunctionDto> specialFunctions;
}
