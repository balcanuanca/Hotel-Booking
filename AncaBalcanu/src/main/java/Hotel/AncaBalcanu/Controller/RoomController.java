package Hotel.AncaBalcanu.Controller;

import Hotel.AncaBalcanu.Model.Room;
import Hotel.AncaBalcanu.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/{id}/book")
    public String bookRoom(@PathVariable Long id, Model model) {
        Room room = roomService.bookRoom(id);
        model.addAttribute("room", room);
        return "booking";
    }

    @PostMapping("/{id}/cancel")
    public String cancelBooking(@PathVariable Long id, Model model) {
        Room room = roomService.cancelBooking(id);
        model.addAttribute("room", room);
        return "booking";
    }

//    @PostMapping("/{id}/feedback")
//    public String leaveFeedback(@PathVariable Long id, @RequestParam String feedback, Model model) {
//        Room room = roomService.leaveFeedback(id, feedback);
//        model.addAttribute("room", room);
//        return "booking";
//    }
}
