package com.bbva.shopping.pay.api.model.entity;

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

    @Column(name = "limitCredit")
    private BigDecimal limitCredit;

    @Column(name = "amount")
    private BigDecimal  amount;

    @Column(name = "balance")
    private BigDecimal  balance;

    @Column(name = "type")
    private com.bbva.shopping.pay.api.model.dto.enums.TypeCards TypeCards;
    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "card", orphanRemoval = true)
    @JsonIgnore
    private Company company;

    @JsonBackReference
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Operation> listOperation;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public com.bbva.shopping.pay.api.model.dto.enums.TypeCards getTypeCards() {
        return TypeCards;
    }

    public void setTypeCards(com.bbva.shopping.pay.api.model.dto.enums.TypeCards typeCards) {
        TypeCards = typeCards;
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

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", dateExpiration=" + dateExpiration +
                ", cvv=" + cvv +
                ", limitCredit=" + limitCredit +
                ", amount=" + amount +
                ", balance=" + balance +
                ", TypeCards=" + TypeCards +
                ", user=" + user +
                ", company=" + company +
                ", listOperation=" + listOperation +
                '}';
    }
}