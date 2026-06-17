public class Reservation {

    private String bookingId;

    private Customer customer;

    private Room room;

    private String paymentStatus;

    private String reservationStatus;

    public Reservation(
            String bookingId,
            Customer customer,
            Room room,
            String paymentStatus,
            String reservationStatus) {

        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.paymentStatus = paymentStatus;
        this.reservationStatus = reservationStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(
            String reservationStatus) {

        this.reservationStatus =
                reservationStatus;
    }

    @Override
    public String toString() {

        return bookingId + "," +

                customer.getCustomerId() + "," +

                customer.getName() + "," +

                customer.getMobile() + "," +

                customer.getEmail() + "," +

                customer.getAdults() + "," +

                customer.getChildren() + "," +

                customer.getBookingType() + "," +

                room.getRoomNumber() + "," +

                room.getCategory() + "," +

                room.getPrice() + "," +

                paymentStatus + "," +

                reservationStatus;
    }
}
