package elgallinero.elgallinero.services;


import java.util.List;

import org.springframework.stereotype.Service;

import elgallinero.elgallinero.models.User;
import elgallinero.elgallinero.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }

    public User save(User user) {
        User userSaved = repository.save(user);
        return userSaved ;
    }

    public User update(User user, String username) {
        User userCurrent = repository.findByUsername(username).orElseThrow();

        userCurrent.setUsername(user.getUsername());

    
        return repository.save(userCurrent);
    }

    public List<User> delete(String username) {

        User userToDelete = repository.findByUsername(username).orElse(null);
        repository.delete(userToDelete);
        return repository.findAll();
    }
}