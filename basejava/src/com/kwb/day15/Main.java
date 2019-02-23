package com.kwb.day15;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger("com.kwb.corejava").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("com.kwb.corejava").addHandler(handler);
            } catch (IOException e) {
                e.printStackTrace();
                Logger.getLogger("com.kwb.corejava").log(Level.SEVERE, "Can`t create log file handler", e);
            }
        }
        EventQueue.invokeLater(()->{
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.kwb.corejava").addHandler(windowHandler);

            JFrame frame = new ImageViewFrame();
            frame.setSize(200,200);
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("com.kwb.corejava").fine("Showing frame");
            frame.setVisible(true);
        });
    }
}
