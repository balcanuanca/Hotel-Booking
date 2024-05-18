package Hotel.AncaBalcanu;

import Hotel.AncaBalcanu.Model.Hotel;
import Hotel.AncaBalcanu.Repository.HotelRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Hotel> hotels = mapper.readValue(new ClassPathResource("json/Hotels.json").getInputStream(), new TypeReference<List<Hotel>>() {});
        hotelRepository.saveAll(hotels);
    }
}
