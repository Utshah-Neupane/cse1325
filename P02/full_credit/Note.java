public class Note{

	//Two private Felds
	private Pitch pitch;
	private int octave;


	//Two public Constructors
	public Note(){
		this.pitch = null;
	}

	public Note (Pitch pitch, int octave){
	this.pitch = pitch;

	//validating octave
	if (octave < -5) this.octave = -5;
	else if (octave >= -5 && octave <=4) this.octave = octave;
	else this.octave = 4;
	}

	//One public Method


	

}