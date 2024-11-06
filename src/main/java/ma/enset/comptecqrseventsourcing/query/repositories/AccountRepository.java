package ma.enset.comptecqrseventsourcing.query.repositories;

import ma.enset.comptecqrseventsourcing.query.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
