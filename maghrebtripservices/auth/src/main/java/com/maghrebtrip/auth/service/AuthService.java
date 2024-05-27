package com.maghrebtrip.auth.service;

import com.maghrebtrip.auth.Role;
import com.maghrebtrip.auth.User;
import com.maghrebtrip.auth.UserRepository;
import com.maghrebtrip.auth.dto.AuthRequest;
import com.maghrebtrip.auth.dto.AuthResponse;
import com.maghrebtrip.auth.dto.RegisterRequest;
import com.maghrebtrip.clients.tourist.dto.RegisterTouristRequest;
import com.maghrebtrip.clients.tourist.TouristClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
     private final TouristClient touristClient;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.TOURIST)
                .build();
        userRepository.saveAndFlush(user);
        var jwtToken = jwtService.generateToken(user);
        RegisterTouristRequest touristRequest = new RegisterTouristRequest();
        touristRequest.setFirstName(request.getFirstName());
        touristRequest.setLastName(request.getLastName());
        touristRequest.setEmail(request.getEmail());
        touristRequest.setPassword(request.getPassword());
        touristClient.registerTourist(touristRequest);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}