package com.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
