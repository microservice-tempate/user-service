package vn.academy.userservice.controller;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.academy.userservice.dto.user.UserRequest;
import vn.academy.userservice.dto.user.UserResponse;
import vn.academy.userservice.entity.User;
import vn.academy.userservice.exception.ApiException;
import vn.academy.userservice.exception.ErrorCode;
import vn.academy.userservice.mapper.IUserMapper;
import vn.academy.userservice.service.IUserService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/users")
public class UserController {
    IUserService userService;
    IUserMapper userMapper;

    @GetMapping
    public List<UserResponse> getAll() {
        return userMapper.toUserResponses(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(name = "id") UUID id) {
        return userService.findById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_EXIST));
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest userRequest) {
        User user = userService.save(userMapper.toUserFromUserRequest(userRequest));
        return userMapper.toUserResponse(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") UUID id, @RequestBody UserRequest userRequest) {
        User user = userMapper.toUserFromUserRequest(userRequest);
        user.setId(id);
        userService.save(user);
    }
}
