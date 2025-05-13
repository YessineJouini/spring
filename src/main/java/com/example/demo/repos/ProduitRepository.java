package com.example.demo.repos;
import org.springframework.data.domain.Page;         // ✅ Correct import
import org.springframework.data.domain.Pageable; 
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entites.Categorie;
import com.example.demo.entites.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
    // Basic query by name
    List<Produit> findByNomProduit(String nom);
    
    // Like query
    List<Produit> findByNomProduitContains(String nom);
    
    // Custom JPQL with parameters
    @Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
    List<Produit> findByNomPrix(String nom, Double prix);

   
    // Query by Category entity
    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategorie(Categorie categorie);
    
    // Query by Category ID
    List<Produit> findByCategorieIdCat(Long id);
    
    // Sort by product name
    List<Produit> findByOrderByNomProduitAsc();
    
    // Sort by name ascending and price descending
    @Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
    List<Produit> trierProduitsNomsPrix();
    
    Page<Produit> findAll(Pageable pageable); // ✅ Should be okay if Pageable is correct
}