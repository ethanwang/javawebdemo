
package com.wkp.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    
    @Value("${app-mode}")
    private String appMode;
    private String appName;
                
    public ViewController(Environment environment){
        appName=environment.getProperty("app-Name");
        
    }
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
         model.addAttribute("username", "Chinese Coder");      
         model.addAttribute("appMode", appMode);
         model.addAttribute("appName", appName);
        return "index";
    }
}
