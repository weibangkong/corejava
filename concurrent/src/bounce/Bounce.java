package bounce;


import javax.swing.*;
import java.awt.*;

public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450,350);
            frame.setVisible(true);
        });
    }
}
