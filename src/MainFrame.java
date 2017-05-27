import javax.swing.*;
import java.awt.*;

/**
 * Created by martin on 27.05.17.
 */
public class MainFrame extends JFrame {
    private JPanel buttonsPanel;
    private JPanel labelPanel;

    public MainFrame() {

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("ButtonDemo");
        frame.setLayout(new GridLayout(2,3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ButtonDemo newContentPane = new ButtonDemo();
        newContentPane.setLayout(new GridLayout(1,3));
        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);

        frame.add(newContentPane, BorderLayout.NORTH);
//        pane.add(compsToExperiment, BorderLayout.NORTH);
//        pane.add(new JSeparator(), BorderLayout.CENTER);
//        pane.add(controls, BorderLayout.SOUTH);

        LabelPanel newContentPane2 = new LabelPanel();
        newContentPane.setLayout(new GridLayout(1,1));
        newContentPane2.setOpaque(true); //content panes must be opaque
//        frame.add(newContentPane2);
        frame.add(newContentPane, BorderLayout.SOUTH);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
