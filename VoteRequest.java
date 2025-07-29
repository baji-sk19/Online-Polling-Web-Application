package com.App.Polling.DTO;

import lombok.Data;

@Data

public class VoteRequest {
	private Long voteId;
	private String voteName;

	@Override
	public String toString() {
		return "VoteRequest [voteId=" + voteId + ", voteName=" + voteName + "]";
	}

	public VoteRequest(Long voteId, String voteName) {
		super();
		this.voteId = voteId;
		this.voteName = voteName;
	}

	public Long getVoteId() {
		return voteId;
	}

	public void setVoteId(Long voteId) {
		this.voteId = voteId;
	}

	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

}
