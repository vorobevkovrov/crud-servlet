package entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Task {
    private int id;
    private String description;
    private boolean isFinished;
    private int employee_id;
}
