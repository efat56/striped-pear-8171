package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentUsersSession;

@Repository
public interface SessionDAO extends JpaRepository<CurrentUsersSession, Integer>{

	public CurrentUsersSession findByUuid(String uuid);
}
