package sound;

import java.io.File;
import java.util.Scanner;
import java.applet.AudioClip;
import java.applet.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Mp3Player extends Speeker{
	public static void pl(String fString) {
		File file = new File(fString);
		URL url = null;
		try {
			url = new URL("file:" + file.getPath());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AudioClip sc = Applet.newAudioClip(url);
		sc.play();
	}
/*	public static void main(String[] args) {
		
	}*/
}
