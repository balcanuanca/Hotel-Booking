package Hotel.AncaBalcanu.Repository;

import Hotel.AncaBalcanu.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
