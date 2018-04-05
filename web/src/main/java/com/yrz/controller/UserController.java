package com.yrz.controller;


import com.yrz.firstspringboot.domain.User;
import com.yrz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private UserRepository userRepository ;

    @Autowired
    public  void UserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }


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
