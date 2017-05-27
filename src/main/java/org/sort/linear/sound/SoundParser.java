package org.sort.linear.sound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
		Map<Integer, Integer> notes = new HashMap<>();
		for (int i = 0; i < buttons[0].length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				if (buttons[j][i].isSelected()) {
					colChannels.add(channels[index]);
					notes.put(index, 10 + j * 10);
					index += 1;
				}
			}
			for (int k = 0; k < colChannels.size(); k++) {
				colChannels.get(k).programChange(3);
				colChannels.get(k).noteOn(notes.get(k), 50);
			}
			Thread.sleep(190);
			colChannels.clear();
			notes.clear();
			index = 0;

		}
	}

}
