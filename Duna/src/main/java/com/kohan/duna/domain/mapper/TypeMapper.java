package com.kohan.duna.domain.mapper;

import com.kohan.duna.domain.Type;
import com.kohan.duna.domain.dto.TypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    TypeDto toDto(Type type);
}
