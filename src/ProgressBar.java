/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 
 * ButtonDemo.java requires the following files:
 *   images/right.gif
 *   images/middle.gif
 *   images/left.gif
 */
public class ProgressBar extends JPanel
        implements ActionListener {
    //Where member variables are declared:
    public static JProgressBar progressBar;

    private long pausedAt = 0;

    public ProgressBar() {

        //TODO:fix
        ImageIcon leftButtonIcon = createImageIcon("images/right.gif");
        ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
        ImageIcon rightButtonIcon = createImageIcon("images/left.gif");

        progressBar = new JProgressBar(0, MainFrame.getLocation(Tone.sequencer.getMicrosecondLength()));
        progressBar.setValue(MainFrame.getLocation(0));
        progressBar.setStringPainted(true);

        progressBar.setLayout(new GridLayout(1, 1));
        progressBar.setOpaque(true); //content panes must be opaque
//
//        b1 = new JButton("Start/Continue", leftButtonIcon);
//        b1.setVerticalTextPosition(AbstractButton.CENTER);
//        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
//        b1.setMnemonic(KeyEvent.VK_S);
//        b1.setActionCommand("start");
//
//        b2 = new JButton("Stop", middleButtonIcon);
//        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
//        b2.setHorizontalTextPosition(AbstractButton.CENTER);
//        b2.setMnemonic(KeyEvent.VK_P);
//        b2.setActionCommand("Stop");
//
//        b3 = new JButton("Pause", rightButtonIcon);
//        //Use the default text position of CENTER, TRAILING (RIGHT).
//        b3.setMnemonic(KeyEvent.VK_E);
//        b3.setActionCommand("enable");
//        b3.setEnabled(false);
//
//        //Listen for actions on buttons 1 and 3.
//        b1.addActionListener(this);
//        b3.addActionListener(this);
//        b2.addActionListener(this);
//
//        //TODO:change
//        b1.setToolTipText("Click this button to disable the middle button.");
//        b2.setToolTipText("This middle button does nothing when you click it.");
//        b3.setToolTipText("Click this button to enable the middle button.");

        //Add Components to this container, using the default FlowLayout.
        add(progressBar);
//        add(b2);
//        add(b3);

    }

    public void actionPerformed(ActionEvent e) {
//        if ("start".equals(e.getActionCommand())) {
//            b2.setEnabled(false);
//            b1.setEnabled(false);
//            b3.setEnabled(true);
//
//            thread3 = new Thread(() -> {
//                // We are doing the same thing as with the MyRunnableImplementation class
////                for (int i = 0; i < 5; i++) {
//                long start = System.nanoTime();
////                Tone.main(new String[]{String.valueOf(pausedAt)});
//
//                Tone.play(pausedAt);
//
//                System.out.println(TimeUnit.SECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS));
//
//                System.out.println(Thread.currentThread().getName() +
//                        "\twith Runnable: Inner class Runnable runs...");
////                }
//            }, "Thread 3");
//            thread3.start();
//
//
//        } else if ("Stop".equals(e.getActionCommand())){
//            pausedAt = 0;
//            System.out.println("Stopped: " + pausedAt);
//
//            LabelPanel.lbl.setText("Time: " + String.valueOf(pausedAt));
//            MainFrame.progressBar.setValue(MainFrame.getLocation(pausedAt));
//
//            b2.setEnabled(true);
//            b1.setEnabled(true);
//            b3.setEnabled(false);
//
//        }  else{
//            b2.setEnabled(true);
//            b1.setEnabled(true);
//            b3.setEnabled(false);
//
//            pausedAt = Tone.sequencer.getMicrosecondPosition();
//
//            LabelPanel.lbl.setText("Time: " + String.valueOf(Tone.sequencer.getMicrosecondPosition()));
//            MainFrame.progressBar.setValue(MainFrame.getLocation(Tone.sequencer.getMicrosecondPosition()));
//            System.out.println(pausedAt);
//
//            Tone.sequencer.stop();
////            thread3.interrupt();
//        }
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ProgressBar.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
