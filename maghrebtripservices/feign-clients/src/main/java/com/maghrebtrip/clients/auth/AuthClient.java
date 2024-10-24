package com.maghrebtrip.clients.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maghrebtrip.clients.auth.dto.AuthRequest;
import com.maghrebtrip.clients.auth.dto.AuthResponse;
import com.maghrebtrip.clients.auth.dto.RegisterRequest;

@FeignClient(name = "auth", url = "${clients.auth.url}")
public interface AuthClient {
    
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    );

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request
    );
}
