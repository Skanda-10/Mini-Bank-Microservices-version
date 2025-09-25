package com.ash.Ledger.Server.Rabbit;

import com.ash.Ledger.Server.Service.LedgerService;
import com.ash.Ledger.Server.DTO.TransactionDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LedgerConsumer {

    @Autowired
    private LedgerService ledgerService;

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveTransaction(TransactionDTO dto) {
        System.out.println("Received transaction via RabbitMQ: " + dto);
        ledgerService.saveTransaction(dto);  // saves to DB
    }
}
