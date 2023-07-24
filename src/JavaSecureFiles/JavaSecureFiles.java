package JavaSecureFiles;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class JavaSecureFiles {
    public static void operate(int key) {
        JFileChooser fileChooserJava = new JFileChooser();
        fileChooserJava.showOpenDialog(null);
        File file = fileChooserJava.getSelectedFile();
        // Fileinputstream
        try {
            FileInputStream FIS = new FileInputStream(file);
            byte[] data = new byte[FIS.available()];
            FIS.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println("Processing The Data...............");
                data[i] = (byte) (b ^ key);
                i++;
            }
            FileOutputStream FOS = new FileOutputStream(file);
            FOS.write(data);
            FOS.close();
            FIS.close();
            System.out.println("Process Done");
            JOptionPane.showMessageDialog(null, "Process Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the Application");
        JOptionPane.showMessageDialog(null, "Hello! Welcome to the Application");
        JOptionPane.showMessageDialog(null, "Step 1: Enter The Password for Encryption or Decryption \nStep 2: Select the File \n\n\n* In Case of Decryption if you provide a wrong password then that file will be damaged...");
        JFrame F = new JFrame();
        // Icon Image , Create Image Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("IMG\\B1.png");
        F.setTitle("Encrypt and Decrypt Data Software");
        F.setSize(500, 500);
        F.setLocationRelativeTo(null);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create Font
        Font font = new Font("Roboto", Font.BOLD, 48);
        Font font1 = new Font("Roboto", Font.ITALIC, 50);
        Font font3 = new Font("Arial", Font.ITALIC, 30);
        // Image
        ImageIcon img1 = new ImageIcon("IMG\\jis.png");
        ImageIcon img2 = new ImageIcon("IMG\\cse1.png");
        ImageIcon img3 = new ImageIcon("IMG\\jisgr1.png");
        // Level
        JLabel l1 = new JLabel("");
        JLabel l2 = new JLabel("");
        JLabel l3 = new JLabel("");
        JLabel l4 = new JLabel("*jpeg, *jpg, *pdf, *doc, *docx, etc...");
        JLabel l5 = new JLabel("Enter The Key Value Here");
        l5.setFont(font3);
        l5.setForeground(Color.RED);
        l1.setIcon(img1);
        l2.setIcon(img2);
        l3.setIcon(img3);

        // Create Button
        // Create the first button with an image icon
        JButton Button = new JButton(new ImageIcon("IMG\\image.png"));
        Button.setFont(font);
        Button.setBackground(new Color(59, 89, 182)); // Blue color
        Button.setForeground(Color.WHITE);
        Button.setFocusPainted(false);
        Button.setBorder(new RoundedBorder(40)); // Set the border with a 40-pixel radius
        // Set the text for the first button
        Button.setText("Select File");
        // Set the font for the first button (assuming 'font' is defined elsewhere)
        Button.setFont(font);
        // Set the background color for the first button to blue
        Button.setBackground(Color.BLUE);
        // Set the foreground color for the first button to white
        Button.setForeground(Color.WHITE);
        // Create the second button with the text "Clear"
        JButton Clear = new JButton("Clear");
        // Create Text Field
        JTextField T1;
        T1 = new JTextField(10);
        T1.setFont(font1);
        T1.setBackground(Color.red);
        // Button ActionListener
        Button.addActionListener(e -> {
            Button.setForeground(Color.RED);
            System.out.println("Button Clicked");
            String Text = T1.getText();
            T1.setText("");
            // System.out.println(Text);
            int Temp = Integer.parseInt(Text);
            // System.out.println(Temp);
            operate(Temp);
            Button.setForeground(Color.GREEN);
        });
        // Clear Button Listener
        Clear.addActionListener(e -> T1.setText(""));
        // Layout
        F.setLayout(new FlowLayout());
        F.getContentPane().setBackground(Color.CYAN);
        F.setIconImage(icon); // add Icon Image
        F.add(l1);
        F.add(l2);
        F.add(l3);
        F.add(Button);
        F.add(l4);
        F.add(l5);
        F.add(T1);
        F.add(Clear);
        F.setVisible(true);
    }
    static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(c.getForeground());
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}
