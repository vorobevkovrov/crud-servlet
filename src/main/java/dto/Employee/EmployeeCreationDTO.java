package dto.Employee;

import lombok.*;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeCreationDTO {
    private String first_name, last_name;

    @Override
    public String toString() {
        return "EmployeeCreationDTO{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
