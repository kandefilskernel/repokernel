package technuru.user.web;

import org.springframework.web.bind.annotation.*;
import technuru.user.dtos.AccountHistoryDTO;
import technuru.user.dtos.AccountOperationDTO;
import technuru.user.dtos.BankAccountDTO;
import technuru.user.exceptions.BankAccountNotFoundException;
import technuru.user.services.BankAccountService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
      return bankAccountService.getBankAccount(accountId);
    }
    @GetMapping("/accounts")
    List<BankAccountDTO>listAccounts(){
     return bankAccountService.bankAccountList();
    }
    @GetMapping("/accounts/{accountId}/operations")
    List<AccountOperationDTO>getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }
    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "size",defaultValue = "5") int size) throws BankAccountNotFoundException {
            return bankAccountService.getAccountHistory(accountId,page,size);
    }
}
