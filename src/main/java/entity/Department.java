package entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Department {
    private int id;
    private String departmentName;
    private int employeeId;
}
