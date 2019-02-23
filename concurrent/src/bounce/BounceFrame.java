package bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {

    private BallComponent component;
    private static final int STEPS = 1000;
    private static final int DELAY = 3;

    public BounceFrame() {
        setTitle("Bounce");
        component = new BallComponent();
        add(component, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "start", event -> addBall());
        addButton(buttonPanel, "stop", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener actionListener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(actionListener);
    }

//    public void addBall() {
//        Ball ball = new Ball();
//        component.add(ball);
//        Runnable runnable = () -> {
//            ball.move(component.getBounds());
//            component.repaint();
//            try {
//                Thread.sleep(DELAY);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
////        try {
////
////            }
////            for (int i = 1; i <= STEPS; i++) {
////                ball.move(component.getBounds());
////                component.paint(component.getGraphics());
////                Thread.sleep(DELAY);
////            }
////        } catch (InterruptedException ie) {
////        }
//    }

    public void addBall () {
        Ball ball = new Ball();
        component.add(ball);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= STEPS; i++) {
                        ball.move(component.getBounds());
                        component.repaint();
                        Thread.sleep(DELAY);
                    }
                } catch(InterruptedException e){

                };

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
