package com.bbva.shopping.pay.api.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_operation")
public class Operation {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_operation", nullable = false)
    private String id;
    
    @Column(name = "transaction")
    @JsonIgnore
    private String transaction;
    
    @Column(name = "releaseDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "active")
    @JsonIgnore
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card")
    @JsonIgnore
    private Card card;

    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetailtsOperation> operation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<DetailtsOperation> getOperation() {
        return operation;
    }

    public void setOperation(List<DetailtsOperation> operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id='" + id + '\'' +
                ", transaction='" + transaction + '\'' +
                ", releaseDate=" + releaseDate +
                ", total=" + total +
                ", active=" + active +
                ", company=" + company +
                ", card=" + card +
                ", operation=" + operation +
                '}';
    }
}
