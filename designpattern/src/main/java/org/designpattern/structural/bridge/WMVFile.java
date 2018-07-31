package org.designpattern.structural.bridge;

public class WMVFile implements IVideoFileFormat {

	@Override
	public void decode(String fileName) {
		System.out.println("Decode file with WMV format.");
	}

}
