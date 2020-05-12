package com.web.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.account.entity.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, String> {

}
