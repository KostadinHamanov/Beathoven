import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.swing.JFrame;

/**
 * Audio tone generator, using the Java sampled sound API.
 * 
 * @author andrew Thompson
 * @version 2007/12/6
 */
public class Tone extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -461906699629673967L;

	public static void main(String[] args) {
		File midiFile = new File("/home/stunji/Downloads/take5.mid");
		// Play once
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.setSequence(MidiSystem.getSequence(midiFile));
			sequencer.open();
			sequencer.start();
			while (true) {
				if (sequencer.isRunning()) {
					try {
						Thread.sleep(1000); // Check every second
					} catch (InterruptedException ignore) {
						break;
					}
				} else {
					break;
				}
			}
			// Close the MidiDevice & free resources
			sequencer.stop();
			sequencer.close();
		} catch (MidiUnavailableException mue) {
			System.out.println("Midi device unavailable!");
		} catch (InvalidMidiDataException imde) {
			System.out.println("Invalid Midi data!");
		} catch (IOException ioe) {
			System.out.println("I/O Error!");
		}
	}
}