package org.designpattern.structural.bridge;

public class Client {

	public static void main(String[] args) {
		IOperatingSystemPlayer player = new UnixPlayer();
		player.setFileFormat(new AVIFile());
		player.playVideo("sharenk.avi");
		player.setFileFormat(new MPEGFile());
		player.playVideo("");
		player = new LinuxPlayer();
		player.setFileFormat(new RMVBFile());
		player.playVideo("");
	}

}
