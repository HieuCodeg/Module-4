package com.hieucodeg.repository;


import com.hieucodeg.model.Transfer;
import com.hieucodeg.model.dto.TransferHistoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    @Query("SELECT NEW com.hieucodeg.model.dto.TransferHistoryDTO (" +
            "t.id, " +
            "t.sender.id, " +
            "t.sender.fullName, " +
            "t.recipient.id, " +
            "t.recipient.fullName, " +
            "t.transferAmount, " +
            "t.fees, " +
            "t.feesAmount," +
            "t.transactionAmount" +
            ") " +
            "FROM Transfer AS t "
    )
    List<TransferHistoryDTO> getAllHistories();
}
