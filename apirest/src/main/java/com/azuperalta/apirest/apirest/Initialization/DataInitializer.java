package com.azuperalta.apirest.apirest.Initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.azuperalta.apirest.apirest.Entities.Comercio;
import com.azuperalta.apirest.apirest.Entities.ComercioProducto;
import com.azuperalta.apirest.apirest.Entities.Producto;
import com.azuperalta.apirest.apirest.Repositories.ComercioRepository;
import com.azuperalta.apirest.apirest.Repositories.ProductoRepository;

@Profile("dev")
@Component
public class DataInitializer implements CommandLineRunner{

    @Autowired
    private ComercioRepository comercioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear una instancia de Comercio y una de producto
        Comercio comercio = new Comercio();
        comercio.setNombreComercio("Tienda nueva");
        comercio.setDireccion("Calle Falsa 567");

        Producto producto = new Producto();
        producto.setNombre("Producto de prueba 1");
        producto.setPrecio(189.99);

        //Crear relacion ComercioProducto
        ComercioProducto comercioProducto = new ComercioProducto();
        comercioProducto.setComercio(comercio);
        comercioProducto.setProducto(producto);

        // Establecer la relación
        comercio.getComercioProductos().add(comercioProducto);
        producto.getComercioProductos().add(comercioProducto);


        // Guardar la instancia en la base de datos
        comercioRepository.save(comercio);
        productoRepository.save(producto);

        // Verificar que la instancia se haya guardado correctamente
        System.out.println("Comercio inicializado y guardado: " + comercioRepository.findAll());
        System.out.println("Producto inicializado y guardado: " + productoRepository.findAll());

    }

}
