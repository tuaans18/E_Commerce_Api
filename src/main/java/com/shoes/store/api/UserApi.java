package com.shoes.store.api;

import com.shoes.store.exception.UserNotFoundException;
import com.shoes.store.jwt.JwtUtils;
import com.shoes.store.repository.RoleRepository;
import com.shoes.store.repository.entity.Roles;
import com.shoes.store.repository.entity.Users;
import com.shoes.store.request.LoginRequest;
import com.shoes.store.request.SignupRequest;
import com.shoes.store.respone.LoginRespone;
import com.shoes.store.respone.MessageResponse;
import com.shoes.store.security.CustomUserDetails;
import com.shoes.store.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class UserApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new LoginRespone(userDetails.getId(), jwt, userDetails.getUsername(),
                userDetails.getFirstName(), userDetails.getLastName(), roles));

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) throws UserNotFoundException {
        if(userService.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }

        Users user = new Users(signupRequest.getFirstName(),
                signupRequest.getLastName(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()),
                signupRequest.getPhoneNumber());

        List<Users> allUser = userService.findAllUser();
        if(allUser.size() == 0) {
            Roles roleAdmin = roleRepository.findById(1L).get();
            user.getRoles().add(roleAdmin);
        }
        else {
            Roles roleUser = roleRepository.findById(2L).get();
            user.getRoles().add(roleUser);
        }

        Users tmpUser = userService.saveUser(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
