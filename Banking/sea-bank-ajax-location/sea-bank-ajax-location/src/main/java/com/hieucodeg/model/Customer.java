package com.hieucodeg.model;


import com.hieucodeg.model.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
@Accessors(chain = true)
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @Column(precision = 12, scale = 0, nullable = false, updatable = false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Deposit> deposits;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Withdraw> withdraws;

    @OneToOne
    @JoinColumn(name = "location_region_id", referencedColumnName = "id", nullable = false)
    private LocationRegion locationRegion;

    public CustomerDTO toCustomerDTO() {
        return new CustomerDTO()
                .setId(id)
                .setFullName(fullName)
                .setEmail(email)
                .setPhone(phone)
                .setBalance(balance)
                .setLocationRegion(locationRegion.toLocationRegionDTO());
    }



}
