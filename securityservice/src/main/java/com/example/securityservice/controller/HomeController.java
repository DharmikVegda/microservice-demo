package com.example.securityservice.controller;

import com.example.securityservice.entity.User;
import com.example.securityservice.repository.UserRepository;
import com.example.securityservice.service.JwtService;
import com.example.securityservice.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserInfoService userInfoService;

    private final UserRepository userRepository;

    @GetMapping("/home")
    public String welcome() {
        return userRepository.welcome();
    }

//    @GetMapping("/user/")
//    public ResponseEntity<List<User>> findAllUser() {
//        return ResponseEntity.ok(userRepository.findAllUser());
//    }

//    @GetMapping("/user/{username}")
//    public User findById(@PathVariable String username) {
//        Optional<User> userOptl =  userRepository.findUserByUsername(username);
//        if(userOptl.isPresent()){
//            return userOptl.get();
//        }else{
//            return new User();
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> map) {
        Authentication authentication = null;
        String username = map.get("username");
        String password = map.get("password");
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(" Bad Credentials!!!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(jwtService.generateToken(username));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registration(@RequestBody User user) {
        return ResponseEntity.ok(userInfoService.addUser(user));
    }

    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }
}
