package com.bbva.shopping.pay.api.model.entity;

import com.bbva.shopping.pay.api.model.dto.enums.TypeCards;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "number")
    private String number;

    @Column(name = "dateExpiration")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    private LocalDate dateExpiration;

    @Column(name = "cvv")
    private Integer cvv;

    @Column(name = "limit_credit")
    private BigDecimal limitCredit;
    
    @Column(name = "available_credit")
    private BigDecimal  availableCredit;

    @Column(name = "user_credit")
    private BigDecimal  userCredit;

    @Column(name = "type")
    private TypeCards typeCards;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "card", orphanRemoval = true)
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Operation> listOperation;

    public Card() {
    }

    public Card(String number, LocalDate dateExpiration, Integer cvv, BigDecimal limitCredit, BigDecimal availableCredit, BigDecimal userCredit, TypeCards typeCards, User user) {
        this.number = number;
        this.dateExpiration = dateExpiration;
        this.cvv = cvv;
        this.limitCredit = limitCredit;
        this.availableCredit = availableCredit;
        this.userCredit = userCredit;
        this.typeCards = typeCards;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getLimitCredit() {
        return limitCredit;
    }

    public void setLimitCredit(BigDecimal limitCredit) {
        this.limitCredit = limitCredit;
    }

    public BigDecimal getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(BigDecimal availableCredit) {
        this.availableCredit = availableCredit;
    }

    public BigDecimal getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(BigDecimal userCredit) {
        this.userCredit = userCredit;
    }

    public TypeCards getTypeCards() {
        return typeCards;
    }

    public void setTypeCards(TypeCards typeCards) {
        this.typeCards = typeCards;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Operation> getListOperation() {
        return listOperation;
    }

    public void setListOperation(List<Operation> listOperation) {
        this.listOperation = listOperation;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", dateExpiration=" + dateExpiration +
                ", cvv=" + cvv +
                ", limitCredit=" + limitCredit +
                ", availableCredit=" + availableCredit +
                ", userCredit=" + userCredit +
                ", typeCards=" + typeCards +
                ", user=" + user +
                ", company=" + company +
                ", listOperation=" + listOperation +
                '}';
    }
}
