package io.trigger.forge.android.modules.browsersettings;

import com.google.gson.JsonObject;

import io.trigger.forge.android.core.ForgeApp;
import io.trigger.forge.android.core.ForgeEventListener;
import android.os.Bundle;

public class EventListener extends ForgeEventListener {

	public void onCreate(Bundle savedInstanceState) {
		JsonObject config = (JsonObject)ForgeApp.configForModule("browsersettings");

		if (config.has("media_playback") && config.getAsJsonObject("media_playback").has("inline_video") && config.getAsJsonObject("media_playback").get("inline_video").getAsBoolean()) {
			Util.setInlineVideo(true);
		}

		if (config.has("media_playback") && config.getAsJsonObject("media_playback").has("autoplay_video") && config.getAsJsonObject("media_playback").get("autoplay_video").getAsBoolean()) {
			ForgeApp.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Util.setAutoplayVideo(true);
				}
			});
		}

		if (config.has("accept_cookies") && config.get("accept_cookies").getAsBoolean()) {
			Util.setAcceptCookies(true);
		}

		if (config.has("enable_force_touch") && config.get("enable_force_touch").getAsBoolean()) {
			Util.setForceTouchEnabled(true);
		}
	}

}
