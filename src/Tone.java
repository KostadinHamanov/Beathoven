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
		File midiFile = new File("/home/martin/Downloads/www.mid");
		// Play once
		try {

			sequencer = MidiSystem.getSequencer();
			sequencer.setSequence(MidiSystem.getSequence(midiFile));
			sequencer.open();
			sequencer.start();
			sequencer.setMicrosecondPosition(Long.valueOf(args[0]));
			while (true) {
				if (sequencer.isRunning()) {
					try {
						Thread.sleep(100); // Check every second
						LabelPanel.lbl.setText("Time: " + String.valueOf(Tone.sequencer.getMicrosecondPosition()));
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