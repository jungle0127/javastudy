package org.designpattern.structural.bridge;

public class MPEGFile implements IVideoFileFormat {

	@Override
	public void decode(String fileName) {
		System.out.println("Decode MPEG file.");
	}

}
