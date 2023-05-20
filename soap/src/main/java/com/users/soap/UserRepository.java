package com.users.soap;

import org.springframework.stereotype.Component;
import io.spring.guides.gs_producing_web_service.Users;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {
    private static final Map<Long, Integer> users = new HashMap<>();
    @PostConstruct
    public void initData(){
        Users c1 = new Users();
        c1.setId(1);
        c1.setFirstName("Paul");
        c1.setLastName("James");
        c1.setAge(30);
        c1.setOccupation("Software Engineer");

        users.put(c1.getId(),1);

        Users c2 = new Users();
        c2.setId(2);
        c2.setFirstName("Michelle");
        c2.setLastName("Fern");
        c2.setAge(20);
        c2.setOccupation("Project Manager");

        users.put(c2.getId(),2);
    }
    public Long findUser(Long Id) {
        Assert.notNull(Id, "The user id must not be null");
        return Users.get(Id);

    }
}
