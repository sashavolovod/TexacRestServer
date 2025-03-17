package gefest.rest.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import gefest.rest.domain.Psn;
import java.util.List;

@Repository
public interface PsnViewRepo extends JpaRepository <Psn, Long> {
    /*
    @Query("SELECT DISTINCT new gefest.rest.domain.Psn(p.docNumber, p.docDate, p.orderId, p.orderNumber, p.orderDescription, p.customer, p.qty, p.unitName, p.computerName) FROM Psn p ORDER BY p.docNumber DESC, p.docDate DESC")
    List<Psn> findAllPsnWithSpecificFields();
    */
    @Query("SELECT new gefest.rest.domain.Psn(min(p.created), p.docNumber, p.docDate, p.orderId, p.orderNumber, p.orderDescription, p.customer, p.qty, p.unitName, p.computerName) FROM Psn p " +
            "GROUP BY p.docNumber, p.docDate, p.orderId, p.orderNumber, p.orderDescription, p.customer, p.qty, p.unitName, p.computerName " +
            "ORDER BY p.docNumber DESC, p.docDate DESC")
    List<Psn> findAllPsnWithSpecificFields();
}
