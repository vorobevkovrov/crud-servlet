package entity;

import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    private int id;
    private String first_name, last_name;
    private List<String> tasks;

    public Employee(String firstName, String lastName) {
    }


    @Override
    public String toString() {
        return "Name " + first_name + " Last name " + last_name;
    }
}
