package com.App.Polling.Service;

import java.util.List;

import com.App.Polling.Entity.Vote;

public interface VoteServiceInter {

	List<String> getAllNames();

	List<Vote> geetALl();

	void recordVote(Long voteId);
}