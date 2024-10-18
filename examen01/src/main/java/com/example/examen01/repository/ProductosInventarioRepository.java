package com.example.examen01.repository;

import com.example.examen01.models.ProductosInventario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosInventarioRepository extends MongoRepository<ProductosInventario, String>{
   
}
