package co.javatoday.data.model;

public enum UserSource {

	FaceBook(1),
	LinkedIn(2),
	Twitter(4);
	
	private int value;
	
	UserSource(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
