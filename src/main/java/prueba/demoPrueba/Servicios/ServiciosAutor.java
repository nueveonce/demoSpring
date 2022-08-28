package prueba.demoPrueba.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.demoPrueba.Entidades.Autor;
import prueba.demoPrueba.Repositorios.AutorRepositorio;

@Service
public class ServiciosAutor { 
    
    @Autowired
    /* indica al servidor que esta variable va ser inicializada por el servidor.
                por lo tanto no hace falta inicializar la variable para operar con ellla 
                SE LO CONOCE COMO INYECCION DE DEPENDENCIA  */
    AutorRepositorio autorRepositorio;
    
    public void crearAutor(String nombre){
        
        Autor autor= new Autor();
        
        autor.setNombre(nombre);
        
        autorRepositorio.save(autor);
        
    }
    
}
