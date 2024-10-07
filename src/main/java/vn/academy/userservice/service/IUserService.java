package vn.academy.userservice.service;

import vn.academy.userservice.dto.user.ResetPasswordRequest;
import vn.academy.userservice.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {
    User save(User user);

    void updatePassword(ResetPasswordRequest resetPasswordRequest);

    void delete(UUID id);

    List<User> getAll();

    Optional<User> findById(UUID id);
}