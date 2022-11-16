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


    @Pattern(regexp = "^\\d+$", message = "ID người gửi không hợp lệ")
    @NotEmpty(message = "Vui lòng nhập ID người gửi")
    private String senderId;

    @Pattern(regexp = "^\\d+$", message = "ID người nhận không hợp lệ")
    @NotEmpty(message = "Vui lòng nhập ID người nhận")
    private String recipientId;

    @Pattern(regexp = "^\\d+$", message = "Số tiền không hợp lệ")
    @NotEmpty(message = "Vui lòng nhập số tiền")
    private String transferAmount;

}
