package hello.springmvc.basic.requestmappin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String user() {
        return " get users";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    @GetMapping("/{userId}")
    public String UpdateUser(@PathVariable String userId) {
        return "update userId=" + userId;
    }

    @PatchMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "find userId=" + userId;
    }

    @DeleteMapping("{userId}")
    public String DeleteUser(@PathVariable String userId) {
        return "delete userId=" + userId;
    }


}

