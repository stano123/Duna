package com.kohan.duna.domain.mapper;

import com.kohan.duna.domain.SpecialFunctionType;
import com.kohan.duna.domain.dto.SpecialFunctionTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecialFunctionTypeMapper {
    SpecialFunctionTypeDto toDto(SpecialFunctionType specialFunctionType);
}
