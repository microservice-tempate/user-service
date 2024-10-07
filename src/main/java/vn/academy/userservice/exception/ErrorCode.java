package vn.academy.userservice.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    USER_NOT_EXIST(40401, "User is not exist.", HttpStatus.NOT_FOUND),
    ;

    Integer code;
    String message;
    HttpStatus status;
}
