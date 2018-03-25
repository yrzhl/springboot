package com.yrz.firstspringboot.controller;


import com.yrz.firstspringboot.domain.User;
import com.yrz.firstspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository ;


    @PostMapping("/person/save")
    public User save(@RequestParam  String name){

        User user = new User();
        user.setName(name);


        System.out.println(userRepository.hashCode()+"--------------");

        if (userRepository.save(user)){
            System.out.println("保存用户成功！"+user);
            System.out.println();
        }
        return  user;
    }



    @GetMapping("/getHello")
    public  String getHello(){
        return  "helloyrz";
    }


}
