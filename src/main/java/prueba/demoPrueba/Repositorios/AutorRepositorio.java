
package prueba.demoPrueba.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.demoPrueba.Entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String>{
    
}
