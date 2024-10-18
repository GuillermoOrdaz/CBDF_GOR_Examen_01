package com.example.examen01.services;

import com.example.examen01.models.ProductosInventario;
import com.example.examen01.repository.ProductosInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductosInventarioService {
    @Autowired
    private ProductosInventarioRepository productosInventarioRepository;

    public ProductosInventario guardar(ProductosInventario producto) {
        return productosInventarioRepository.save(producto);
    }

    public List<ProductosInventario> obtenerTodos() {
        return productosInventarioRepository.findAll();
    }

    public ProductosInventario obtenerPorId(String id) {
        Optional<ProductosInventario> producto = productosInventarioRepository.findById(id);
        return producto.orElse(null);
    }

    public void eliminar(String id) {
        productosInventarioRepository.deleteById(id);
    }

    public ProductosInventario actualizar(ProductosInventario producto) {
        if (productosInventarioRepository.existsById(producto.getId())) {
            return productosInventarioRepository.save(producto);
        } else {
            return null; // Manejar el error según sea necesario
        }
    }
}
