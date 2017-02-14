package dataMaker;

import java.util.Random;

public enum Profession { ACCOUNTANT,
	BIOLOGIST, CHEMIST,	DOCTOR,	DRIVER,
	ENGINEER, FARMER, NURSE, PHARMACIST,
	PHYSICIST, RECEPTIONIST, STUDENT, TEACHER,
	UNEMPLOYED;
	
	private static final Profession[] VALUES = values();
	private static final int SIZE = VALUES.length;
	private static final Random RND = new Random();
	
	public static Profession getRandomProf(){
		return VALUES[RND.nextInt(SIZE)];
	}
}
