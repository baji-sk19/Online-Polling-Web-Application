package com.App.Polling.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.Polling.Entity.Vote;
import com.App.Polling.Repository.VoteRepo;

@Service
public class VoteService implements VoteServiceInter {

	@Autowired
	private VoteRepo repo;

	@Override
	public List<String> getAllNames() {
		return repo.findAllPartnames();

	}

	@Override
	public List<Vote> geetALl() {
		return repo.findAll();
	}

	@Override
	public void recordVote(Long voteId) {
		// Add logic to save the vote
		Optional<Vote> voteOptional = repo.findById(voteId);
		if (voteOptional.isPresent()) {
			Vote vote = voteOptional.get();
			vote.setCount(vote.getCount() + 1); // Increment the vote count
			repo.save(vote);
		} else {
			throw new RuntimeException("Vote ID not found");
		}
	}

}