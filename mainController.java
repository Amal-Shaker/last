/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exprine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rant
 */
@RestController
public class mainController {
    @RequestMapping("/show")
    public String Index(){
        return String.format("%s", "welcome to jpa");
    }
    
}
