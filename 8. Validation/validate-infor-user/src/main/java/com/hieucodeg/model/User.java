package com.hieucodeg.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class User {

    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    @Min(18)
    private int age;

    @DecimalMin(value = "100", message = "Transaction Amount must be greater than or equal to $100")
    @DecimalMax(value = "1000000", message = "Transaction Amount must be less than or equal to $1.000.000")
    private BigDecimal transactionAmount;

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public User() {
    }

    public User(@NotEmpty @Size(min = 2, max = 30) String name, @Min(18) int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
