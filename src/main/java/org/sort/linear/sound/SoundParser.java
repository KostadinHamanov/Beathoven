package org.sort.linear.sound;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JToggleButton;

public class SoundParser {

	private static final int VELOCITY = 60;
	// ,,,,>>!
	private static final int NOTE_NUMBER = 60;

	public static void parse(final JToggleButton[][] buttons) throws MidiUnavailableException, InterruptedException {
		Synthesizer synthesizer = MidiSystem.getSynthesizer();
		synthesizer.open();
		MidiChannel midiChannel = synthesizer.getChannels()[0];

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; i < buttons[i].length; i++) {
				if (buttons[j][i].isSelected()) {
					midiChannel.noteOn(NOTE_NUMBER, VELOCITY);
				}
				Thread.sleep(500);
			}
		}
		midiChannel.noteOff(NOTE_NUMBER);
	}

	public static void main(String[] args) {

	}

}
