package com.hieucodeg.service.withdraw;

import com.hieucodeg.model.Withdraw;
import com.hieucodeg.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class WithdrawServiceImp implements IWithdrawService{
    @Autowired
    private WithdrawRepository withdrawRepository;
    @Override
    public List<Withdraw> findAll() {
        return withdrawRepository.findAll();
    }

    @Override
    public Withdraw getById(Long id) {
        return null;
    }

    @Override
    public Optional<Withdraw> findById(Long id) {
        return withdrawRepository.findById(id);
    }

    @Override
    public Withdraw save(Withdraw withdraw) {
        return withdrawRepository.save(withdraw);
    }

    @Override
    public void remove(Long id) {

    }
}
