package store;

public enum Exposure {SHADE, PARTSUN, SUN;

	@Override
	public String toString(){
		if (this.equals(SHADE)){
			return "no sun";
		}
		else if (this.equals(PARTSUN)){
			return "part shade";
		}
		else {
			return "full sun";
		}
	}
}