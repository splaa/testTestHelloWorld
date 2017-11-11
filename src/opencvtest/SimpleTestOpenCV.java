/*
http://privateblog.info/sravnenie-raboty-s-kameroj-v-opencv-na-python-i-java/#more-1505
 */

package opencvtest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class SimpleTestOpenCV {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		VideoCapture camera = new VideoCapture(0);
		camera.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 320);
		camera.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 240);
		
		long startTime = System.currentTimeMillis();
		
		int index = 0;
		Mat frame = new Mat();
		while (index < 60) {
			if (camera.read(frame)) {}
			index++;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime) + "]");
		camera.release();
	}
	
}
