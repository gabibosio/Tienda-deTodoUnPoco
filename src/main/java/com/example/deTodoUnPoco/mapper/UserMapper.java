package com.example.deTodoUnPoco.mapper;

import com.example.deTodoUnPoco.DTO.EditUserDTO;
import com.example.deTodoUnPoco.DTO.RegisterDTO;
import com.example.deTodoUnPoco.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String password;

    public User userDTOToEntity(RegisterDTO registerDTO){
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setName(registerDTO.getName());
        user.setLastName(registerDTO.getLastName());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        password = user.getPassword();
        return user;
    }

    public RegisterDTO userToDTO(User user){
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName(user.getName());
        registerDTO.setLastName(user.getLastName());
        registerDTO.setEmail(user.getEmail());
        registerDTO.setPassword(password);
        return registerDTO;
    }

    public EditUserDTO userToDTOEdit(User user){
        EditUserDTO editUserDTO = new EditUserDTO();
        editUserDTO.setId(user.getId());
        editUserDTO.setName(user.getName());
        editUserDTO.setLastName(user.getLastName());
        editUserDTO.setEmail(user.getEmail());
        editUserDTO.setRol(user.getRole().getName());
        return editUserDTO;
    }

    public List<EditUserDTO> listEntityToDTO(List<User> userList){
        List<EditUserDTO> listUser = new ArrayList<>();
        for(User user : userList){
            listUser.add(this.userToDTOEdit(user));
        }
        return listUser;
    }
}
