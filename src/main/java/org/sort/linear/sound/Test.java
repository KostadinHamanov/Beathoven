package org.sort.linear.sound;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Test {
	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
		Synthesizer synthesizer = MidiSystem.getSynthesizer();
		synthesizer.open();
		MidiChannel[] channels = synthesizer.getChannels();
		
		MidiChannel current = channels[0];
		
		current.programChange(47);
		current.noteOn(50,50);
		
		for(int i=18;i<400;i++) {
			current.programChange(i);
			System.out.println(current.getProgram());
			
			current.noteOn(50, 50);
			Thread.sleep(3000);
			current.noteOff(50);
		}

	}

}
