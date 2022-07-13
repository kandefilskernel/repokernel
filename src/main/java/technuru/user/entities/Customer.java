package technuru.user.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import  javax.persistence.Id;
import  javax.persistence.GeneratedValue;
import  javax.persistence.OneToMany;
import  javax.persistence.GenerationType;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private String email;
    @OneToMany(mappedBy = "customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<BankAccount> bankAccounts;
}
