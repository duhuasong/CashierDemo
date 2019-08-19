package paydll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.KBDLLHOOKSTRUCT;
import com.sun.jna.platform.win32.WinUser.LowLevelKeyboardProc;
import com.sun.jna.platform.win32.WinUser.MSG;

import payUI.Pay;
import untill.KeyIntMap;
import untill.QraResolve;

public class UsbhookDll {
	static Logger log = LogManager.getLogger(UsbhookDll.class);
	private static HHOOK hhk;
	private static Pay pay ;
	public static Pay getPay() {
		return pay;
	}

	public static void setPay(Pay pay) {
		UsbhookDll.pay = pay;
	}

	private static LowLevelKeyboardProc keyboardHook;
	static List<Character> singleInput = new ArrayList<Character>();
	private int hasValue;
	public static String tmp = null;
	private UsbhookDll usbhook;
	private Lock lock;

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	public UsbhookDll getUsbhook() {
		return usbhook;
	}

	public void setUsbhook(UsbhookDll usbhook) {
		this.usbhook = usbhook;
	}

	public String getTmp() {
		return tmp;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}

	public int getHasValue() {
		return hasValue;
	}

	public void setHasValue(int hasValue) {
		this.hasValue = hasValue;
	}

	private static String caseCode() {
		StringBuffer buffer = new StringBuffer();
		for (Character i : singleInput) {
			buffer.append(i);
		}
		return buffer.toString();
	}

	public String init() {
		hasValue = 0;
		tmp = new String();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usbhook.hook();
	}

	public String hook() {
		Pay.setThread(Thread.currentThread());
		final User32 lib = User32.INSTANCE;
		HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
		keyboardHook = new LowLevelKeyboardProc() {
			boolean isShiftUp = false;

			@Override
			public LRESULT callback(int nCode, WPARAM wParam, KBDLLHOOKSTRUCT info) {
				if (nCode >= 0) {
					switch (wParam.intValue()) {
					case WinUser.WM_KEYDOWN:// 只监听键盘按下
						// 按下回车键，生成完整的字符串，并清空list
						if (info.vkCode == 13) {
							String text = caseCode();
							tmp = text;
							hasValue = 1;
							log.debug("discriminate:"+QraResolve.discriminate(tmp));
							if (QraResolve.discriminate(tmp)) {
								log.debug("tmp:"+tmp+"text:"+text);
								singleInput.clear();
								tmp = "";
								text ="";
								synchronized (lock) {
									lock.notify();
								}
								break;
							}
							log.debug("tmp:"+tmp+"text:"+text);
							singleInput.clear();
							tmp = "";
							text ="";
							break;
						}

						// 按下的是shift键时，标记一下
						if (info.vkCode == 160) {
							isShiftUp = true;
						}
						if (!isShiftUp) {
							if (info.vkCode >= 65 && info.vkCode <= 90) {// 字母键
								singleInput.add((char) (info.vkCode + 32));
							} else if (info.vkCode >= 219 && info.vkCode <= 221) {// [\]
								singleInput.add((char) (info.vkCode - 128));
							} else if (info.vkCode >= 188 && info.vkCode <= 191) {// ,-./
								singleInput.add((char) (info.vkCode - 144));
							} else if (info.vkCode >= 48 && info.vkCode <= 57) {// 数字键
								singleInput.add((char) info.vkCode);
							}
							if (info.vkCode == 186) {
								singleInput.add(';');
							}
							if (info.vkCode == 187) {
								singleInput.add('=');
							}
							if (info.vkCode == 192) {
								singleInput.add('`');
							}
							if (info.vkCode == 222) {
								singleInput.add('\'');
							}
						} else {
							// 大写字母
							if (info.vkCode >= 65 && info.vkCode <= 90) {
								singleInput.add((char) info.vkCode);
							}

							switch (info.vkCode) {
							case 186:
								singleInput.add(':');
								break;
							case 187:
								singleInput.add('+');
								break;
							case 188:
								singleInput.add('<');
								break;
							case 189:
								singleInput.add('_');
								break;
							case 190:
								singleInput.add('>');
								break;
							case 191:
								singleInput.add('?');
								break;
							case 192:
								singleInput.add('~');
								break;
							case 219:
								singleInput.add('{');
								break;
							case 220:
								singleInput.add('|');
								break;
							case 221:
								singleInput.add('}');
								break;
							case 222:
								singleInput.add('\"');
								break;
							case 48:
								singleInput.add('!');
								break;
							case 49:
								singleInput.add('@');
								break;
							case 50:
								singleInput.add('#');
								break;
							case 51:
								singleInput.add('$');
								break;
							case 52:
								singleInput.add('%');
								break;
							case 53:
								singleInput.add('^');
								break;
							case 54:
								singleInput.add('&');
								break;
							case 55:
								singleInput.add('*');
								break;
							case 56:
								singleInput.add('(');
								break;
							case 57:
								singleInput.add(')');
								break;
							}
						}
						break;
					case WinUser.WM_KEYUP:// 按键起来
						if (info.vkCode == 160) {
							isShiftUp = false;
						}
						break;
					}
				}
				Pointer ptr = info.getPointer();
				long peer = Pointer.nativeValue(ptr);
				return lib.CallNextHookEx(hhk, nCode, wParam, new LPARAM(peer));
			}
		};
		hhk = lib.SetWindowsHookEx(WinUser.WH_KEYBOARD_LL, keyboardHook, hMod, 0);

		// This bit never returns from GetMessage
		int result;
		MSG msg = new MSG();
		while ((result = lib.GetMessage(msg, null, 0, 0)) != 0) {
			if (result == -1) {
				// System.err.println("error in get message");
				break;
			} else {
				// System.err.println("got message");
				lib.TranslateMessage(msg);
				lib.DispatchMessage(msg);

			}
		}
		lib.UnhookWindowsHookEx(hhk);
		return tmp;
	}

	/*
	 * public static void main(String[] args) { UsbhookDll usbhook = new
	 * UsbhookDll(); usbhook.init(); }
	 */
}
