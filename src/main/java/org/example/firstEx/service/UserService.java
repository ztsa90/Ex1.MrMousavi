package org.example.firstEx.service;

import org.example.firstEx.model.User;
import org.example.firstEx.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("Not found id");
        }
        return optionalUser.get();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User update(User user) {
        Long lastId = user.getId();
        Optional<User> optionalUser = userRepository.findById(lastId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("no found id.");
        }
        User lastUser = getById(lastId);

        String newFirstName = lastUser.getFirstName();
        String newLastName = lastUser.getLastName();
        String newUsername = lastUser.getUsername();
        String newPassword = lastUser.getPassword();
        Boolean newActive = lastUser.getActive();

        lastUser.setFirstName(newFirstName);
        lastUser.setLastName(newLastName);
        lastUser.setUsername(newUsername);
        lastUser.setPassword(newPassword);
        lastUser.setActive(newActive);
        User newUser = userRepository.save(lastUser);

        return lastUser;
    }
}
