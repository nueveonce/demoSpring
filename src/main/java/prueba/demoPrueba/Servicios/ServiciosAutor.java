package prueba.demoPrueba.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prueba.demoPrueba.Entidades.Autor;
import prueba.demoPrueba.Repositorios.AutorRepositorio;


@Service
public class ServiciosAutor { 
    
    @Autowired
    /* indica al servidor que esta variable va ser inicializada por el servidor.
                por lo tanto no hace falta inicializar la variable para operar con ellla 
                SE LO CONOCE COMO INYECCION DE DEPENDENCIA  */
    AutorRepositorio autorRepositorio;
    @Transactional /* todos los metodos que generen modificaciones en la base de datos
                    deben establecerse como TRANSACTIONAL  esto es asi porque en caso de 
                    generar algun error*/    
    public void crearAutor(String nombre){
        
        Autor autor= new Autor();
        
        autor.setNombre(nombre);
        
        autorRepositorio.save(autor);
        
    }
    public List<Autor> listarAutores(){
        List<Autor> autores = new ArrayList();
        autores = autorRepositorio.findAll();
        return autores;
    }
    
    public void modificarAutor(String nombre, String id){
        Optional<Autor> respuestaAutor = autorRepositorio.findById(id);
        
        if (respuestaAutor.isPresent()) {
            
            Autor autor= respuestaAutor.get();
            
            autor.setNombre(nombre);
            
            autorRepositorio.save(autor);
        }
    }
            
}
