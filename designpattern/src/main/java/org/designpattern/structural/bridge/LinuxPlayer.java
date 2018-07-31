package org.designpattern.structural.bridge;

public class LinuxPlayer extends IOperatingSystemPlayer {

	@Override
	public void playVideo(String fileName) {
		this.videoFile.decode("");
		System.out.println("Play file on Linux");
	}

}
