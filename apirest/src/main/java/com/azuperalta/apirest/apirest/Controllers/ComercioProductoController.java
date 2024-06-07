package com.azuperalta.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.azuperalta.apirest.apirest.Entities.ComercioProducto;
import com.azuperalta.apirest.apirest.Services.ComercioProductoService;

@RestController
@RequestMapping("/comercio-producto")
public class ComercioProductoController {

    @Autowired
    private ComercioProductoService comercioProductoService;

    @GetMapping
    public List<ComercioProducto> getAllRelaciones() {
        return comercioProductoService.obtenerTodasLasRelaciones();
    }

    @GetMapping("/{id}")
    public ComercioProducto getRelacionPorId(@PathVariable Long id) {
        return comercioProductoService.obtenerRelacionPorId(id);
    }
   @PutMapping("/{id}")
    public ComercioProducto updateRelacion(@PathVariable Long id, @RequestBody ComercioProducto detallesNuevaRelacion) {
        return comercioProductoService.actualizarRelacion(id, detallesNuevaRelacion);
    }

    @DeleteMapping("/{id}")
    public String deleteRelacion(@PathVariable Long id) {
        comercioProductoService.eliminarRelacion(id);
        return "No es posible borrar relación con el ID: " + id + " ya que antes debes borrar el produto que está asociado al comercio.";
    }

    @PostMapping("/{comercioId}/productos/{productoId}")
    public ComercioProducto addProductoToComercio(@PathVariable Long comercioId, @PathVariable Long productoId) {
        return comercioProductoService.agregarProductoAComercio(comercioId, productoId);
    }
}
