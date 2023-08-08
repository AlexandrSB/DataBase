package com.example.restservice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(
//            HttpServletRequest request,
            Model model
            ) {
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        if(status != null) {
//            Integer statusCode = Integer.valueOf(status.toString());
//
//            if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                model.addAttribute("error_code", "Not Found, Error 404");
//            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                model.addAttribute( "error_code", "Server Error, Error 500");
//            }
//        }
        //do something like logging
        return "error";
    }
}
