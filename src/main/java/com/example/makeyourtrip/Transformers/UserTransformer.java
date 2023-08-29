package com.example.makeyourtrip.Transformers;

import com.example.makeyourtrip.Models.User;
import com.example.makeyourtrip.RequestDtos.AddUserDto;

public class UserTransformer {

    public static User convertDtoToEntity(AddUserDto addUserDto)
    {
        User user = User.builder()
                .name(addUserDto.getName())
                .emailId(addUserDto.getEmailId())
                .age(addUserDto.getAge()).build();

        return user;
    }
}
