package Hotel.AncaBalcanu.Service;

import Hotel.AncaBalcanu.Model.Room;
import Hotel.AncaBalcanu.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room bookRoom(Long id) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            roomRepository.save(room);
        }
        return room;
    }

    public Room cancelBooking(Long id) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room != null && !room.isAvailable()) {
            room.setAvailable(true);
            roomRepository.save(room);
        }
        return room;
    }

//    public Room leaveFeedback(Long id, String feedback) {
//        return roomRepository.findById(id).orElse(null);
//    }
}
