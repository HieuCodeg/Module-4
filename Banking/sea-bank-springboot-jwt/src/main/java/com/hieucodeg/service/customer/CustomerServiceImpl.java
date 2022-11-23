package com.hieucodeg.service.customer;



import com.hieucodeg.exception.DataInputException;
import com.hieucodeg.model.*;
import com.hieucodeg.model.dto.CustomerAvartasDTO;
import com.hieucodeg.model.dto.CustomerDTO;
import com.hieucodeg.model.enums.FileType;
import com.hieucodeg.repository.*;
import com.hieucodeg.service.upload.UploadService;
import com.hieucodeg.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private WithdrawRepository withdrawRepository;

    @Autowired
    private LocationRegionRepositiry locationRegionRepositiry;
    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private UploadUtil uploadUtil;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        locationRegionRepositiry.save(customer.getLocationRegion());
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Customer deposit(Deposit deposit, Customer customer) {
        deposit.setId(0L);
        deposit.setCustomer(customer);
        depositRepository.save(deposit);

        BigDecimal newBalance = deposit.getTransactionAmount();
        customerRepository.incrementBalance(customer.getId(), newBalance);
        Optional<Customer> newCustomer = customerRepository.findById(customer.getId());
        return newCustomer.get();
    }

    @Override
    public Customer withdraw(Withdraw withdraw, Customer customer) {
        withdraw.setId(0L);
        withdraw.setCustomer(customer);
        withdrawRepository.save(withdraw);

        BigDecimal newBalance = withdraw.getTransactionAmount();
        customerRepository.decreaseBalance(customer.getId(), newBalance);
        Optional<Customer> newCustomer = customerRepository.findById(customer.getId());
        return newCustomer.get();
    }

    @Override
    public List<Customer> findAllByIdNot(Long senderId) {
        return customerRepository.findAllByIdNot(senderId);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Optional<Customer> findByEmailAndIdIsNot(String email, Long id) {
        return customerRepository.findByEmailAndIdIsNot(email,id);
    }

    @Override
    public void transfer(Transfer transfer) {
        Customer sender = transfer.getSender();

        customerRepository.decreaseBalance(transfer.getSender().getId(),transfer.getTransactionAmount());

        customerRepository.incrementBalance(transfer.getRecipient().getId(),transfer.getTransferAmount());

        transferRepository.save(transfer);
    }
    @Override
    public List<Customer> findAllByDeletedIsFalse() {
        return customerRepository.findAllByDeletedIsFalse();
    }

    @Override
    public List<CustomerDTO> getAllCustomerDTO() {
        return customerRepository.getAllCustomerDTO();
    }

    @Override
    public List<CustomerAvartasDTO> getAllCustomersAvartaDTO() {
        return customerRepository.getAllCustomersAvartaDTO();
    }

    @Override
    public CustomerAvartasDTO saveWithAvatar(Customer customer, MultipartFile avatarFile) {

        LocationRegion locationRegion = customer.getLocationRegion();
        locationRegion.setId(0L);
        LocationRegion newLocationRegion = locationRegionRepositiry.save(locationRegion);

        customer.setLocationRegion(newLocationRegion);

        Customer newCustomer = customerRepository.save(customer);

        Avatar avatar = new Avatar();

        String fileType = avatarFile.getContentType();

        assert fileType != null;

        fileType = fileType.substring(0, 5);

        avatar.setFileType(fileType);
        avatar.setCustomer(newCustomer);

        Avatar newAvatar = avatarRepository.save(avatar);

        if (fileType.equals(FileType.IMAGE.getValue())) {
            uploadAndSaveProductImage(avatarFile, newCustomer, newAvatar);
        }

        CustomerAvartasDTO customerAvartasDTO = newCustomer.toCustomerAvartasDTO();
        customerAvartasDTO.setFileUrl(newAvatar.getFileUrl());

        return customerAvartasDTO;
    }

    private void uploadAndSaveProductImage(MultipartFile avatarFile, Customer customer, Avatar avatar) {
        try {
            Map uploadResult = uploadService.uploadImage(avatarFile, uploadUtil.buildImageUploadParams(avatar));
            String fileUrl = (String) uploadResult.get("secure_url");
            String fileFormat = (String) uploadResult.get("format");

            avatar.setFileName(avatar.getId() + "." + fileFormat);
            avatar.setFileUrl(fileUrl);
            avatar.setFileFolder(UploadUtil.IMAGE_UPLOAD_FOLDER);
            avatar.setCloudId(avatar.getFileFolder() + "/" + avatar.getId());
            avatar.setCustomer(customer);
            avatarRepository.save(avatar);

        } catch (IOException e) {
            e.printStackTrace();
            throw new DataInputException("Upload hình ảnh thất bại");
        }
    }
}
