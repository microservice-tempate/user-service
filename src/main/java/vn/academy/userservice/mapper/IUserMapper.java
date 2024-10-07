package vn.academy.userservice.mapper;

import org.mapstruct.Mapper;
import vn.academy.userservice.dto.user.UserRequest;
import vn.academy.userservice.dto.user.UserResponse;
import vn.academy.userservice.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponses(List<User> users);

    User toUserFromUserRequest(UserRequest userRequest);
}
