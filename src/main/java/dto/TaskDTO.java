package dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskDTO {
    private final String description;
    private final boolean isFinished;
    private final int employee_id;
}
