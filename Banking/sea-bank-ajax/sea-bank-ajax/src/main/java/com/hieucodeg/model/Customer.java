package com.hieucodeg.model;


import com.hieucodeg.model.dto.CustomerDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Tên không được trống")
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @NotEmpty(message = "Email không được trống")
    @Email(message = "Email không đúng định dạng (vd:HieuCodeg@gmail.com")
    @Column(nullable = false, unique = true)
    private String email;
    @NotEmpty(message = "Phone không được trống")
    private String phone;
    @NotEmpty(message = "Địa chỉ không được trống")
    private String address;

    @Column(precision = 12, scale = 0, nullable = false, updatable = false)
    private BigDecimal balance;

    @OneToMany
    private List<Deposit> deposits;

    @OneToMany
    private List<Withdraw> withdraws;

    public Customer() {
    }

    public Customer(Long id, @NotEmpty String fullName,
                    @NotEmpty  @Email String email,
                    @NotEmpty String phone,
                    @NotEmpty String address,
                    BigDecimal balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
    }
    public CustomerDTO toCustomerDTO() {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(String.valueOf(id));
        customerDTO.setFullName(fullName);
        customerDTO.setEmail(email);
        customerDTO.setPhone(phone);
        customerDTO.setAddress(address);
        customerDTO.setBalance(balance.toString());
        return  customerDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                '}';
    }


}
