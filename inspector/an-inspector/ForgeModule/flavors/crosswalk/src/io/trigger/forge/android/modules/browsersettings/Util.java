package io.trigger.forge.android.modules.browsersettings;

import android.os.Build;


import io.trigger.forge.android.core.ForgeApp;
import io.trigger.forge.android.core.ForgeLog;

public class Util {
	public static void setInlineVideo(boolean forceInlineVideo) {
		//not required for android, video plays inline by default	
	}

	public static void setAutoplayVideo(boolean autoplayVideo) {
		if (Build.VERSION.SDK_INT >= 17 /* Build.VERSION_CODES.JELLY_BEAN_MR1 */) {		
			ForgeApp.getActivity().webView.getSettingsInternal().setMediaPlaybackRequiresUserGesture(!autoplayVideo);
		} else {
			ForgeLog.w("browsersettings.setAutoPlayVideo() is only supported on Android API level 17 (Jelly Bean MR1) or higher.");
		}
	}

	public static void setAcceptCookies(boolean acceptCookies){		
		// crosswalk does not support setAcceptThirdPartyCookies
	}
}
