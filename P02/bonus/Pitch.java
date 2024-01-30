public enum Pitch{
	C("C"), Db("Db"), D("D"), Eb("Eb"), E("E"), F("F"), Gb("Gb"), G("G"), Ab("Ab"), A("A"), Bb("Bb"), B("B");

	private final String string;

	private Pitch(String string){
		this.string = string;
	}

	@Override
	public String toString(){
		switch (this){
			case Db: return "D\u266d"; //unicode for flat b
			case Eb: return "E\u266d";
			case Gb: return "G\u266d";
			case Ab: return "A\u266d";
			case Bb: return "B\u266d";
			default: return name();
		}
	}
}