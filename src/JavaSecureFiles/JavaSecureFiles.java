package JavaSecureFiles;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\JavaWorks\\JavaSecureFiles\\IMG\\B1.png");
        F.setTitle("Encrypt and Decrypt Data Software");
        F.setSize(500, 500);
        F.setLocationRelativeTo(null);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create Font
        Font font = new Font("Roboto", Font.BOLD, 48);
        Font font1 = new Font("Roboto", Font.ITALIC, 50);
        Font font3 = new Font("Arial", Font.ITALIC, 30);
        // Image
        ImageIcon img1 = new ImageIcon("D:\\JavaWorks\\JavaSecureFiles\\IMG\\jis.png");
        ImageIcon img2 = new ImageIcon("D:\\JavaWorks\\JavaSecureFiles\\IMG\\cse1.png");
        ImageIcon img3 = new ImageIcon("D:\\JavaWorks\\JavaSecureFiles\\IMG\\jisgr1.png");
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
        JButton Button = new JButton(new ImageIcon("D:\\JavaWorks\\JavaSecureFiles\\IMG\\image.png"));
        Button.setText("Open Any File");
        Button.setFont(font);
        Button.setBackground(Color.BLUE);
        Button.setForeground(Color.WHITE);
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
        Clear.addActionListener(e -> {
            T1.setText("");
        });
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
}
