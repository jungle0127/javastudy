package org.designpattern.structural.bridge;

public class RMVBFile implements IVideoFileFormat {

	@Override
	public void decode(String fileName) {
		System.out.println("Decode RMVB file.");
	}

}
