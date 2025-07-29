package com.App.Polling.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.App.Polling.Entity.User;
import com.App.Polling.Repository.UserRepo;
import com.App.Polling.DTO.LoginDTO;

@Service
public class UserService implements UserServiceInter {

	@Autowired
	private UserRepo repo;

	@Override
	public void saveUser(User user) {

		repo.save(user);
	}

	public Optional<User> checkUserDetailsByUseridandPassword(LoginDTO loginDTO) {
		Optional<User> user = repo.findByUseridAndPassword(loginDTO.getUserid(), loginDTO.getPassword());
		return user;
	}

	public Optional<User> findByUserid(long userId) {

		return repo.findById(userId);
	}

	

}
