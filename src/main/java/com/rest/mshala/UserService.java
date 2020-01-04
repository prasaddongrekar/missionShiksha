package com.rest.mshala;

import com.rest.mshala.model.User;
import com.rest.mshala.model.UserRequest;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User save(UserRequest userRequest);
}
