package com.App.Polling.Service;

import java.util.Optional;

import com.App.Polling.Entity.User;
import com.App.Polling.DTO.LoginDTO;

public interface UserServiceInter {

	public void saveUser(User user);

	Optional<User> checkUserDetailsByUseridandPassword(LoginDTO loginDTO);

	Optional<User> findByUserid(long userId);
}