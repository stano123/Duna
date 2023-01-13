package com.kohan.duna.domain.hagalcard;

import com.kohan.duna.domain.SpecialFunction;
import com.kohan.duna.domain.Type;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "HAGAL_CARD")
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "SEQ_HAGAL_CARD_ID")
public class HagalCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer numberOfPlayers;
    private Integer numberOfSwords;
    private Integer count;
    private Boolean isFight;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID", nullable = false)
    private Type type;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "HAGAL_FUNCTION",
            joinColumns = { @JoinColumn(name = "HAGAL_CARD_ID") }, inverseJoinColumns = { @JoinColumn(name = "SPECIAL_FUNCTION_ID") }
    )
    private List<SpecialFunction> specialFunctions = new ArrayList<>();

    @Transient
    private boolean isUsed;

    public void markCardAsUsed() {
        setUsed(true);
    }
}
