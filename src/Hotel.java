
import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Room> rooms;

    public Hotel() {

        rooms = new ArrayList<>();

        // Floor 1 - Standard

        rooms.add(new Room(
                101,
                "Standard",
                3,
                1500,
                true,
                1,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV"));

        rooms.add(new Room(
                102,
                "Standard",
                3,
                1500,
                true,
                1,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV"));

        rooms.add(new Room(
                103,
                "Standard",
                3,
                1500,
                true,
                1,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV"));

        rooms.add(new Room(
                104,
                "Standard",
                3,
                1500,
                true,
                1,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV"));

        rooms.add(new Room(
                105,
                "Standard",
                3,
                1500,
                true,
                1,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV"));

        // Floor 2 - Deluxe

        rooms.add(new Room(
                201,
                "Deluxe",
                4,
                2500,
                true,
                2,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast"));

        rooms.add(new Room(
                202,
                "Deluxe",
                4,
                2500,
                true,
                2,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast"));

        rooms.add(new Room(
                203,
                "Deluxe",
                4,
                2500,
                true,
                2,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast"));

        rooms.add(new Room(
                204,
                "Deluxe",
                4,
                2500,
                true,
                2,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast"));

        rooms.add(new Room(
                205,
                "Deluxe",
                4,
                2500,
                true,
                2,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast"));

        // Floor 3 - Suite

        rooms.add(new Room(
                301,
                "Suite",
                5,
                4500,
                true,
                3,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast, Mini Bar"));

        rooms.add(new Room(
                302,
                "Suite",
                5,
                4500,
                true,
                3,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast, Mini Bar"));

        rooms.add(new Room(
                303,
                "Suite",
                5,
                4500,
                true,
                3,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast, Mini Bar"));

        rooms.add(new Room(
                304,
                "Suite",
                5,
                4500,
                true,
                3,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast, Mini Bar"));

        rooms.add(new Room(
                305,
                "Suite",
                5,
                4500,
                true,
                3,
                "Royal Grand Hotel ★★★★★",
                "AC, WiFi, TV, Breakfast, Mini Bar"));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room findRoom(int roomNumber) {

        for(Room room : rooms) {

            if(room.getRoomNumber()
                    == roomNumber) {

                return room;
            }
        }

        return null;
    }
}
