package gotoagilevn.com.nguyenle.schedual.util;

public enum VideoFilterEnum {
	

	UPPER_NAI("Nai"),LOWER_NAI("nai"),
	UPPER_SALAD("Salad"),LOWER_SALAD("salad");
	private final String stringValue;

	private VideoFilterEnum(final String s) {
		stringValue = s;
	}

	public String toString() {
		return stringValue;
	}
}
