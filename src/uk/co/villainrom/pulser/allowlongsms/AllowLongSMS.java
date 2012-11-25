package uk.co.villainrom.pulser.allowlongsms;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class AllowLongSMS implements IXposedHookLoadPackage {
	public static final String MY_PACKAGE_NAME = AllowLongSMS.class.getPackage()
			.getName();
	public static final String TAG = "PulserMmsTweak";

	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		// TODO Auto-generated method stub
		if (lpparam.packageName.equals("com.android.mms")) {
			ClassLoader classLoader = lpparam.classLoader;
			XC_MethodReplacement methodreplacer = new XC_MethodReplacement() {
				protected Object replaceHookedMethod(
						XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
						throws Throwable {
					return Integer.valueOf(255);
					
				}
			};
			XposedHelpers.findAndHookMethod("com.android.mms.MmsConfig",
					classLoader, "getSmsToMmsTextThreshold", methodreplacer);
		}

	}

}
