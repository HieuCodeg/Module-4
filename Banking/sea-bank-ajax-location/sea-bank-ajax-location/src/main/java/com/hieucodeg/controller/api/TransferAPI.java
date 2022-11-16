package com.hieucodeg.controller.api;

import com.hieucodeg.model.Customer;
import com.hieucodeg.model.dto.TransferHistoryDTO;
import com.hieucodeg.repository.TransferRepository;
import com.hieucodeg.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferAPI {
    @Autowired
    private ITransferService transferService;

    @GetMapping("/information")
    public ResponseEntity<?> loadPage() {

        List<TransferHistoryDTO> transferHistoryDTOList = transferService.getAllHistories();

        return new ResponseEntity<>(transferHistoryDTOList, HttpStatus.OK);
    }
}
