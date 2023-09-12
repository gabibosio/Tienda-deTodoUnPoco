package com.example.deTodoUnPoco.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditUserDTO {

    private long id;
    private String name;
    private String lastName;
    private String email;
    private String rol;
}
