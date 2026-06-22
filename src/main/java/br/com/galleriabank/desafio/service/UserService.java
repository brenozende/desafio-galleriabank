package br.com.galleriabank.desafio.service;

import br.com.galleriabank.desafio.exception.BusinessException;
import br.com.galleriabank.desafio.exception.ResourceNotFoundException;
import br.com.galleriabank.desafio.model.dto.request.CreateUserRequest;
import br.com.galleriabank.desafio.model.entity.User;
import br.com.galleriabank.desafio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(CreateUserRequest request) {
        if (userRepository.existsByLogin(request.login()))
            throw new BusinessException("Login already taken");

        User user = new User();
        user.setName(request.name());
        user.setLogin(request.login());
        user.setPassword(request.password());

        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public void delete(Long id) {
        User user = findById(id);
        user.setActive(false);
        userRepository.save(user);
    }
}
