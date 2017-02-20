package dataMaker;

import java.util.Random;

public enum Domain { HOTMAIL, YAHOO,
	PROTONMAIL, AOL, OUTLOOK,
	GMAIL;

	private static final Domain[] VALUES = values();
	private static final int SIZE = VALUES.length;
	private static final Random RND = new Random();
	
	public static Domain getRandomDomain(){
		return VALUES[RND.nextInt(SIZE)];
	}
}
