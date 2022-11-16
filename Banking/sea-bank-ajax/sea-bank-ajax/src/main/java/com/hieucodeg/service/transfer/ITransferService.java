package com.hieucodeg.service.transfer;

import com.hieucodeg.model.Transfer;
import com.hieucodeg.model.dto.TransferHistoryDTO;
import com.hieucodeg.service.IGeneralService;

import java.util.List;

public interface ITransferService extends IGeneralService<Transfer> {
    List<TransferHistoryDTO> getAllHistories();
}
