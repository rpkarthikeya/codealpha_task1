public class Customer {

    private String customerId;
    private String name;
    private String mobile;
    private String email;

    private int adults;
    private int children;

    private String bookingType;

    public Customer(
            String customerId,
            String name,
            String mobile,
            String email,
            int adults,
            int children,
            String bookingType) {

        this.customerId = customerId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.adults = adults;
        this.children = children;
        this.bookingType = bookingType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public String getBookingType() {
        return bookingType;
    }
}
