package com.builder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.builder.domain.User;
@ Repository
public interface RegisterRepository extends JpaRepository<User , Integer> {
		

}
