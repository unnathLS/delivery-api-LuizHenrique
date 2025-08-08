import com.deliverytech.delivery.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    /**
     * Busca um cliente pelo seu email.
     * 
     * @param email O email do cliente a ser buscado
     * @return O cliente entrado, ou null se não houver
     */
    Cliente findByEmail(String email);

    /**
     * Busca todos os clientes com o status ativo
     * 
     * @param ativo O status ativo do cliente
     * @return Uma lista de clientes ativos
     */
    List<Cliente> findByAtivo(boolean ativo);

}
