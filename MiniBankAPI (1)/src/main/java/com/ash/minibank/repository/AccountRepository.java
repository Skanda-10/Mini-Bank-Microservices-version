package com.ash.minibank.repository;

import com.ash.minibank.entity.Account;
import com.ash.minibank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUser(User user);
}
