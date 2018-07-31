package org.designpattern.structural.bridge;

public class WindowsPlayer extends IOperatingSystemPlayer {
	
	@Override
	public void playVideo(String fileName) {
		this.videoFile.decode("");
		System.out.println("Play file on Windows.");
	}

}
