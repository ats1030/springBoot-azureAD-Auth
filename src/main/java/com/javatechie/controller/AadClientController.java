package com.javatechie.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AadClientController {
    
    @GetMapping("/home")
    public ModelAndView displayHomePage(ModelAndView mav) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("ログイン処理が完了しました。");
        log.info("========================================");
        log.info("ログインユーザ名: " + authentication.getName());
        log.info("========================================");

        mav.addObject("userName", authentication.getName());
        mav.setViewName("index");
        return mav;
    }
}
