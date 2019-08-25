package sound;

/**
 * java语音播报示例
 * 
 */

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.*;

public class Voice extends Speeker{
	private String psString;

	public String getPsString() {
		return psString;
	}

	public void loadXml(File file) throws IOException {
		FileReader f = null;
		try {
			f = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 从缓存区拿到数据
		BufferedReader bf = new BufferedReader(f);
		String content = "";

		// 拿到缓冲区的数据
		while ((content = bf.readLine()) != null) {
			psString = psString + content;
		}
		bf.close();
		System.out.println(psString);
	}

	public static void voice(String content) throws IOException {
		// 拿到音响
		ActiveXComponent sap = new ActiveXComponent("sapi.SpVoice");
		// 找到本地要朗读的文件
		sap.setProperty("Volume", new Variant(100));
		sap.setProperty("Rate", new Variant(0));
		Dispatch xj = sap.getObject();
		// 执行朗读 没有读完就继续读
	    Dispatch.call(xj, "Speak", new Variant(content));
		xj.safeRelease();
	}

	public static void transform(String content, String file) {
		ActiveXComponent ax = new ActiveXComponent("Sapi.SpVoice");
		Dispatch spVoice = ax.getObject();
		ax = new ActiveXComponent("Sapi.SpFileStream");
		Dispatch spFileStream = ax.getObject();
		ax = new ActiveXComponent("Sapi.SpAudioFormat");
		Dispatch spAudioFormat = ax.getObject();
		// 设置音频流格式
		Dispatch.put(spAudioFormat, "Type", new Variant(22));
		// 设置文件输出流格式
		Dispatch.putRef(spFileStream, "Format", spAudioFormat);
		// 调用输出 文件流打开方法，创建一个.wav文件
		Dispatch.call(spFileStream, "Open", new Variant(file), new Variant(3), new Variant(true));
		// 设置声音对象的音频输出流为输出文件对象
		Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
		// 设置音量 0到100
		Dispatch.put(spVoice, "Volume", new Variant(100));
		// 设置朗读速度
		Dispatch.put(spVoice, "Rate", new Variant(-2));
		// 开始朗读
		Dispatch.call(spVoice, "Speak", new Variant(content));
		// 关闭输出文件
		Dispatch.call(spFileStream, "Close");
		Dispatch.putRef(spVoice, "AudioOutputStream", null);
		spAudioFormat.safeRelease();
		spFileStream.safeRelease();
		spVoice.safeRelease();
		ax.safeRelease();
	}

/*	public static void main(String[] args) {
		String ss = "收款成功";
		try {
			voice("收款成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
