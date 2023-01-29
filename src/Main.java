import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class Main {
    JFrame frame = new JFrame("Цвета");
    JPanel panel = new JPanel();
    String [] colors = {"Красный", "Синий", "Зелёный", "Жёлтый", "Белый", "Чёрный"};
    JComboBox<String> comboBox = new JComboBox<>(colors);
    JCheckBox checkBox = new JCheckBox("Свой вариант");
    JTextField textField = new JTextField(8);
    JButton button = new JButton("Ответить");
    JLabel label = new JLabel();


    public Main () {
        int width = 140, height = 250;
        frame.setSize(width,height);
        Dimension monitorResolution = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(monitorResolution.width/2 - width/2,monitorResolution.height/2 - height/2);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        button.addActionListener(actionEvent -> {
            if (checkBox.isSelected()) {
                if (!textField.getText().equals(""))
                    label.setText("Ответ: " + textField.getText());
                else {
                    label.setFont(new Font("Dialog", Font.BOLD, 12));
                    label.setHorizontalAlignment(CENTER);
                    label.setText("<HTML> <Font color='red'> Введите цвет </Font> </html>");
                }
            } else {
                label.setText("Ответ: " + comboBox.getSelectedItem());
            }
            });

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));

        comboBox.setMaximumSize(new Dimension(100,25));

        textField.setMaximumSize(new Dimension(100,30));
        textField.setEnabled(false);

        checkBox.addActionListener(actionEvent -> {
            if (checkBox.isSelected()) {
                textField.setEnabled(true);
                comboBox.setEnabled(false);
            } else {
                textField.setEnabled(false);
                comboBox.setEnabled(true);
            }
        });

        addComponent(comboBox);
        addComponent(checkBox);
        addComponent(textField);
        addComponent(button);
        addComponent(label);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void addComponent (JComponent c) {
        c.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(c);
        panel.add(Box.createVerticalStrut(10));
    }

    public static void main(String[] args) {
        new Main();
    }

}
