package CUSTOMQUERY2.repo;

import CUSTOMQUERY2.entities.Flight;
import CUSTOMQUERY2.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepo extends JpaRepository<Flight, Integer> {

    @Query("SELECT f FROM Flight f WHERE f.status IN :statuses")
    List<Flight> findByStatus(@Param("statuses") List<Status> statuses);
}