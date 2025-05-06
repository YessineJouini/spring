package com.example.demo.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Produit;
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}