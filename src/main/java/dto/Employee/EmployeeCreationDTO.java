package dto.Employee;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class EmployeeCreationDTO {
    String first_name, last_name;
 //   int department_id;
    //   int task_id;
}
