package com.inventorycheck.rest;


import com.inventorycheck.bean.BaseResponseBean;
import com.inventorycheck.bean.RegistrationRequest;
import com.inventorycheck.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(path = "api/v1/")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("registration")
    public ResponseEntity register(@RequestBody RegistrationRequest request) {
        BaseResponseBean responseBean = new BaseResponseBean();
        try {
            responseBean.setResult(true);
            responseBean.setData(registrationService.register(request));
        } catch (Exception e) {
            responseBean.setResult(false);
            responseBean.setMessage("API FAILURE");
        }
        return new ResponseEntity<>(responseBean, HttpStatus.OK);
    }


}
