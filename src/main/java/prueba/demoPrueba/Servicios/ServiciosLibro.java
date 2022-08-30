package prueba.demoPrueba.Servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prueba.demoPrueba.Entidades.Autor;
import prueba.demoPrueba.Entidades.Editorial;
import prueba.demoPrueba.Entidades.Libro;
import prueba.demoPrueba.Repositorios.AutorRepositorio;
import prueba.demoPrueba.Repositorios.EditorialRepositorio;
import prueba.demoPrueba.Repositorios.LibroRepositorio;
import prueba.demoPrueba.excepciones.MiException;

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

    @Transactional
    /* todos los metodos que generen modificaciones en la base de datos
                    deben establecerse como TRANSACTIONAL  esto es asi porque en caso de 
                    generar algun error*/
    public void crearLibro(long isbn, String titulo, Integer Ejemplares, String idAutor, String idEditorial) throws MiException {
        validarDatos(isbn, titulo, Ejemplares, idAutor, idEditorial);
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

    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList();
        libros = libroRepositorio.findAll();
        return libros;
    }

    public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException {
        validarDatos(isbn, titulo, ejemplares, idAutor, idEditorial);

        /*OPTIONAL: es un objeto contenedor, que puede o no tener un valor no NULL 
            si el valor esta presente nos devuelve TRUE
         */
        Optional<Libro> respuestaLibro = libroRepositorio.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);

        Autor autor = new Autor();
        Editorial editorial = new Editorial();

        if (respuestaAutor.isPresent()) {
            autor = respuestaAutor.get();
        }
        if (respuestaEditorial.isPresent()) {
            editorial = respuestaEditorial.get();

        }

        if (respuestaLibro.isPresent()) {
            
            Libro libro = respuestaLibro.get();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);     
            
            libroRepositorio.save(libro);
        }
    }
    private void validarDatos(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException{
    
        if (isbn==null) {
            throw  new MiException("el ISBN no puede ser nulo");
        }
        if (titulo==null|| titulo.isEmpty()) {
            throw new MiException("el titulo no puede ser nulo o estar vacio");            
        }
        if (ejemplares==null) {
            throw new MiException("ejemplares no pueden ser nulos");
            
        }
        if (idAutor==null|| idAutor.isEmpty()) {
            throw new MiException("El idAutor no puede ser nulo o estar vacio");
            
        }
        if (idEditorial==null||idEditorial.isEmpty()) {
            throw new MiException("el idEditorial no piede ser nulo o estar vacio");
            
        }
            
        }
}
