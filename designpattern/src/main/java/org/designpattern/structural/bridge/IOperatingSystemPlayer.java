package org.designpattern.structural.bridge;

public abstract class IOperatingSystemPlayer {
	IVideoFileFormat videoFile;
	public abstract void playVideo(String fileName);
	public void setFileFormat(IVideoFileFormat format) {
		this.videoFile = format;
	}
}
