package com.dev.recruitmentsystem.controllers;

import org.springframework.data.rest.core.Path;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

@Controller()
@RequestMapping(value = "home")
public class HomeController {
    private Map<Object, Object> res;

    @RequestMapping(value = "index", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<Object, Object> Index() {
        res = new HashMap<>();
        res.put("success", true);
        res.put("message", "Data response successfully");
        return res;
    }
    @RequestMapping(value = "error", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<Object, Object> error() throws Exception
    {
        res = new HashMap<>();
        res.put("success", true);
        res.put("message", 1/0);
        return res;
    }
}
