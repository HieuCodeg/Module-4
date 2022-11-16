package com.hieucodeg.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "withdraws")
public class Withdraw  extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "transaction_amount", precision = 12, scale = 0, nullable = false)
    @DecimalMin(value = "1000.0",message = "Số tiền tối thiểu là 1000 VNĐ")
    private BigDecimal transactionAmount;

    @ManyToOne
    @JoinColumn(name = "c_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    public Withdraw() {
    }

    public Withdraw(Long id, BigDecimal transactionAmount, Customer customer) {
        this.id = id;
        this.transactionAmount = transactionAmount;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customerId;
    }
}
