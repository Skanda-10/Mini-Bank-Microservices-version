package com.ash.Ledger.Server.Controller;

import com.ash.Ledger.Server.Entity.Ledger;
import com.ash.Ledger.Server.Service.LedgerService;
import com.ash.Ledger.Server.DTO.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ledger")
public class LedgerController {

    @Autowired
    private LedgerService ledgerService;

    // Optional manual addition endpoint
    @PostMapping("/add")
    public Ledger addLedgerEntry(@RequestBody TransactionDTO dto) {
        return ledgerService.saveTransaction(dto);
    }

    @GetMapping("/user/{userId}")
    public List<Ledger> getUserLedger(@PathVariable Long userId) {
        return ledgerService.getLedgerByUserId(userId);
    }

    @GetMapping("/all")
    public List<Ledger> getAllLedgers() {
        return ledgerService.getAllLedgers();
    }
}
