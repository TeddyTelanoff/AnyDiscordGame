package com.treidex.anydiscordgame;

import javax.swing.*;
import java.awt.*;

public class Main {
    String mTitle = "Any Discord Game";
    JTextArea mTextField;
    JFrame mWindow;

    Thread mCheckThread;

    Main() {
        mWindow = new JFrame(mTitle);
        mWindow.setSize(500, 400);

        mTextField = new JTextArea(mTitle);
        mTextField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        mWindow.add(mTextField);
        mWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mCheckThread = new Thread(() -> {
            while (true) {
                if (!mTitle.equals(mTextField.getText())) {
                    mTitle = mTextField.getText();
                    mWindow.setTitle(mTitle);
                }
            }
        });

        mCheckThread.start();

        mWindow.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
