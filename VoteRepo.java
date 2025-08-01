package com.App.Polling.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.App.Polling.Entity.Vote;


@Repository
public interface VoteRepo extends JpaRepository<Vote,Long>{

	@Query("SELECT v.partname FROM Vote v")
    List<String> findAllPartnames();

	
}