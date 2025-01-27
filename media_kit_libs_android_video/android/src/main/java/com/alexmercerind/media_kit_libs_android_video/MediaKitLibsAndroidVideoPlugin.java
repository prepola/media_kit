/**
 * This file is a part of media_kit (https://github.com/alexmercerind/media_kit).
 *
 * Copyright © 2021 & onwards, Hitesh Kumar Saini <saini123hitesh@gmail.com>.
 * All rights reserved.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file.
 */
package com.alexmercerind.media_kit_libs_android_video;

import android.util.Log;
import androidx.annotation.NonNull;

import com.alexmercerind.mediakitandroidhelper.MediaKitAndroidHelper;

import io.flutter.embedding.engine.plugins.FlutterPlugin;

/** MediaKitLibsAndroidVideoPlugin */
public class MediaKitLibsAndroidVideoPlugin implements FlutterPlugin {
    static {
        // DynamicLibrary.open on Dart side may not work on some ancient devices unless System.loadLibrary is called first.
        try {
            System.loadLibrary("mpv");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            System.loadLibrary("avcodec");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        Log.i("media_kit", "package:media_kit_libs_android_video attached.");
        try {
            // Save android.content.Context for access later within MediaKitAndroidHelpers e.g. loading bundled assets.
            MediaKitAndroidHelper.setApplicationContextJava(flutterPluginBinding.getApplicationContext());
            Log.i("media_kit", "Saved application context.");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        Log.i("media_kit", "package:media_kit_libs_android_video detached.");
    }
}
