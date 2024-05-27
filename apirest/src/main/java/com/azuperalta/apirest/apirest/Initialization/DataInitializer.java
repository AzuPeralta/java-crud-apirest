package com.azuperalta.apirest.apirest.Initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.azuperalta.apirest.apirest.Entities.Comercio;
import com.azuperalta.apirest.apirest.Repositories.ComercioRepository;

@Component
public class DataInitializer implements CommandLineRunner{

    @Autowired
    private ComercioRepository comercioRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear una instancia de Comercio
        Comercio comercio = new Comercio();
        comercio.setNombreComercio("Tienda de Ejemplo");
        comercio.setDireccion("Calle Falsa 123");

        // Guardar la instancia en la base de datos
        comercioRepository.save(comercio);

        // Verificar que la instancia se haya guardado correctamente
        System.out.println("Comercio inicializado y guardado: " + comercioRepository.findAll());
    }

}
