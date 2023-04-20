package elgallinero.elgallinero.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import elgallinero.elgallinero.models.User;
import elgallinero.elgallinero.services.UserService;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
@GetMapping("")
public List<User> getUsers() {
    return service.getUsers();
}

@GetMapping("/{username}")
public ResponseEntity<User> findByUsername(@PathVariable String username) {
    User user = service.findByUsername(username);
    if (user != null) {
        return ResponseEntity.ok(user);
    } else {
        return ResponseEntity.notFound().build();
    }

}
@PostMapping(value = "")
@ResponseStatus(value = HttpStatus.CREATED)
public ResponseEntity<?> store(@RequestBody User newUser) {

try {
    return ResponseEntity.ok(service.save(newUser));
} catch (Exception e) {
    return ResponseEntity.status(500).body("error")

}
}

@PutMapping(path = "/{username}")
public ResponseEntity<?> update(@RequestBody User newUser, 
@PathVariable(value = "username") String username) {

    User user = service.update(newUser, username);
    return ResponseEntity.ok().body(user);
}

@DeleteMapping("/{username}")
public List <User> delete(@PathVariable String username) {
    return service.delete(username);
}
}