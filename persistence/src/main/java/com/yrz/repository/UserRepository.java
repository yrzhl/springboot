package com.yrz.repository;


import com.yrz.firstspringboot.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


/***
 * {@link User}
 */
@Repository
public class UserRepository {


    private final ConcurrentHashMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();


    /**
     * 保存
     * @param user
     * @return
     */
    public boolean save(User user) {

        Integer id = idGenerator.incrementAndGet();
        user.setId(id);

        return repository.put(id, user) == null;
    }



    public Collection<User> findAll(){

        return repository.values();

    }




}
