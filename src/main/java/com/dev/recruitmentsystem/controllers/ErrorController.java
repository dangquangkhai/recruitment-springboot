package com.dev.recruitmentsystem.controllers;

import com.dev.recruitmentsystem.utils.CustomErrorResponseContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Order(2)
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    HashMap<Object, Object> res;
    Logger log = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> handleError(HttpServletRequest request) throws Exception {
        Object _status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        CustomErrorResponseContent _err = new CustomErrorResponseContent(HttpStatus.valueOf(Integer.parseInt(_status.toString())).toString(), "Something wrong happened");
        return _err.getRes();
    }

    public String getErrorPath() {
        return "/error";
    }
}
