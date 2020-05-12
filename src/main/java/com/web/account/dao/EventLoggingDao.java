package com.web.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.account.model.EventLogging;

public interface EventLoggingDao extends JpaRepository<EventLogging, String> {

}
