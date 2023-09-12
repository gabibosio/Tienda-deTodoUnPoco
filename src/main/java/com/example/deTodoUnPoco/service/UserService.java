package com.example.deTodoUnPoco.service;

import com.example.deTodoUnPoco.DTO.EditUserDTO;
import com.example.deTodoUnPoco.DTO.LoginDTO;
import com.example.deTodoUnPoco.DTO.RegisterDTO;
import com.example.deTodoUnPoco.secutity.jwt.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Response register(RegisterDTO registerDTO);

    Response login(LoginDTO loginDTO);

    EditUserDTO edit(long id,EditUserDTO editUserDTO);

    List<EditUserDTO> getUsers();

}
