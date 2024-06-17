package entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Department {
    private int id;
    private String department_name;
    private int employee_id;
    }
