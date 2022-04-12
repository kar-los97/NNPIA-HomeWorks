package cz.upce.nnpia.be.dto;

import lombok.Data;

@Data
public class TaskDto {
    private Integer id;
    private String name;
    private boolean complete;
}
