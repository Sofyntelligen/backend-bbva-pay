package com.sofyntelligen.school.control.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sofyntelligen.school.control.api.model.dto.enums.TypeCards;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_card")
public class Card {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_card", nullable = false)
    private String id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "dateExpiration", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    private LocalDate dateExpiration;

    @Column(name = "cvv", nullable = false)
    private Integer cvv;

    @Column(name = "limitCredit", nullable = false)
    private BigDecimal limitCredit;

    @Column(name = "amount", nullable = false)
    private BigDecimal  amount;

    @Column(name = "balance", nullable = false)
    private BigDecimal  balance;

    @Column(name = "type", nullable = false)
    private TypeCards TypeCards;
    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
    
}
