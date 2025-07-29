package com.App.Polling.Controller;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.*;

	import com.App.Polling.Entity.User;
	import com.App.Polling.Service.UserService;
	import com.App.Polling.Service.VoteService;
	import com.App.Polling.DTO.LoginDTO;

	import jakarta.servlet.http.HttpSession;

	@Controller
	public class UserController {

	    @Autowired
	    private UserService service;

	    @Autowired
	    private VoteService voteservice;

	    @GetMapping("/home")
	    public String getHomepage() {
	        return "index";
	    }

	    @GetMapping("/register")
	    public String showRegistrationForm() {
	        return "registerpage";
	    }

	    @PostMapping("/register")
	    @ResponseBody
	    public ResponseEntity<Map<String, String>> registerUser(@ModelAttribute User user) {
	        Map<String, String> response = new HashMap<>();
	        try {
	            service.saveUser(user);
	            response.put("status", "success");
	        } catch (Exception e) {
	            response.put("status", "failure");
	        }
	        return ResponseEntity.ok(response);
	    }

	    @GetMapping("/getLoginpage")
	    public String getLoginPage() {
	        return "Loginform";
	    }

	    @PostMapping("/login")
	    @ResponseBody
	    public String checkLoginDetails(@RequestParam String userid, @RequestParam String password, HttpSession session) {
	        LoginDTO loginDTO = new LoginDTO(userid, password);
	        Optional<User> userOptional = service.checkUserDetailsByUseridandPassword(loginDTO);

	        if (userOptional.isPresent()) {
	            session.setAttribute("isLoggedIn", true);
	            session.setAttribute("loggedInUserId", userOptional.get().getId());
	            return "loggedIn";
	        } else {
	            return "notloggedIn";
	        }
	    }

	    @GetMapping("/logout")
	    public String logoutmyac(HttpSession session) {
	        session.invalidate();
	        return "redirect:/";
	    }

	    @GetMapping("/Polewindow")
	    public String getPoleWindow(HttpSession session, Model model) {
	        Long userId = (Long) session.getAttribute("loggedInUserId");
	        if (userId == null) {
	            return "redirect:/getLoginpage";
	        }

	        Optional<User> userOptional = service.findByUserid(userId);
	        if (userOptional.isEmpty()) {
	            return "redirect:/getLoginpage";
	        }

	        User user = userOptional.get();
	        model.addAttribute("hasVoted", user.isHasVoted());
	        model.addAttribute("allvotes", voteservice.geetALl());
	        return "Polewindow";
	    }

	    @GetMapping("/check-login-status")
	    @ResponseBody
	    public String checkLoginStatus(HttpSession session) {
	        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
	        return (isLoggedIn != null && isLoggedIn) ? "loggedIn" : "notLoggedIn";
	    }

	    @GetMapping("/checkLoginStatus")
	    @ResponseBody
	    public boolean checkLoginStatusforbuttons(HttpSession session) {
	        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
	        return Boolean.TRUE.equals(isLoggedIn);
	    }
	}
