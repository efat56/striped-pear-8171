package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.login.CurrentUserSession;
@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer> {
	
    public Optional<CurrentUserSession> findByCustomerId(Integer customerId) ;
	
	public Optional<CurrentUserSession> findByUuid(String uuid) ;
	

}
