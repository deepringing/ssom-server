package com.ullim.ssomserver.domain.user.facade;

import com.ullim.ssomserver.domain.user.domain.Repository.UserRepository;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.exception.UserAlreadyExistsException;
import com.ullim.ssomserver.domain.user.exception.UserNotFoundException;
import com.ullim.ssomserver.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    @Transactional
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    @Transactional
    public void validateExistsByEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

    public User getCurrentUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.getUser();
    }


}
