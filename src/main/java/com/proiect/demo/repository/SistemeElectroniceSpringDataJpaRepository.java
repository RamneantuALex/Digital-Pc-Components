package com.proiect.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proiect.demo.entity.sisteme.electronice.SistemeElectronice;

public interface SistemeElectroniceSpringDataJpaRepository extends JpaRepository<SistemeElectronice, Integer>{
    List<SistemeElectronice> findByPrice(int price);

    List<SistemeElectronice> findByPromotion(boolean promotion);

    List<SistemeElectronice> findByStock(int stock);

}