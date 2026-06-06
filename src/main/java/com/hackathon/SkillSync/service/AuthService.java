package com.hackathon.SkillSync.service;

import com.hackathon.SkillSync.config.JwtUtil;
import com.hackathon.SkillSync.dto.LoginRequest;
import com.hackathon.SkillSync.dto.LoginResponse;
import com.hackathon.SkillSync.entity.Employee;
import com.hackathon.SkillSync.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request){

        Employee employee =
                employeeRepository
                        .findByEmail(request.getEmail())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Invalid credentials"));

        if(!encoder.matches(
                request.getPassword(),
                employee.getPassword())){

            throw new RuntimeException(
                    "Invalid credentials");
        }

        String token =
                jwtUtil.generateToken(
                        employee.getEmail(),
                        employee.getRole());

        return new LoginResponse(token);
    }
}