package com.kwb.day15;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageViewFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("com.kwb.corejava");



    public ImageViewFrame(JLabel label) throws HeadlessException {
        this.label = label;
    }

    public ImageViewFrame(GraphicsConfiguration gc, JLabel label) {
        super(gc);
        this.label = label;
    }

    public ImageViewFrame(String title, JLabel label) throws HeadlessException {
        super(title);
        this.label = label;
    }

    public ImageViewFrame(String title, GraphicsConfiguration gc, JLabel label) {
        super(title, gc);
        this.label = label;
    }

    public ImageViewFrame() {
        logger.entering("ImageViewFrame","<init>");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu();
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.fine("exit");
                System.exit(0);
            }
        });

        label = new JLabel();
        add(label);
        logger.exiting("ImageViewFrame","<init>");
    }

    private class FileOpenListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            logger.entering("FileOpenListener", "actionPerformed",e);

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            chooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF image";
                }
            });

            int r = chooser.showOpenDialog(ImageViewFrame.this);
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE,"reading File{0}",name);
                label.setIcon(new ImageIcon(name));
            } else logger.fine("File open dialog canceled.");
            logger.exiting("FileOpenListener","actionPerformed");
        }
    }
}
