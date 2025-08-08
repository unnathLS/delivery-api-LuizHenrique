import com.deliverytech.delivery.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    /**
     * Busca um restaurante pelo nome.
     * 
     * @param nome O nome do restaurante.
     * @return O restaura encontrado.
     */
    Restaurante findByNome(String nome);

    /**
     * Busca todos os restaurantes que pertencem a uma categoria.
     * 
     * @param categoria A categoria a ser buscada.
     * @return Uma lista de restaurantes da categoria.
     */
    List<Restaurante> findByCategoria(String categoria);

    /**
     * Busca todos os restaurantes ativos.
     * 
     * @returnUm lista de restaurantes ativos.
     */
    List<Restaurante> findByAtivoTrue();

    /**
     * Busca todos os restaurantes ativos e os ordena pela avaliações de forma
     * decrescente.
     * 
     * @return Uma lista de restaurantes ativos, ordenada pela avaliação.
     */
    List<Restaurante> findByAtivoTrueOrderByAvaliacaoDesc();

}
