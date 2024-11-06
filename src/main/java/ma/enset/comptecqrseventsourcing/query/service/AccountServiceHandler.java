package ma.enset.comptecqrseventsourcing.query.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.comptecqrseventsourcing.commonapi.events.AccountCreatedEvent;
import ma.enset.comptecqrseventsourcing.commonapi.events.AccountCreditedEvent;
import ma.enset.comptecqrseventsourcing.query.entities.Account;
import ma.enset.comptecqrseventsourcing.query.repositories.AccountRepository;
import ma.enset.comptecqrseventsourcing.query.repositories.OperationRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceHandler {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;
    @EventHandler
    public void on(AccountCreatedEvent event) {
        log.info("********************************************");
        log.info("AccountCreatedEvent received : {}", event);
        Account account = new Account();
        account.setId(event.getId());
        account.setCurrency(event.getCurrency());
        account.setBalance(event.getInitialBalance());
        account.setStatus(event.getStatus());
        accountRepository.save(account);




    }
}
