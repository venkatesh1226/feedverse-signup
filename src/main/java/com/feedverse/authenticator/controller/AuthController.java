package com.feedverse.authenticator.controller;

import com.feedverse.authenticator.model.KeyCloakUser;
import com.feedverse.authenticator.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    AuthService keycloakService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody KeyCloakUser user) {
        try{
        keycloakService.registerUser(user);
            return ResponseEntity.ok("User registered");
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        logger.debug(credentials.toString());
        String token = keycloakService.loginUserWithEmail(credentials.get("email"), credentials.get("password"));
        logger.debug(token);
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(token);
    }

    @PostMapping("/login-username")
    public ResponseEntity<String> loginUsername(@RequestBody Map<String, String> creds){
        String token=keycloakService.loginUser(creds.get("username"), creds.get("password"));
        logger.debug("****\n"+token);
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(token);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        try{
            keycloakService.logoutUser(username);
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("logged out successfully");
        }
        catch(Exception e){
            return ResponseEntity.badRequest()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/hello")
    public String hello(){
        System.out.println("Hii");
        // Your logic here
        return "Hello";
    }
}
