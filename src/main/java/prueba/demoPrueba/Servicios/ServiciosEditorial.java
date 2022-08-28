package prueba.demoPrueba.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.demoPrueba.Entidades.Editorial;
import prueba.demoPrueba.Repositorios.EditorialRepositorio;

@Service 
public class ServiciosEditorial {
    @Autowired
            /* indica al servidor que esta variable va ser inicializada por el servidor.
                por lo tanto no hace falta inicializar la variable para operar con ellla 
                SE LO CONOCE COMO INYECCION DE DEPENDENCIA  */
    EditorialRepositorio editorialRepositorio;
    
    public void crearEditorial(String nombre){
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        
        editorialRepositorio.save(editorial);
    }
    
}
