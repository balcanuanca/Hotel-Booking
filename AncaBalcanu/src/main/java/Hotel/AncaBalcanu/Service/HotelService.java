package Hotel.AncaBalcanu.Service;

import Hotel.AncaBalcanu.Model.Hotel;
import Hotel.AncaBalcanu.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getNearbyHotels(double latitude, double longitude, double radius) {
        List<Hotel> allHotels = hotelRepository.findAll();

        return allHotels.stream()
                .filter(hotel -> calculateDistance(latitude, longitude, hotel.getLatitude(), hotel.getLongitude()) <= radius)
                .collect(Collectors.toList());
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in km

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = R * c;
        return dist; // convert to km
    }
}
