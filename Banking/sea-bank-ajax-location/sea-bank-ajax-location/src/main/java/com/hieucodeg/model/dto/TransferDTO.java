package com.hieucodeg.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransferDTO {

    private long id;


    @Pattern(regexp = "^\\d+$", message = "ID người gửi phải là số")
    @NotEmpty(message = "Vui lòng nhập ID người gửi")
    private String senderId;

    @Pattern(regexp = "^\\d+$", message = "ID người nhận phải là số")
    @NotEmpty(message = "Vui lòng nhập ID người nhận")
    private String recipientId;

    @Pattern(regexp = "^\\d+$", message = "Số tiền phải là số")
    @NotEmpty(message = "Vui lòng nhập số tiền")
    @Min(value = 1000,message = "Số tiền tối thiểu là 1000 VNĐ")
    private String transferAmount;

}
