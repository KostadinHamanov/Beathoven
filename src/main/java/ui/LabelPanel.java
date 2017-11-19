package main.java.ui;

import javax.swing.*;

/**
 * Created by martin on 27.05.17.
 */
//public class main.java.LabelPanelLabelPanel extends JPanel {
//
//
//    public main.java.UIin.java.LabelPanel() {
//        JLabel timeLabel = new JLabel();
//        timeLabel.setText("Time: ");
//        timeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
//        timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
//
//        add(timeLabel);
//    }
//
//
//}

public class LabelPanel extends JPanel {
    public static JLabel lbl;

    private Thread thread3;

    private long pausedAt = 0;


    public LabelPanel() {

        lbl = new JLabel();
        lbl.setText("Time: 0");
        lbl.setVerticalAlignment(SwingConstants.BOTTOM);
        lbl.setHorizontalAlignment(SwingConstants.LEFT);

        add(lbl);
//
//        //TODO:fix
//        ImageIcon leftButtonIcon = createImageIcon("images/right.gif");
//        ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
//        ImageIcon rightButtonIcon = createImageIcon("images/left.gif");
//
//        b1 = new JButton("Start/Continue", leftButtonIcon);
//        b1.setVerticalTextPosition(AbstractButton.CENTER);
//        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
//        b1.setMnemonic(KeyEvent.VK_D);
//        b1.setActionCommand("start");
//
//        b2 = new JButton("Stop", middleButtonIcon);
//        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
//        b2.setHorizontalTextPosition(AbstractButton.CENTER);
//        b2.setMnemonic(KeyEvent.VK_M);
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
//
//        //Add Components to this container, using the default FlowLayout.
//        add(b1);
//        add(b2);
//        add(b3);

    }

//    public void actionPerformed(ActionEvent e) {
//        if ("start".equals(e.getActionCommand())) {
//            b2.setEnabled(false);
//            b1.setEnabled(false);
//            b3.setEnabled(true);
//
//            thread3 = new Thread(() -> {
//                // We are doing the same thing as with the MyRunnableImplementation class
////                for (int i = 0; i < 5; i++) {
//                long start = System.nanoTime();
//                main.java.Tone.main(new String[]{String.valueOf(pausedAt)});
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
//            b2.setEnabled(true);
//            b1.setEnabled(true);
//            b3.setEnabled(false);
//
//        }  else{
//            b2.setEnabled(true);
//            b1.setEnabled(true);
//            b3.setEnabled(false);
//
//            pausedAt = main.java.Tone.sequencer.getMicrosecondPosition();
//            System.out.println(pausedAt);
//
//            main.java.Tone.sequencer.stop();
////            thread3.interrupt();
//        }
//    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ButtonDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}