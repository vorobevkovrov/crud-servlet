package entity;

import lombok.*;

import java.io.Serializable;
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

    public Employee(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }


    @Override
    public String toString() {
        return "Имя " + first_name + " Фамилия " + last_name;
    }
}
