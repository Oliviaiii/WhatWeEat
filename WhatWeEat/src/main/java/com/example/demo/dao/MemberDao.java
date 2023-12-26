package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Member;


@Repository
public interface MemberDao extends JpaRepository<Member,Integer> {

	public boolean existsByUsername(String username);
	public boolean existsByName(String name);
	public Member findByUsernameAndPassword(String username,String password);
}
