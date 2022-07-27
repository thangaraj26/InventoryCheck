package com.inventorycheck.registration;


import com.inventorycheck.userlogin.UserLogin;
import com.inventorycheck.userlogin.UserLoginRole;
import com.inventorycheck.userlogin.UserLoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final MobileNoValidator mobileNoValidator;

    private final UserLoginService userLoginService;

    public String register(RegistrationRequest request) {
        boolean isValidMobileNo = mobileNoValidator.
                test(request.getMobileNo());

        if (!isValidMobileNo) {
            throw new IllegalStateException("Mobile Number not valid");
        }

        String token = userLoginService.signUpUser(
                new UserLogin(
                        request.getMobileNo(),
                        request.getPassword(),
                        request.getBranch(),
                        UserLoginRole.USER

                )
        );

        return token;
    }
}
