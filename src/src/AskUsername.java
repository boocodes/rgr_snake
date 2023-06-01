package src;

import javax.swing.*;


public class AskUsername extends JPanel{

    public AskUsername(){

    }

    public JTextField addAskUsername(SnakeGame argExternalFrame){

        JTextField textField = new JTextField();
        textField.setText("Ваше имя");
        textField.setBounds(100, 100, 100, 50);
        textField.setVisible(true);

        return textField;
    }


}
