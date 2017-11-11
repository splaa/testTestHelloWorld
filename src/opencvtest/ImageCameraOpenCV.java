/*
http://privateblog.info/java-tips-and-tricks/kak-poluchit-kartinku-s-kamery-s-pomoshhyu-opencv/
 */
package opencvtest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class ImageCameraOpenCV {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		VideoCapture camera = new VideoCapture(0);
		camera.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 1280);
		camera.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 720);
		
		if (!camera.isOpened()) {
			System.out.println("Error");
		} else {
			int index = 0;
			Mat frame = new Mat();
			while (true) {
				if (camera.read(frame)) {
					System.out.println("Captured Frame Whith " + frame.width() +
							Imgcodecs.imwrite("camera" + (index++) + ".jpg", frame));
					System.out.println("Ok");
					//break;
				}
			}
		}
		camera.release();
	}
}
