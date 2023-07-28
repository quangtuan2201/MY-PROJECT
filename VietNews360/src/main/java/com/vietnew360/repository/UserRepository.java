package com.vietnew360.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vietnew360.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndStatus(String name , int status);
}
