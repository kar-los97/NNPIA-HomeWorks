package cz.upce.orm_jpa.repository;

import cz.upce.orm_jpa.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRepository extends JpaRepository<Bill,Integer> {

    //vlastni jpquery dotaz
    @Query(" select b from Bill b where b.id = 1")
    Bill getBillByUser(int id);
}
