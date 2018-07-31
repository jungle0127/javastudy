package org.designpattern.structural.bridge;

public class UnixPlayer extends IOperatingSystemPlayer {

	@Override
	public void playVideo(String fileName) {		
		this.videoFile.decode(fileName);
		System.out.println("Play file on Unix.");
	}

}
