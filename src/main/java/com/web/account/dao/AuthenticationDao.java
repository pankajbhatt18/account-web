package com.web.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.account.entity.Login;

public interface AuthenticationDao extends JpaRepository<Login, String> {

}
