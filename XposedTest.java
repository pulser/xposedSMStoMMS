package uk.co.villainrom.pulser.xposedtest;
//import the xposed bridge code
import java.lang.reflect.Method;

import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XCallback;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;
import de.robv.android.xposed.XC_MethodReplacement;
public class XposedTest 
{
	public static void init(String startClassName)
	{
		if (startClassName != null)
			return;
		
		try {
			final XC_LoadPackage.LoadPackageParam.packageName=
			//XposedBridge.hookLoadPackage(XposedTest.class, "handleLoadPackage", XCallback.PRIORITY_DEFAULT);
			XposedBridge.hookLoadPackage(callback);
			XC_MethodReplacement.
			
		} catch (Throwable t) {
			XposedBridge.log(t);
		}
	}
	
	
	// handle the loading of a package
	private static void handleLoadPackage(String packageName, ClassLoader classLoader) {
		if (!packageName.equals("com.android.mms"))
			return;
		
		XposedBridge.log("we are in MMS!");
		
		try {
			Method updateClock =
				Class.forName("com.android.mms.MmsConfig", false, classLoader)
				.getDeclaredMethod("getSmsToMmsTextThreshold");
			//XposedBridge.hookMethod(updateClock, XposedTest.class, "handleUpdateClock", XCallback.PRIORITY_DEFAULT);
			XC_LoadPackage.
			XposedBridge.
		} catch (Exception e) {
			XposedBridge.log(e);
		}
		
	}
}
