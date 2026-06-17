import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME =
            "bookings.txt";

    public static void saveBooking(
            Reservation reservation) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(
                                    FILE_NAME,
                                    true));

            bw.write(
                    reservation.toString());

            bw.newLine();

            bw.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static List<String>
    loadBookings() {

        List<String> bookings =
                new ArrayList<>();

        try {

            File file =
                    new File(FILE_NAME);

            if(!file.exists()) {

                file.createNewFile();
            }

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while((line =
                    br.readLine())
                    != null) {

                bookings.add(line);
            }

            br.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return bookings;
    }

    public static void cancelBooking(
            String bookingId) {

        try {

            List<String> bookings =
                    loadBookings();

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(
                                    FILE_NAME));

            for(String line :
                    bookings) {

                String[] parts =
                        line.split(",");

                if(parts[0].equals(
                        bookingId)) {

                    parts[
                            parts.length - 1]
                            = "CANCELLED";

                    line =
                            String.join(
                                    ",",
                                    parts);
                }

                bw.write(line);

                bw.newLine();
            }

            bw.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}
