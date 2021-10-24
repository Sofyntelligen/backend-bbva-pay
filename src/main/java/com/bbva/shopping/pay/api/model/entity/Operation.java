package com.bbva.shopping.pay.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    @JsonIgnore
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card")
    @JsonIgnore
    private Card card;
    
    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetailtsOperation> listDetailtsOperation;

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

    public List<DetailtsOperation> getListDetailtsOperation() {
        return listDetailtsOperation;
    }

    public void setListDetailtsOperation(List<DetailtsOperation> listDetailtsOperation) {
        this.listDetailtsOperation = listDetailtsOperation;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id='" + id + '\'' +
                ", transaction='" + transaction + '\'' +
                ", releaseDate=" + releaseDate +
                ", total=" + total +
                ", company=" + company +
                ", card=" + card +
                ", listDetailtsOperation=" + listDetailtsOperation +
                '}';
    }
}
