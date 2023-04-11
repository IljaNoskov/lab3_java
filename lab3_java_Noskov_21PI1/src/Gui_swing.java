import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui_swing extends JFrame {
    JButton button = new JButton("Рассчитать");
    JTextField input_name = new JTextField("",10);
    JTextField input_date = new JTextField("",10);
    JLabel label_name = new JLabel("Введите своё имя в формате (Фамилия Имя Отчество): ");
    JLabel label_date = new JLabel("Введите дату рождения в формате (дд.мм.гггг): ");
    public Gui_swing(){
        super("Lab 3 by Noskov Ilia 21PI1");
        this.setBounds(250,250, 700, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container window = this.getContentPane();
        window.setLayout(new GridLayout(3,2,2,2));
        window.add(label_name);
        window.add(input_name);
        window.add(label_date);
        window.add(input_date);
        button.addActionListener(new ButtonEventListner());
        window.add(button);
    }
    class ButtonEventListner implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String message = "";
            try{
                message += Main.name_end(input_name.getText());
            } catch (ArrayIndexOutOfBoundsException ex){
                message += "ФИО введенно неккоректно ";
            }
            try {
                message += Main.date(input_date.getText());
            } catch (NullPointerException ex){
                message += "Дата рождения введена неккоректно";
            }
            JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
