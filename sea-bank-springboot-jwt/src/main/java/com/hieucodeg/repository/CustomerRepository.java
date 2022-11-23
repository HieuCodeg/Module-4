package com.hieucodeg.repository;

import com.hieucodeg.model.Customer;
import com.hieucodeg.model.dto.CustomerAvartasDTO;
import com.hieucodeg.model.dto.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT NEW com.hieucodeg.model.dto.CustomerDTO(" +
            "c.id, " +
            "c.fullName, " +
            "c.email, " +
            "c.phone, " +
            "c.balance, " +
            "c.locationRegion" +
            ") " +
            "FROM Customer AS c " +
            "WHERE c.deleted = false "
    )
    List<CustomerDTO> getAllCustomerDTO();

    @Query("SELECT NEW com.hieucodeg.model.dto.CustomerAvartasDTO(" +
                "c.id, " +
                "c.fullName, " +
                "c.email, " +
                "c.phone, " +
                "c.balance, " +
                "c.locationRegion, " +
                "a.id, " +
                "a.fileName, " +
                "a.fileFolder, " +
                "a.fileUrl, " +
                "a.cloudId, " +
                "a.fileType " +

                ") " +
            "FROM Customer AS c " +
            "LEFT JOIN Avatar AS a " +
            "ON a.customer = c " +
            "WHERE c.deleted = false"
    )
    List<CustomerAvartasDTO> getAllCustomersAvartaDTO();

    @Query("SELECT NEW com.hieucodeg.model.dto.CustomerAvartasDTO(" +
            "c.id, " +
            "c.fullName, " +
            "c.email, " +
            "c.phone, " +
            "c.balance, " +
            "c.locationRegion, " +
            "a.id, " +
            "a.fileName, " +
            "a.fileFolder, " +
            "a.fileUrl, " +
            "a.cloudId, " +
            "a.fileType " +
            ") " +
            "FROM Customer AS c " +
            "LEFT JOIN Avatar AS a " +
            "ON a.customer = c " +
            "WHERE c.deleted = false and c.id = :id"
    )
    CustomerAvartasDTO getCustomersAvartaDTOById(Long id);

    List<Customer> findAllByIdNot(Long senderId);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByEmailAndIdIsNot(String email, Long id);
    @Modifying
    @Query("UPDATE Customer AS c " +
            "SET c.balance = c.balance + :balance " +
            "WHERE c.id = :customerId")
    void incrementBalance(@Param("customerId") Long customerId, @Param("balance") BigDecimal balance);

    @Modifying
    @Query("UPDATE Customer AS c " +
            "SET c.balance = c.balance - :balance " +
            "WHERE c.id = :customerId")
    void decreaseBalance(@Param("customerId") Long customerId, @Param("balance") BigDecimal balance);
    List<Customer> findAllByDeletedIsFalse();

}
