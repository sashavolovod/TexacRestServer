package gefest.rest.repo;

import gefest.rest.domain.LocksmithOperationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface LocksmithOperationViewRepository extends JpaRepository<LocksmithOperationView, Long> {

    /**
     * Возвращает суммарную норму времени по категориям за указанный период
     *
     * @param startDate начальная дата периода
     * @param endDate конечная дата периода
     * @return список объектов LocksmithOperationsView с заполненными полями categoryName и timeNorm
     */
    @Query("SELECT new LocksmithOperationView(l.categoryName, SUM(l.timeNorm)) " +
            "FROM LocksmithOperationView l " +
            "WHERE l.orderDate BETWEEN :startDate AND :endDate " +
            "GROUP BY l.categoryName " +
            "ORDER BY l.categoryName")
    List<LocksmithOperationView> getSumTimeNormByCategories(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    /**
     * Возвращает суммарную норму времени сгруппированную по категориям и слесарям за указанный период
     *
     * @param startDate начальная дата периода
     * @param endDate конечная дата периода
     * @return список объектов с данными по категориям, слесарям и суммарной нормой времени
     */
    @Query("SELECT new LocksmithOperationView(l.categoryName, l.locksmithName, SUM(l.timeNorm)) " +
            "FROM LocksmithOperationView l " +
            "WHERE l.orderDate BETWEEN :startDate AND :endDate " +
            "GROUP BY l.categoryName, l.locksmithName " +
            "ORDER BY l.categoryName, l.locksmithName")
    List<LocksmithOperationView> getSumTimeNormByCategoriesAndLocksmiths(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    /**
     * Возвращает суммарную норму времени сгруппированную по категориям и заказчикам за указанный период
     *
     * @param startDate начальная дата периода
     * @param endDate конечная дата периода
     * @return список объектов с данными по категориям, заказчикам и суммарной нормой времени
     */
    @Query("SELECT new LocksmithOperationView(l.categoryName, SUM(l.timeNorm), l.customerTitle) " +
            "FROM LocksmithOperationView l " +
            "WHERE l.orderDate BETWEEN :startDate AND :endDate " +
            "GROUP BY l.categoryName, l.customerTitle " +
            "ORDER BY l.categoryName, l.customerTitle")
    List<LocksmithOperationView> getSumTimeNormByCategoriesAndCustomers(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}