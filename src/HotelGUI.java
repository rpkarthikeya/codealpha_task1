import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class HotelGUI extends JFrame {

    private Hotel hotel;

    private JPanel floor1Panel;
    private JPanel floor2Panel;
    private JPanel floor3Panel;

    private HashMap<Integer,
            JButton> roomButtons;

    private ArrayList<Reservation>
            reservations;

    private JLabel availableLabel;
    private JLabel bookedLabel;
    private JLabel revenueLabel;

    private double totalRevenue = 0;

    public HotelGUI() {

        hotel = new Hotel();

        reservations =
                new ArrayList<>();

        roomButtons =
                new HashMap<>();

        setTitle(
                "Royal Grand Hotel ★★★★★");

        setSize(
                1200,
                800);

        setLocationRelativeTo(
                null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLayout(
                new BorderLayout());

        JLabel title =
                new JLabel(
                        "ROYAL GRAND HOTEL ★★★★★",
                        SwingConstants.CENTER);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28));

        add(
                title,
                BorderLayout.NORTH);

        JPanel dashboard =
                new JPanel(
                        new GridLayout(
                                1,
                                3));

        availableLabel =
                new JLabel(
                        "Available : 15",
                        SwingConstants.CENTER);

        bookedLabel =
                new JLabel(
                        "Booked : 0",
                        SwingConstants.CENTER);

        revenueLabel =
                new JLabel(
                        "Revenue : ₹0",
                        SwingConstants.CENTER);

        dashboard.add(
                availableLabel);

        dashboard.add(
                bookedLabel);

        dashboard.add(
                revenueLabel);

        add(
                dashboard,
                BorderLayout.SOUTH);
        add(
                dashboard,
                BorderLayout.SOUTH);
        JPanel centerPanel =
                new JPanel();

        centerPanel.setLayout(
                new GridLayout(
                        3,
                        1,
                        10,
                        10));

        floor1Panel =
                createFloorPanel(
                        "Floor 1 - Standard Rooms");

        floor2Panel =
                createFloorPanel(
                        "Floor 2 - Deluxe Rooms");

        floor3Panel =
                createFloorPanel(
                        "Floor 3 - Suite Rooms");

        centerPanel.add(
                floor1Panel);

        centerPanel.add(
                floor2Panel);

        centerPanel.add(
                floor3Panel);

        add(
                centerPanel,
                BorderLayout.CENTER);

        JPanel buttonPanel =
                new JPanel();

        JButton viewBtn =
                new JButton(
                        "View All Bookings");

        JButton cancelBtn =
                new JButton(
                        "Cancel Reservation");

        buttonPanel.add(
                viewBtn);

        buttonPanel.add(
                cancelBtn);

        add(
                buttonPanel,
                BorderLayout.WEST);

        viewBtn.addActionListener(
                e -> viewBookings());

        cancelBtn.addActionListener(
                e -> cancelBooking());

        loadRooms();

        setVisible(true);
    }

    private JPanel createFloorPanel(
            String title) {

        JPanel wrapper =
                new JPanel(
                        new BorderLayout());

        JLabel lbl =
                new JLabel(
                        title,
                        SwingConstants.CENTER);

        lbl.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18));

        wrapper.add(
                lbl,
                BorderLayout.NORTH);

        JPanel panel =
                new JPanel(
                        new FlowLayout());

        wrapper.add(
                panel,
                BorderLayout.CENTER);

        return panel;
    }

    private void loadRooms() {

        for(Room room :
                hotel.getRooms()) {

            JButton btn =
                    new JButton(
                            String.valueOf(
                                    room.getRoomNumber()));

            btn.setPreferredSize(
                    new Dimension(
                            90,
                            70));

            btn.setOpaque(true);

            btn.setBorderPainted(false);

            if(room.isAvailable()) {

                btn.setBackground(
                        Color.GREEN);

            } else {

                btn.setBackground(
                        Color.RED);
            }

            btn.addActionListener(
                    new RoomAction(
                            room));

            roomButtons.put(
                    room.getRoomNumber(),
                    btn);

            if(room.getFloor()
                    == 1) {

                floor1Panel.add(
                        btn);

            } else if(
                    room.getFloor()
                            == 2) {

                floor2Panel.add(
                        btn);

            } else {

                floor3Panel.add(
                        btn);
            }
        }
    }

    private class RoomAction
            implements ActionListener {

        private Room room;

        public RoomAction(
                Room room) {

            this.room = room;
        }

        @Override
        public void actionPerformed(
                ActionEvent e) {

            String details =

                    "Hotel : "
                            + room.getHotelName()

                            + "\nRoom : "
                            + room.getRoomNumber()

                            + "\nCategory : "
                            + room.getCategory()

                            + "\nRating : "
                            + room.getRating()

                            + "\nFacilities : "
                            + room.getFacilities()

                            + "\nPrice : ₹"
                            + room.getPrice()

                            + "\nStatus : "
                            + (room.isAvailable()
                            ? "Available"
                            : "Booked");

            if(room.isAvailable()) {

                int option =
                        JOptionPane.showConfirmDialog(

                                null,

                                details +
                                        "\n\nBook Room ?",

                                "Room Details",

                                JOptionPane.YES_NO_OPTION);

                if(option ==
                        JOptionPane.YES_OPTION) {

                    bookRoom(
                            room);
                }

            } else {

                showBookedCustomer(
                        room);
            }
        }
    }       private void bookRoom(Room room) {

        JTextField idField =
                new JTextField();

        JTextField nameField =
                new JTextField();

        JTextField mobileField =
                new JTextField();

        JTextField emailField =
                new JTextField();

        JTextField adultsField =
                new JTextField();

        JTextField childrenField =
                new JTextField();

        JTextField bookingTypeField =
                new JTextField();

        JPanel panel =
                new JPanel(
                        new GridLayout(7,2));

        panel.add(new JLabel("Customer ID"));
        panel.add(idField);

        panel.add(new JLabel("Name"));
        panel.add(nameField);

        panel.add(new JLabel("Mobile"));
        panel.add(mobileField);

        panel.add(new JLabel("Email"));
        panel.add(emailField);

        panel.add(new JLabel("Adults"));
        panel.add(adultsField);

        panel.add(new JLabel("Children"));
        panel.add(childrenField);

        panel.add(new JLabel("Booking Type"));
        panel.add(bookingTypeField);

        while(true) {

            int result =
                    JOptionPane.showConfirmDialog(

                            this,

                            panel,

                            "Room Booking Form",

                            JOptionPane.OK_CANCEL_OPTION,

                            JOptionPane.PLAIN_MESSAGE);

            if(result !=
                    JOptionPane.OK_OPTION) {

                return;
            }

            try {

                String customerId =
                        idField.getText();

                String name =
                        nameField.getText();

                String mobile =
                        mobileField.getText();

                String email =
                        emailField.getText();

                int adults =
                        Integer.parseInt(
                                adultsField.getText());

                int children =
                        Integer.parseInt(
                                childrenField.getText());

                String bookingType =
                        bookingTypeField.getText();

                Customer customer =
                        new Customer(
                                customerId,
                                name,
                                mobile,
                                email,
                                adults,
                                children,
                                bookingType);

                boolean paid =
                        Payment.processPayment(
                                room.getPrice());

                if(!paid) {
                    return;
                }

                room.setAvailable(false);

                Reservation reservation =
                        new Reservation(

                                "B" +
                                        System.currentTimeMillis(),

                                customer,

                                room,

                                "PAID",

                                "CONFIRMED");

                reservations.add(
                        reservation);

                FileManager.saveBooking(
                        reservation);

                JButton btn =
                        roomButtons.get(
                                room.getRoomNumber());

                btn.setBackground(
                        Color.RED);

                btn.repaint();

                totalRevenue +=
                        room.getPrice();

                updateDashboard();

                JOptionPane.showMessageDialog(

                        this,

                        "Booking Successful\n\nBooking ID : "
                                + reservation.getBookingId());

                return;

            } catch(NumberFormatException e) {

                JOptionPane.showMessageDialog(

                        this,

                        "Adults and Children must be numbers.");

            }
        }
    }

    private void showBookedCustomer(
            Room room) {

        for(Reservation r :
                reservations) {

            if(r.getRoom()
                    .getRoomNumber()
                    ==
                    room.getRoomNumber()) {

                JOptionPane.showMessageDialog(

                        this,

                        "Booking ID : "
                                + r.getBookingId()

                                + "\nCustomer : "
                                + r.getCustomer()
                                .getName()

                                + "\nMobile : "
                                + r.getCustomer()
                                .getMobile()

                                + "\nEmail : "
                                + r.getCustomer()
                                .getEmail()

                                + "\nAdults : "
                                + r.getCustomer()
                                .getAdults()

                                + "\nChildren : "
                                + r.getCustomer()
                                .getChildren()

                                + "\nBooking Type : "
                                + r.getCustomer()
                                .getBookingType()

                                + "\nPayment : "
                                + r.getPaymentStatus()

                                + "\nStatus : "
                                + r.getReservationStatus());

                return;
            }
        }
    }

    private void viewBookings() {

        StringBuilder sb =
                new StringBuilder();

        for(Reservation r :
                reservations) {

            sb.append(
                            "Booking ID : ")
                    .append(
                            r.getBookingId())
                    .append("\n");

            sb.append(
                            "Customer : ")
                    .append(
                            r.getCustomer()
                                    .getName())
                    .append("\n");

            sb.append(
                            "Room : ")
                    .append(
                            r.getRoom()
                                    .getRoomNumber())
                    .append("\n");

            sb.append(
                            "Category : ")
                    .append(
                            r.getRoom()
                                    .getCategory())
                    .append("\n");

            sb.append(
                            "Status : ")
                    .append(
                            r.getReservationStatus())
                    .append("\n\n");
        }

        JTextArea area =
                new JTextArea(
                        sb.toString());

        area.setEditable(false);

        JOptionPane.showMessageDialog(

                this,

                new JScrollPane(area),

                "All Bookings",

                JOptionPane.INFORMATION_MESSAGE);
    }

    private void cancelBooking() {

        String bookingId =
                JOptionPane.showInputDialog(
                        "Enter Booking ID");

        if(bookingId == null ||
                bookingId.isEmpty()) {

            return;
        }

        for(Reservation r :
                reservations) {

            if(r.getBookingId()
                    .equals(
                            bookingId)) {

                r.setReservationStatus(
                        "CANCELLED");

                r.getRoom()
                        .setAvailable(
                                true);

                JButton btn =
                        roomButtons.get(
                                r.getRoom()
                                        .getRoomNumber());

                btn.setBackground(
                        Color.GREEN);

                totalRevenue -=
                        r.getRoom()
                                .getPrice();

                updateDashboard();

                FileManager.cancelBooking(
                        bookingId);

                JOptionPane.showMessageDialog(

                        this,

                        "Booking Cancelled");

                return;
            }
        }

        JOptionPane.showMessageDialog(

                this,

                "Booking Not Found");
    }

    private void updateDashboard() {

        int booked = 0;

        int available = 0;

        for(Room room :
                hotel.getRooms()) {

            if(room.isAvailable()) {

                available++;

            } else {

                booked++;
            }
        }

        availableLabel.setText(
                "Available : "
                        + available);

        bookedLabel.setText(
                "Booked : "
                        + booked);

        revenueLabel.setText(
                "Revenue : ₹"
                        + totalRevenue);
    }

}
