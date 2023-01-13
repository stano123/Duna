package com.kohan.duna.domain.mapper;

import com.kohan.duna.domain.SpecialFunction;
import com.kohan.duna.domain.dto.SpecialFunctionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecialFunctionMapper {
    SpecialFunctionDto toDto(SpecialFunction specialFunction);
}
