package com.yrz.firstspringboot.config;


import com.yrz.firstspringboot.domain.User;
import com.yrz.firstspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

@Configuration
public class RouterFunctionConfigration {


    @Bean
    @Autowired
    public RouterFunction<ServerResponse> findAllPerson(UserRepository userRepository){

        return  RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request ->{
                    Collection<User>  users = userRepository.findAll();
                    Flux<User> userFlux = Flux. fromIterable(users);
                    return  ServerResponse.ok().body(userFlux,User.class);
                });
    }

}
