package technuru.user.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import technuru.user.dtos.CustomerDTO;
import technuru.user.entities.Customer;
import technuru.user.exceptions.CustomerNotFoundException;
import technuru.user.services.BankAccountService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
//@RequestMapping("/customers")
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }
    @GetMapping("/customers/search")
    public List<CustomerDTO> searchCustomers(@RequestParam(name="keyword", defaultValue = "") String keyword){
        return bankAccountService.searchCustomers("%" +keyword+ "%");
    }
    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name ="id" ) Long customerId) throws CustomerNotFoundException {
      return bankAccountService.getCustomer(customerId);
    }
    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId,@RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException {
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }
   @PostMapping("/customers")
   public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO ){
     return bankAccountService.saveCustomer(customerDTO);
   }
   @DeleteMapping("/customers/{id}")
   public  void deleteCustomer(@PathVariable Long id){
          bankAccountService.deleteCustomer(id);
   }
}
