package sound;

import java.util.Map;

public abstract class Speeker {
	
	    public static String FileSrc ="./voice";
		public static String getFileSrc() {
			return FileSrc;
		}

		public static void setFileSrc(String fileSrc) {
			FileSrc = fileSrc;
		}

		private static Map<String, String> sounds ;
		

		public static Map<String, String> getSounds() {
			return sounds;
		}

		public static void setSounds(Map<String, String> sounds) {
			Speeker.sounds = sounds;
		}
		
}
