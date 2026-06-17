import javax.swing.*;

public class Payment {

    public static boolean processPayment(
            double amount) {

        String[] options = {
                "Online Payment",
                "Offline Payment"
        };

        int choice =
                JOptionPane.showOptionDialog(

                        null,

                        "Amount : ₹" + amount +
                                "\nSelect Payment Method",

                        "Payment",

                        JOptionPane.DEFAULT_OPTION,

                        JOptionPane.INFORMATION_MESSAGE,

                        null,

                        options,

                        options[0]);

        return choice != -1;
    }
}
