package com.greatlearning.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatlearning.app.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	@Query(value = "select * from ticket where upper(title) like %:keyword% or upper(description) like %:keyword%", nativeQuery = true)
	List<Ticket> findByKeyword(@Param("keyword") String keyword);
}
