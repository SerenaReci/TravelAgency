package com.sda.TravelAgency.service;

import com.sda.TravelAgency.dtos.userDtos.CreateUserDto;
import com.sda.TravelAgency.dtos.userDtos.ResponseUserDto;
import com.sda.TravelAgency.entity.User;
import com.sda.TravelAgency.mapper.UserMapper;
import com.sda.TravelAgency.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
    public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    public ResponseUserDto save(CreateUserDto createUserDto) {
        User userEntity = userMapper.mapToUser(createUserDto);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        User savedUser = userRepository.save(userEntity);
        return userMapper.mapToResponseUserDto(savedUser);
        }

        public ResponseUserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.mapToResponseUserDto(user);
        }

        public List<ResponseUserDto> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::mapToResponseUserDto)
                .toList();
        }

        public ResponseUserDto update(Long id, CreateUserDto createUserDto) {
            User userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
            userEntity.setId(id);
            userEntity.setUsername(createUserDto.getUsername());
            userEntity.setEmail(createUserDto.getEmail());
            User savedUser = userRepository.save(userEntity);
            return userMapper.mapToResponseUserDto(savedUser);
        }

        public void deleteById(Long id) {
            userRepository.deleteById(id);
        }

    }

