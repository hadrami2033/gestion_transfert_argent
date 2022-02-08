package com.example.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query("select c from Client c where c.Nom like :x")
	public List<Client> chercheClient(@Param("x") String Nom);
	
}
