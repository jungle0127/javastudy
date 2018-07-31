package org.designpattern.structural.bridge;

public class AVIFile implements IVideoFileFormat {

	@Override
	public void decode(String fileName) {
		System.out.println("Decode AVI file.");
	}

}
