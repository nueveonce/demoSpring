package prueba.demoPrueba.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prueba.demoPrueba.Entidades.Editorial;
import prueba.demoPrueba.Repositorios.EditorialRepositorio;

@Service
public class ServiciosEditorial {

    @Autowired
    /* indica al servidor que esta variable va ser inicializada por el servidor.
                por lo tanto no hace falta inicializar la variable para operar con ellla 
                SE LO CONOCE COMO INYECCION DE DEPENDENCIA  */
    EditorialRepositorio editorialRepositorio;

    @Transactional
    /* todos los metodos que generen modificaciones en la base de datos
                    deben establecerse como TRANSACTIONAL  esto es asi porque en caso de 
                    generar algun error*/
    public void crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

    public List<Editorial> listarEditoriales() {
        List<Editorial> editoriales = new ArrayList();
        editoriales = editorialRepositorio.findAll();
        return editoriales;
    }

    public void modificarEditorial(String id, String nombre) {
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(id);

        if (respuestaEditorial.isPresent()) {
            Editorial editorial = respuestaEditorial.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }

    }
}
