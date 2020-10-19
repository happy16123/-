package com.cloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.domain.UserDto;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDto, String> {

	public UserDto findByUsername(String username);

}
