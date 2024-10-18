package com.example.examen01.controllers;

import com.example.examen01.models.ProductosInventario;
import com.example.examen01.services.ProductosInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductosInventarioController {

    @Autowired
    private ProductosInventarioService productosInventarioService;

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<ProductosInventario> crearProducto(@RequestBody ProductosInventario producto) {
        ProductosInventario nuevoProducto = productosInventarioService.guardar(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<ProductosInventario>> obtenerTodos() {
        List<ProductosInventario> productos = productosInventarioService.obtenerTodos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductosInventario> obtenerPorId(@PathVariable String id) {
        ProductosInventario producto = productosInventarioService.obtenerPorId(id);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<ProductosInventario> actualizarProducto(@PathVariable String id, @RequestBody ProductosInventario productoActualizado) {
        // Asignar el ID del producto actualizado
        productoActualizado.setId(id);
        ProductosInventario producto = productosInventarioService.actualizar(productoActualizado);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String id) {
        productosInventarioService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
