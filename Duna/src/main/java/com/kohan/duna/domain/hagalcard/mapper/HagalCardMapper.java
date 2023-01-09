package com.kohan.duna.domain.hagalcard.mapper;

import com.kohan.duna.domain.hagalcard.HagalCard;
import com.kohan.duna.domain.hagalcard.dto.HagalCardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HagalCardMapper {
    HagalCardDto toDto(HagalCard hagalCard);
}
