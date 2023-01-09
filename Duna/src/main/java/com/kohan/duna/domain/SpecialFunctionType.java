package com.kohan.duna.domain;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SPECIAL_FUNCTION_TYPE")
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "SEQ_SPECIAL_FUNCTION_TYPE_ID")
public class SpecialFunctionType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SpecialFunctionName name;
}
