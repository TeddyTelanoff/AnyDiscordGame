package com.treidex.anydiscordgame;

/*
 * Symple Program that allows you to
 * display a custom game in discord.
 * Teddy Telanoff
 * (C) 2020 Treidex
 */

import javax.swing.*;
import java.awt.*;

public class Main {
    String mTitle = "Any Discord Game";
    JTextArea mTextArea;
    JFrame mWindow;
    JScrollPane mPane;

    Thread mCheckThread;

    Main() {
        mWindow = new JFrame(mTitle);
        mWindow.setLayout(new BorderLayout());
        mWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mWindow.setSize(new Dimension(500, 400));
        mWindow.setPreferredSize(new Dimension(500, 400));

        mTextArea = new JTextArea(mTitle);
        mTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
        mTextArea.setLineWrap(true);
        mTextArea.setWrapStyleWord(true);

        mPane = new JScrollPane(mTextArea);
        mWindow.add(mPane, BorderLayout.CENTER);

        mCheckThread = new Thread(() -> {
            while (true) {
                if (!mTitle.equals(mTextArea.getText())) {
                    mTitle = mTextArea.getText();
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
