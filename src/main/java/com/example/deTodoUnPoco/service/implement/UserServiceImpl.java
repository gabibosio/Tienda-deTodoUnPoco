package com.example.deTodoUnPoco.service.implement;

import com.example.deTodoUnPoco.DTO.LoginDTO;
import com.example.deTodoUnPoco.DTO.RegisterDTO;
import com.example.deTodoUnPoco.mapper.UserMapper;
import com.example.deTodoUnPoco.model.Role;
import com.example.deTodoUnPoco.model.User;
import com.example.deTodoUnPoco.repository.RoleRepository;
import com.example.deTodoUnPoco.repository.UserRepository;
import com.example.deTodoUnPoco.secutity.jwt.JwtService;
import com.example.deTodoUnPoco.secutity.jwt.Response;
import com.example.deTodoUnPoco.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    private final RoleRepository roleRepository;


    private final UserMapper userMapper;


    private final JwtService jwtservice;

    private final AuthenticationManager authenticationManager;

    @Override
    public Response register(RegisterDTO registerDTO) {
        User user = userMapper.userDTOToEntity(registerDTO);
        Role role;
        if(registerDTO.getEmail().equals("gabriel@gmail.com")){
            role = roleRepository.findByName("ROLE_ADMIN").get();
        }else{
            role = roleRepository.findByName("ROLE_USER").get();
        }
        user.setRole(role);
        User userSave = userRepository.save(user);
        userMapper.userToDTO(userSave);
        Response response = new Response();
        response.setToken(jwtservice.getToken(userSave));
        return response;
    }

    @Override
    public Response login(LoginDTO loginDTO) {
        authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),loginDTO.getPassword()));
        UserDetails userDetails = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow();
        String token = jwtservice.getToken(userDetails);
        Response  response = new Response();
        response.setToken(token);
        return response;
    }

}
