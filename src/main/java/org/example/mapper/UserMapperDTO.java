package org.example.mapper;

import org.example.dto.RequestUser;
import org.example.dto.ResponseUser;
import org.example.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperDTO {

    public RequestUser UserMapRequest (User user) {
       RequestUser requestUser = new RequestUser(user.getName());
       return requestUser;
    }

    public User UserMapResponse (ResponseUser responseUser) {
        User user = new User();
        user.setName(responseUser.getName());
        user.setEmail(responseUser.getEmail());
        user.setAge(responseUser.getAge());
        return user;
    }
}
