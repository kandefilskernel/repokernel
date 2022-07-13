package technuru.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import technuru.user.entities.BankAccount;
import technuru.user.entities.Customer;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
