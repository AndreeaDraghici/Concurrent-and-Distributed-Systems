package com.home.lab2.task3;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class CountDown extends Frame implements Runnable {
    Thread counterThread;
    int i;
    final static int N = 4;

    AudioClip beepSound, tickSound;

    NumberCanvas display;
    volatile boolean done = false;

    public CountDown() {
        add(display = new NumberCanvas("CountDown"));

        try {
            File tickFile = new File("...\\tick.au");
            File beepFile = new File("...\\beep.au");
            tickSound = Applet.newAudioClip(new URL(tickFile.toURI().toURL().toString()));
            beepSound = Applet.newAudioClip(beepFile.toURL());
        } catch (MalformedURLException mfe) {
            System.out.println("An error occured, please try again...");
        }

        counterThread = new Thread(this);
        i = N;
        counterThread.start();

        addWindowListener((WindowListener) new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                terminate();
            }
        });
    }

    public void run() {
        while (!done) {
            if (i > 0) {
                tick();
                --i;
            }
            if (i == 0) {
                beep();
                i = N;
            }
        }
    }

    private void tick() {
        display.setvalue(i);
        tickSound.play();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    private void beep() {
        AudioClip clip = Applet.newAudioClip(getClass().getResource("...\\beep.au"));
        clip.play();
    }

    public void terminate() {
        done = true;
        setVisible(false);
        dispose();
    }
}