package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entites.Produit;
import com.example.demo.repos.ProduitRepository;


@SpringBootTest
class ProduitsApplicationTests {

    @Autowired
    private ProduitRepository produitRepository;

    @Test
    void testCreateProduit() {
        Produit prod = new Produit("PC Dell", 2200.50, new Date());
        produitRepository.save(prod);
    }

    @Test
    void testFindProduit() {
        Produit p = produitRepository.findById(1L).get();
        System.out.println(p);
    }

    @Test
    void testUpdateProduit() {
        Produit p = produitRepository.findById(1L).get();
        p.setPrixProduit(1000.0);
        produitRepository.save(p);
    }

    @Test
    void testDeleteProduit() {
        produitRepository.deleteById(1L);
    }

    @Test
    void testListerTousProduits() {
        List<Produit> prods = produitRepository.findAll();
        prods.forEach(System.out::println);
    }
}
