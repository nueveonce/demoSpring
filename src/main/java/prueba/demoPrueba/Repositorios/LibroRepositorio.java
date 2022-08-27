package prueba.demoPrueba.Repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import prueba.demoPrueba.Entidades.Libro;

@Repository 
public interface LibroRepositorio extends JpaRepository<Libro, Long>{
    @Query("SELEC l FROM Libro l WHERE l.titulo = : titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo);
    
    @Query("SELECT l FROM Ligro l WHERE l.autor.nombre = :nombre")
    public List<Libro> buscarPorAutor(@Param("nombre") String nombre);
    
}
