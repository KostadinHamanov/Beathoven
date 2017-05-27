package org.sort.linear.sound;

import java.util.ArrayList;
import java.util.List;

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
		MidiChannel[] channels = synthesizer.getChannels();

		int index = 0;
		List<MidiChannel> colChannels = new ArrayList<>();
		for (int i = 0; i < buttons[0].length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				if (buttons[j][i].isSelected()) {
					colChannels.add(channels[index++]);
				}
			}
			for (MidiChannel midiChannel : colChannels) {
				midiChannel.noteOn(50, 50);
			}
			Thread.sleep(200);
			colChannels.clear();
			index = 0;
		}

	}

	public static void main(String[] args) {

	}

}
