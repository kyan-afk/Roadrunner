package main;

import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CurrencyConverterFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField jtxtAmount;
    private JTextField jtxtAmountConverted;

    // Constructor for creating the JFrame
    public CurrencyConverterFrame() {
    	setForeground(new Color(0, 0, 0));
    	setBackground(new Color(0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1372, 874);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        setTitle("Skyrate");
        setIconImage(Toolkit.getDefaultToolkit().getImage("res/logo.png"));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(293, 21, 714, 93);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 20));
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Currency Converter ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setBounds(184, 22, 377, 41);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_10 = new JLabel("New label");
        lblNewLabel_10.setBounds(10, 52, 820, 145);
        panel.add(lblNewLabel_10);
        lblNewLabel_10.setIcon(new ImageIcon("res/gif7 (1).gif"));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(192, 192, 192));
        panel_1.setForeground(new Color(255, 255, 255));
        panel_1.setBounds(293, 213, 714, 93);
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 20));
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnNewButton_1 = new JButton("Reset");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtxtAmountConverted.setText("");
                jtxtAmount.setText("");
            }
        });
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
        btnNewButton_1.setBounds(297, 30, 130, 32);
        panel_1.add(btnNewButton_1);
        
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            private JFrame frame;
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Exit");
                int result = JOptionPane.showConfirmDialog(frame, "Thank you. Do you really want to exit?");
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        btnExit.setForeground(Color.BLACK);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnExit.setBackground(new Color(255, 255, 255));
        btnExit.setBackground(UIManager.getColor("Button.background"));
        btnExit.setBounds(537, 30, 130, 32);
        panel_1.add(btnExit);
        
        JButton btnConvert = new JButton("Convert");
        btnConvert.setForeground(Color.BLACK);
        btnConvert.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnConvert.setBackground(new Color(255, 255, 255));
        btnConvert.setBounds(68, 30, 130, 32);
        panel_1.add(btnConvert);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(220, 220, 220));
        panel_2.setBounds(293, 295, 714, 276);
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 20));
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Amount");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(57, 38, 191, 36);
        panel_2.add(lblNewLabel_1);
        
        jtxtAmount = new JTextField();
        jtxtAmount.setBackground(new Color(173, 216, 230));
        jtxtAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jtxtAmount.setBounds(298, 40, 370, 34);
        panel_2.add(jtxtAmount);
        jtxtAmount.setColumns(10);
        
        JLabel lblFromCurrency = new JLabel("From Currency");
        lblFromCurrency.setBackground(new Color(144, 238, 144));
        lblFromCurrency.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblFromCurrency.setBounds(57, 94, 191, 36);
        panel_2.add(lblFromCurrency);
        
        JLabel lblToCurrency = new JLabel("To Currency");
        lblToCurrency.setBackground(new Color(211, 211, 211));
        lblToCurrency.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblToCurrency.setBounds(57, 141, 191, 36);
        panel_2.add(lblToCurrency);
        
        JComboBox<String> jfrom = new JComboBox<>();
        jfrom.setBackground(new Color(245, 245, 245));
        jfrom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jfrom.setModel(new DefaultComboBoxModel<>(new String[] {"USD – United States Dollar ", "EUR - Euro European Union countries", "JPY – Japanese Yen", "GBP – British Pound ", "CAD – Canadian Dollar", "AUD – Australian Dollar", "CNY – Chinese Yuan", "PHP – Philippine Peso", "CHF – Swiss Franc", "INR – Indian Rupee", "KRW – South Korean Won", "MXN – Mexican Peso"}));
        jfrom.setBounds(298, 97, 370, 34);
        panel_2.add(jfrom);
        
        JComboBox<String> jto = new JComboBox<>();
        jto.setBackground(new Color(245, 245, 245));
        jto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jto.setModel(new DefaultComboBoxModel<>(new String[] {"USD – United States Dollar ", "EUR - Euro European Union countries", "JPY – Japanese Yen", "GBP – British Pound ", "CAD – Canadian Dollar", "AUD – Australian Dollar", "CNY – Chinese Yuan", "PHP – Philippine Peso", "CHF – Swiss Franc", "INR – Indian Rupee", "KRW – South Korean Won", "MXN – Mexican Peso"}));
        jto.setBounds(298, 144, 370, 34);
        panel_2.add(jto);
        
        JLabel lblAmountConverted = new JLabel("Amount Converted");
        lblAmountConverted.setBounds(57, 198, 216, 36);
        panel_2.add(lblAmountConverted);
        lblAmountConverted.setFont(new Font("Tahoma", Font.PLAIN, 25));
        
        jtxtAmountConverted = new JTextField();
        jtxtAmountConverted.setBackground(new Color(176, 224, 230));
        jtxtAmountConverted.setBounds(298, 202, 368, 34);
        panel_2.add(jtxtAmountConverted);
        jtxtAmountConverted.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jtxtAmountConverted.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("res/logo11.png"));
        lblNewLabel_2.setBounds(70, 38, 149, 213);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setIcon(new ImageIcon("res/gif1.gif"));
        lblNewLabel_4.setBounds(10, 262, 204, 153);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setIcon(new ImageIcon("res/gif3.gif"));
        lblNewLabel_6.setBounds(55, 412, 164, 225);
        contentPane.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setIcon(new ImageIcon("res/gif7 (2).gif"));
        lblNewLabel_7.setBounds(1055, 480, 185, 153);
        contentPane.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("New label");
        lblNewLabel_8.setIcon(new ImageIcon("res/gif2.gif"));
        lblNewLabel_8.setBounds(1017, 263, 241, 153);
        contentPane.add(lblNewLabel_8);
        
        JLabel lblNewLabel_11 = new JLabel("New label");
        lblNewLabel_11.setIcon(new ImageIcon("res/gif8.gif"));
        lblNewLabel_11.setBounds(375, 73, 798, 142);
        contentPane.add(lblNewLabel_11);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        //lblNewLabel_3.setIcon(new ImageIcon("res/backround4.jpg"));
        lblNewLabel_3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/backround4.jpg")));
        lblNewLabel_3.setBounds(-12, -72, 1361, 887);
        contentPane.add(lblNewLabel_3);
        
        // Action to per form conversion
        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = InputValidator.validateAndGetValue(jtxtAmount.getText());
                    String fromCurrency = (String) jfrom.getSelectedItem();
                    String toCurrency = (String) jto.getSelectedItem();
                    double convertedAmount = CurrencyConverterUtil.convertCurrency(amount, fromCurrency, toCurrency);
                    jtxtAmountConverted.setText(String.format("%.2f", convertedAmount));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the amount.");
                }
            }
        });
    }
}

