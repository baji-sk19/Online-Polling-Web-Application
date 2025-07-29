package com.App.Polling.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data

public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String partname;
	private long count;

	@Override
	public String toString() {
		return "Vote [id=" + id + ", partname=" + partname + ", count=" + count + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartname() {
		return partname;
	}

	public void setPartname(String partname) {
		this.partname = partname;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Vote() {
		super();
	}

	public Vote(long id, String partname, long count) {
		super();
		this.id = id;
		this.partname = partname;
		this.count = count;
	}

}
