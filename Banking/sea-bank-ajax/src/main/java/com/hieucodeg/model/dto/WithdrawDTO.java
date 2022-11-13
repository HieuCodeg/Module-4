package com.hieucodeg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WithdrawDTO {

    private long id;

    @Pattern(regexp = "^\\d+$", message = "ID khách hàng không hợp lệ")
    @NotEmpty(message = "Vui lòng nhập ID khách hàng")
    private String customerId;
    @Pattern(regexp = "^\\d+$", message = "Số tiền không hợp lệ")
    @NotEmpty(message = "Vui lòng nhập số tiền")
    private String transactionAmount;

}
