package repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import entity.sisteme.electronice.SistemeElectronice;
public interface SistemeElectroniceJPARepository extends JpaRepository<SistemeElectronice, Integer>{
    List<SistemeElectronice> findByPrice(int price);

    List<SistemeElectronice> findByPromotion(boolean promotion);

    List<SistemeElectronice> findByStock(int stock);

}