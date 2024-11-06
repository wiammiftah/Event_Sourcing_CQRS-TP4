package ma.enset.comptecqrseventsourcing.commands.controllers;

import lombok.AllArgsConstructor;
import ma.enset.comptecqrseventsourcing.commonapi.commands.CreateAccountCommand;
import ma.enset.comptecqrseventsourcing.commonapi.commands.CreditAccountCommand;
import ma.enset.comptecqrseventsourcing.commonapi.commands.DebitAccountCommand;
import ma.enset.comptecqrseventsourcing.commonapi.dtos.CreateAccountRequestDTO;
import ma.enset.comptecqrseventsourcing.commonapi.dtos.CreditAccountRequestDTO;
import ma.enset.comptecqrseventsourcing.commonapi.dtos.DebitAccountRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/commands/account")
@AllArgsConstructor
public class AccountCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping(path="/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO request) {
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                request.getInitialbalance(),
                request.getCurrency()

        ));
    }

    @PutMapping(path="/credit")
    public CompletableFuture<String> creditAccount(@RequestBody CreditAccountRequestDTO request) {
        return commandGateway.send(new CreditAccountCommand(
                request.getAccoundId(),
                request.getAmount(),
                request.getCurrency()

        ));
    }
    @PutMapping(path="/debit")
    public CompletableFuture<String> debitAccount(@RequestBody DebitAccountRequestDTO request) {
        return commandGateway.send(new DebitAccountCommand(
                request.getAccoundId(),
                request.getAmount(),
                request.getCurrency()

        ));
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    @GetMapping("/eventStore/{accountId}")
    public Stream eventStore(@PathVariable String accountId){
        return eventStore.readEvents(accountId).asStream();

    }
}

