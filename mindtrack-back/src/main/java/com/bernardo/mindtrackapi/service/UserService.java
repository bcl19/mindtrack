package com.bernardo.mindtrackapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardo.mindtrackapi.exception.UserException;
import com.bernardo.mindtrackapi.model.User;
import com.bernardo.mindtrackapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Criar usuário
    public User createUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserException("Email já cadastrado");
        }

        return userRepository.save(user);
    }

    // Listar todos
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Buscar por ID
    @SuppressWarnings("null")
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException("Usuário não encontrado"));
    }

    // Atualizar usuário
    public User updateUser(Long id, User userDetails) {

        @SuppressWarnings("null")
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException("Usuário não encontrado"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    // Deletar usuário
    @SuppressWarnings("null")
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException("Usuário não encontrado"));

        userRepository.delete(user);
    }
}