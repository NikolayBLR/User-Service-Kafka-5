package org.example.service;

import org.example.dto.RequestUser;
import org.example.dto.ResponseUser;
import org.example.entity.User;
import org.example.exception.UserNotFoundException;
import org.example.mapper.UserMapperDTO;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapperDTO userMapperDTO;

    public UserService(UserRepository userRepository, UserMapperDTO userMapperDTO) {
        this.userRepository = userRepository;
        this.userMapperDTO = userMapperDTO;
    }

    public RequestUser saveUser(ResponseUser responseuser) {
        User user1 = userMapperDTO.UserMapResponse(responseuser);
        User user2 = userRepository.save(user1);
        RequestUser requestUser = userMapperDTO.UserMapRequest(user2);
        return requestUser;
    }

    public RequestUser getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Not found User"));
        RequestUser requestUser = userMapperDTO.UserMapRequest(user);
        return requestUser;
    }

    public RequestUser deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Not found User"));
        userRepository.delete(user);
        RequestUser requestUser = userMapperDTO.UserMapRequest(user);
        return requestUser;
    }

    public RequestUser updateUser(Integer id, ResponseUser user) {
        User user2 = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Not found User"));
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setAge(user.getAge());
        user2.setId(user2.getId());
        userRepository.save(user2);
        RequestUser requestUser = userMapperDTO.UserMapRequest(user2);
        return requestUser;
    }
}
