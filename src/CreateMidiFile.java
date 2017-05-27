import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jfugue.theory.TimeSignature;

public class CreateMidiFile {
	
	// 1. Create some MidiTracks
	MidiTrack tempoTrack = new MidiTrack();
	MidiTrack noteTrack = new MidiTrack();

	// 2. Add events to the tracks
	// Track 0 is the tempo map
	TimeSignature ts = new TimeSignature();
	ts.setTimeSignature(4, 4, TimeSignature.DEFAULT_METER, TimeSignature.DEFAULT_DIVISION);

	Tempo tempo = new Tempo();
	tempo.setBpm(228);

	tempoTrack.insertEvent(ts);
	tempoTrack.insertEvent(tempo);

	// Track 1 will have some notes in it
	final int NOTE_COUNT = 80;

	for(int i = 0; i < NOTE_COUNT; i++)
	{
	    int channel = 0;
	    int pitch = 1 + i;
	    int velocity = 100;
	    long tick = i * 480;
	    long duration = 120;
	    
	    noteTrack.insertNote(channel, pitch, velocity, tick, duration);
	}

	// 3. Create a MidiFile with the tracks we created
	List<MidiTrack> tracks = new ArrayList<MidiTrack>();
	tracks.add(tempoTrack);
	tracks.add(noteTrack);

	MidiFile midi = new MidiFile(MidiFile.DEFAULT_RESOLUTION, tracks);

	// 4. Write the MIDI data to a file
	File output = new File("exampleout.mid");
	try
	{
	    midi.writeToFile(output);
	}
	catch(IOException e)
	{
	    System.err.println(e);
	}
}
