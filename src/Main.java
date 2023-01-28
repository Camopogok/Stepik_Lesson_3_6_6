import javax.swing.*;
import java.awt.*;

public class Main {
    JFrame frame = new JFrame("Цвета");
    JPanel jpanel = new JPanel();
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    String [] colors = {"Красный", "Синий", "Зелёный", "Жёлтый", "Белый", "Чёрный"};
    JComboBox comboBox = new JComboBox(colors);
    JCheckBox checkBox = new JCheckBox("Свой вариант");
    JTextField textField = new JTextField(8);
    JButton button = new JButton("Ответить");
    JLabel label = new JLabel();


    public Main () {
        frame.setSize(140,250);
        frame.setLocation(600,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        panel.add(comboBox);
        panel1.add(checkBox);
        panel2.add(textField);
        panel3.add(button);
        panel4.add(label);
        button.addActionListener(actionEvent -> {
            if (checkBox.isSelected()) {
                label.setText("Ответ: " + textField.getText());
            } else {
                label.setText("Ответ: " + (String)comboBox.getSelectedItem());
            }
            });
        jpanel.setLayout(new GridLayout(5, 1));
        panel.setLayout(new FlowLayout());
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());
        jpanel.add(panel);
        jpanel.add(panel1);
        jpanel.add(panel2);
        jpanel.add(panel3);
        jpanel.add(panel4);
        frame.add(jpanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}
