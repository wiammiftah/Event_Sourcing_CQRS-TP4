package ma.enset.comptecqrseventsourcing.query.repositories;
import ma.enset.comptecqrseventsourcing.query.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
