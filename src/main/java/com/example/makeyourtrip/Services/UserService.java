package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Models.User;
import com.example.makeyourtrip.Repositories.UserRepository;
import com.example.makeyourtrip.RequestDtos.AddUserDto;
import com.example.makeyourtrip.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;


    public String addUser(AddUserDto addUserDto) {
        User user = UserTransformer.convertDtoToEntity(addUserDto);
        userRepository.save(user);
        return "User added successfully";
    }
}
