package arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class EmailRegistrationForm {

    // Set to store registered emails
    private static Set<String> registeredEmails = new HashSet<>();

    public static void main(String[] args) {
        // Create the frame with a fixed size and minimal size
        JFrame frame = new JFrame("Email Registration");
        frame.setSize(400, 350);
        frame.setMinimumSize(new Dimension(400, 350));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Labels and Fields
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField(15);
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField(15);
        JLabel emailLabel = new JLabel("Email ID:");
        JTextField emailField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        JLabel mobileLabel = new JLabel("Mobile Number:");
        JTextField mobileField = new JTextField(15);
        JLabel refEmailLabel = new JLabel("Reference Email ID:");
        JTextField refEmailField = new JTextField(15);

        // Buttons
        JButton registerButton = new JButton("Register");
        JButton cancelButton = new JButton("Cancel");
        JButton resetButton = new JButton("Reset");

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        frame.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        frame.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(emailLabel, gbc);
        gbc.gridx = 1;
        frame.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(passwordLabel, gbc);
        gbc.gridx = 1;
        frame.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(mobileLabel, gbc);
        gbc.gridx = 1;
        frame.add(mobileField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(refEmailLabel, gbc);
        gbc.gridx = 1;
        frame.add(refEmailField, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(resetButton);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        frame.add(buttonPanel, gbc);

        // Register Button Action
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText().trim();
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Email cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (registeredEmails.contains(email)) {
                    JOptionPane.showMessageDialog(frame, "Email already exists! Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    registeredEmails.add(email);
                    JOptionPane.showMessageDialog(frame, "You have successfully registered!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Reset Button Action
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                mobileField.setText("");
                refEmailField.setText("");
            }
        });

        // Cancel Button Action
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                mobileField.setText("");
                refEmailField.setText("");
            }
        });

        frame.setVisible(true);
    }
}