package com.hieucodeg.model.dto;

import com.hieucodeg.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    @Pattern(regexp = "^\\d+$", message = "ID không hợp lệ")
    private String id;
    @NotEmpty(message = "Tên không được trống")
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @NotEmpty(message = "Email không được trống")
    @Email(message = "Email không đúng định dạng (vd:HieuCodeg@gmail.com")
    private String email;
    @NotEmpty(message = "Phone không được trống")
    private String phone;
    @NotEmpty(message = "Địa chỉ không được trống")
    private String address;

    private String balance;
    private Boolean delected;

}
