package vn.academy.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.academy.userservice.entity.User;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
}
