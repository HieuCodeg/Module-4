package com.hieucodeg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WithdrawDTO {

    private long id;

    @Pattern(regexp = "^\\d+$", message = "ID khách hàng phải là số")
    @NotEmpty(message = "Vui lòng nhập ID khách hàng")
    private String customerId;

    @Pattern(regexp = "^\\d+$", message = "Số tiền phải là số")
    @Min(value = 1000,message = "Số tiền tối thiểu là 1000 VNĐ")
    @NotEmpty(message = "Vui lòng nhập số tiền")
    private String transactionAmount;

}
