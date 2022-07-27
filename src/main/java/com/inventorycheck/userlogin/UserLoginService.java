package com.inventorycheck.userlogin;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserLoginService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with Mobile Number %s not found";

    private final UserLoginRepository userLoginRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String mobileNo)
            throws UsernameNotFoundException {
        return userLoginRepository.findByMobileNo(mobileNo)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, mobileNo)));
    }

    public String signUpUser(UserLogin userLogin) {
        boolean userExists = userLoginRepository
                .findByMobileNo(userLogin.getMobileNo())
                .isPresent();
        if (userExists) {

            throw new IllegalStateException("Mobile Number already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(userLogin.getPassword());

        userLogin.setPassword(encodedPassword);

        userLoginRepository.save(userLogin);
        return "success";
    }



}