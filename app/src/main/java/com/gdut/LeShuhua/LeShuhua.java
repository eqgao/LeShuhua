package com.gdut.LeShuhua;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

/**
 * Created by lchua on 2017/1/14.
 * <p>
 * 描述：
 */

public class LeShuhua extends Application {

    public static String APP_CACHE_PATH = "LeShuhua/cache";

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 设置 Fresco 图片缓存的路径
         */
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(getApplicationContext())
                .setBaseDirectoryPath(getOwnCacheDirectory(this, APP_CACHE_PATH))
                .build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(getApplicationContext())
                .setMainDiskCacheConfig(diskCacheConfig)
                .setSmallImageDiskCacheConfig(diskCacheConfig)
                .build();
        //初始化 Fresco 图片缓存库
        Fresco.initialize(this, config);
    }

    public static File getOwnCacheDirectory(Context context, String cachePath) {
        File appCacheDir = null;

        if ("mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            appCacheDir = new File(Environment.getExternalStorageDirectory(), cachePath);
        }

        if (appCacheDir == null || !appCacheDir.exists() && !appCacheDir.mkdirs()) {
            appCacheDir = context.getCacheDir();
        }

        return appCacheDir;
    }

    public static boolean hasExternalStoragePermission(Context context) {
        int perm = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        return perm == 0;
    }
}
