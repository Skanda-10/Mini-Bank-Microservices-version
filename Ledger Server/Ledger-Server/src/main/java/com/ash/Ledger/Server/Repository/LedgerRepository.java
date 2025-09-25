package com.ash.Ledger.Server.Repository;

import com.ash.Ledger.Server.Entity.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Long> {
    List<Ledger> findByUserId(Long userId);
}
