package edu.cmu.pandaa.utils;

import edu.cmu.pandaa.header.ImpulseHeader;

public class ImpulseUtil {

	private int slowWindow;
	private int fastWindow;
	private double jerk;
	private double base;
	private double noisyFloor;
	private double quietImpulseFloor;
	private static double microphoneRms;
	private double usPerSample;

	private final int SLOWWINDOW = 2000;
	private final int FASTWINDOW = 10;
	private final double JERK = 3;
	private final double BASE = 50;
	private double RMSMAX = Math.pow(2, 16) / 2;
	private double MULTIPLIER = 0.15;

	public ImpulseUtil() {
		slowWindow = SLOWWINDOW;
		fastWindow = FASTWINDOW;
		jerk = JERK;
		base = BASE;
		noisyFloor = RMSMAX * MULTIPLIER;
		microphoneRms = Double.MAX_VALUE;
		quietImpulseFloor = jerk * 2 * base;

	}

	public double getUsPerSample() {
		return usPerSample;
	}

	public void setUsPerSample(double sampleRate) {
		this.usPerSample = Math.pow(10, 6) / (double) sampleRate; // us per
																	// sample
	}

	public double getQuietImpulseFloor() {
		return quietImpulseFloor;
	}

	public int getSlowWindow() {
		return slowWindow;
	}

	public int getFastWindow() {
		return fastWindow;
	}

	public double getJerk() {
		return jerk;
	}

	public double getBase() {
		return base;
	}

	public double getNoisyFloor() {
		return noisyFloor;
	}

	public static double getMicrophoneRms() {
		return microphoneRms;
	}

	public static void setMicrophoneRms(double rms) {
		if (microphoneRms > rms) {
			microphoneRms = rms;
			// if(rms<10)
			// microphoneRms=10;
		}
	}

}
