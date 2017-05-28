package org.sort.linear.sound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JToggleButton;

import jdk.nashorn.internal.parser.JSONParser;

public class SoundParser {

	private static final int TIME_IN_MILISECONDS = 190;
//
//	final JToggleButton[][] buttons
	public static void parse() throws MidiUnavailableException, InterruptedException {
		Map<String,Boolean[][]> map = org.sort.linear.gui.JSONParser.parse();
		
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
					notes.put(index, 30 + j);
					index += 1;
				}
			}
			for (int k = 0; k < colChannels.size(); k++) {
				colChannels.get(k).programChange(24);
				colChannels.get(k).noteOn(notes.get(k), 80);
			}
			Thread.sleep(TIME_IN_MILISECONDS);
			colChannels.clear();
			notes.clear();
			index = 0;

		}
	}

	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
		SoundParser.parse();
	}

}
