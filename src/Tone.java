import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import java.io.File;
import java.io.IOException;

/**
 * Audio tone generator, using the Java sampled sound API.
 *
 * @author andrew Thompson
 * @version 2007/12/6
 */
public class Tone {

    /**
     *
     */

    public static Sequencer sequencer;

    public static void main(String[] args) {
        // Play once

        load();

        play(Long.valueOf(args[0]));

        // Close the MidiDevice & free resources
        sequencer.stop();
        sequencer.close();
    }


    public static void load() {

        File midiFile = new File("/home/martin/Downloads/www.mid");

        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.setSequence(MidiSystem.getSequence(midiFile));
            sequencer.open();

        } catch (MidiUnavailableException mue) {
            System.out.println("Midi device unavailable!");
        } catch (InvalidMidiDataException imde) {
            System.out.println("Invalid Midi data!");
        } catch (IOException ioe) {
            System.out.println("I/O Error!");
        }
    }

    public static void play(long startAt) {
        System.out.println("Started at: " + startAt);
        sequencer.start();
        sequencer.setMicrosecondPosition(startAt);
        while (true) {
            if (sequencer.isRunning()) {
                try {
                    Thread.sleep(100); // Check every second
                    LabelPanel.lbl.setText("Time: " + String.valueOf(Tone.sequencer.getMicrosecondPosition()));
                    MainFrame.progressBarPanel.progressBar.setValue(MainFrame.getLocation(Tone.sequencer.getMicrosecondPosition()));
                } catch (InterruptedException ignore) {
                    break;
                }
            } else {
                break;
            }
        }
    }
}