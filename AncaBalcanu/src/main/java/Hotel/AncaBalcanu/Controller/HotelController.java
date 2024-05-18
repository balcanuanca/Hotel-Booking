package Hotel.AncaBalcanu.Controller;

import Hotel.AncaBalcanu.Model.Hotel;
import Hotel.AncaBalcanu.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public String showHotelsPage(){
        return "hotels";
    }

    @PostMapping
    public String getNearbyHotels(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radius, Model model) {
        List<Hotel> hotel = hotelService.getNearbyHotels(latitude, longitude, radius);
        model.addAttribute("hotels", hotel);
        return "redirect:hotels";
    }

    @GetMapping("/{id}")
    public String getHotelById(@PathVariable Long id, Model model) {
        Hotel hotel = hotelService.getHotelById(id);
        model.addAttribute("hotel", hotel);
        return "hotel-details";
    }
}
