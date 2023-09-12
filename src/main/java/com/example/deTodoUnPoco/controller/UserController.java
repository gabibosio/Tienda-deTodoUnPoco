package com.example.deTodoUnPoco.controller;

import com.example.deTodoUnPoco.DTO.EditUserDTO;
import com.example.deTodoUnPoco.DTO.LoginDTO;
import com.example.deTodoUnPoco.DTO.RegisterDTO;
import com.example.deTodoUnPoco.secutity.jwt.Response;
import com.example.deTodoUnPoco.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @PostMapping(value = "/register")
    public ResponseEntity<Response> register(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(userService.register(registerDTO));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Response> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(userService.login(loginDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditUserDTO> edit(@PathVariable long id,@RequestBody EditUserDTO editUserDTO){
        try{
            userService.edit(id,editUserDTO);
            return ResponseEntity.ok().body(editUserDTO);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    ResponseEntity<List<EditUserDTO>> getUsers(){
        List<EditUserDTO> editUserDTOS = userService.getUsers();
        return ResponseEntity.ok().body(editUserDTOS);
    }
}
