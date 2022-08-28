package prueba.demoPrueba.Servicios;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.demoPrueba.Entidades.Autor;
import prueba.demoPrueba.Entidades.Editorial;
import prueba.demoPrueba.Entidades.Libro;
import prueba.demoPrueba.Repositorios.AutorRepositorio;
import prueba.demoPrueba.Repositorios.EditorialRepositorio;
import prueba.demoPrueba.Repositorios.LibroRepositorio;

@Service
public class ServiciosLibro {

    @Autowired
    /* indica al servidor que esta variable va ser inicializada por el servidor.
                por lo tanto no hace falta inicializar la variable para operar con ellla 
                SE LO CONOCE COMO INYECCION DE DEPENDENCIA  */
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    public void crearLibro(long isbn, String titulo, Integer Ejemplares, String idAutor, String idEditorial) {
        Autor autor = autorRepositorio.findById(idAutor).get(); 
        Editorial editorial = editorialRepositorio.findById(idEditorial).get();
        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(Ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);
    }

}
