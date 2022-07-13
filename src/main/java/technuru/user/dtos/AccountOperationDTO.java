package technuru.user.dtos;
import lombok.Data;
import technuru.user.enums.OperationTypes;
import java.util.Date;
@Data
public class AccountOperationDTO {
    private  Long id;
    private Date operationDate;
    private double amount;
    private OperationTypes type;
    private String description;
}
