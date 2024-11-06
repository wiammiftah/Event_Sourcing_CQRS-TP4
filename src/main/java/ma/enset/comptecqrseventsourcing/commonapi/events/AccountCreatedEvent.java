package ma.enset.comptecqrseventsourcing.commonapi.events;

import lombok.Getter;
import ma.enset.comptecqrseventsourcing.commonapi.enums.AccountStatus;

public class AccountCreatedEvent extends BaseEvent<String>{
    @Getter private final double initialBalance;
    @Getter private final String currency;
    @Getter private final AccountStatus status;
    public AccountCreatedEvent(String id , double initialBalance, String currency,AccountStatus status) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
        this.status = status;
    }
}
