package com.kohan.duna.domain;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SPECIAL_FUNCTION")
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "SEQ_SPECIAL_FUNCTION_ID")
public class SpecialFunction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer units;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "SPECIAL_FUNCTION_TYPE_ID", referencedColumnName = "ID", nullable = false)
    private SpecialFunctionType specialFunctionType;
}
