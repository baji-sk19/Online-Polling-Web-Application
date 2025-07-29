package com.App.Polling.Controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.App.Polling.Entity.User;
import com.App.Polling.Service.UserService;
import com.App.Polling.Service.VoteService;
import com.App.Polling.DTO.VoteRequest;

import jakarta.servlet.http.HttpSession;

@Controller
public class VoteController {
	
	

		@Autowired
		private VoteService voteService;
		@Autowired
		private UserService service;

		@PostMapping("/submit-vote")
		@ResponseBody
		public String submitVote(@RequestBody VoteRequest voteRequest, HttpSession session) {

			Long userId = (Long) session.getAttribute("loggedInUserId");
			if (userId == null) {
				return "notLoggedIn";
			}

			Optional<User> userOptional = service.findByUserid(userId);
			if (userOptional.isEmpty()) {
				return "userNotFound";
			}

			User user = userOptional.get();
			if (user.isHasVoted()) {
				return "alreadyVoted";
			}

			try {

				voteService.recordVote(voteRequest.getVoteId());

				user.setHasVoted(true);
				service.saveUser(user);

				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}

		@GetMapping("/getresult")
		public String getAllvotesdetails(Model model) {
			model.addAttribute("resiltvotes", voteService.geetALl());
			return "viewresult";
		}


}
