package com.fortunebara.fortune_bara_backend.repository;

import com.fortunebara.fortune_bara_backend.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {}
