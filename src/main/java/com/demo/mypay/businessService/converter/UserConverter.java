package com.demo.mypay.businessService.converter;

import com.demo.mypay.api.dto.UserDto;
import com.demo.mypay.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setDob(userDto.getDob());
        return user;
    }

    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNo(user.getPhoneNo());
        userDto.setDob(user.getDob());
        userDto.setRegisteredDateTime(user.getRegisteredDateTime());
        return userDto;
    }
}
