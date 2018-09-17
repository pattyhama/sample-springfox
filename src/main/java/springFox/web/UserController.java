package springFox.web;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

    @GetMapping(path = "user/{id}")
    @ApiOperation(value = "ユーザリソースを参照します", notes = "パラメータで指定したIDのユーザリソースを参照します")
    public User getUser(@PathVariable int id) {
        return new User("001", "ichiro");
    }

    @GetMapping(path = "users")
    public List<User> getUsers() {
        return new ArrayList<User>() {
            {
                add(new User("001", "ichiro"));
                add(new User("002", "jiro"));
                add(new User("003", "saburo"));
            }
        };
    }

    @PostMapping(path = "user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(final @Valid @RequestBody User user, final BindingResult bindingResult) {
    }

    @PutMapping(path = "user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateUser(@PathVariable int id, @Valid @RequestBody User user,
            final BindingResult bindingResult) {
    }

    @DeleteMapping(path = "user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
    }
}