package com.example.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entities.Opperation;

public interface OperationRepository extends JpaRepository<Opperation, Long>{

	@Query("select o from Opperation o where o.compte.CodeCompte=:x order by o.DateOpperation desc")
	public Page<Opperation> listOperation(@Param("x")String codeCompte,Pageable pageable);
}
