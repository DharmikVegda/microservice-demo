package com.example.securityservice.repository;

import com.example.securityservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "USER-SERVICE")
public interface UserRepository  {

    @RequestMapping(method = RequestMethod.GET, value = "/api/user/")
    List<User> findAllUser();

    @RequestMapping(method = RequestMethod.GET, value = "/api/user/{username}")
    Optional<User> findUserByUsername(@PathVariable String username);

    @RequestMapping(method = RequestMethod.POST, value = "/api/user/")
    User save(@RequestBody User user);

    @RequestMapping(method = RequestMethod.GET, value = "/api/home")
    String welcome();
}
