package Hotel.AncaBalcanu.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double latitude;
    private double longitude;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Room> rooms;

}
