public class Room {

    private int roomNumber;
    private String category;
    private int rating;
    private double price;
    private boolean available;
    private int floor;
    private String hotelName;

    private String facilities;

    public Room(
            int roomNumber,
            String category,
            int rating,
            double price,
            boolean available,
            int floor,
            String hotelName,
            String facilities) {

        this.roomNumber = roomNumber;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.available = available;
        this.floor = floor;
        this.hotelName = hotelName;
        this.facilities = facilities;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getFloor() {
        return floor;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
