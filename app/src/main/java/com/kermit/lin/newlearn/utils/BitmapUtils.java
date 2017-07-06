package com.kermit.lin.newlearn.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import com.kermit.lin.newlearn.MyApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Lin on 2017/7/6.
 */

public class BitmapUtils {

    /**
     * 保存图片至本地
     * @param bitmap
     * @param dir 路径
     * @param name 文件名
     * @param isShowPhotos 是否加载到图库
     */
    public static boolean saveBitmapToSD(Bitmap bitmap,String dir, String name, boolean isShowPhotos){
        File file = new File(dir,name);
        File parentFile = file.getParentFile();
        if (!file.getParentFile().exists()){
            parentFile.mkdirs();
        }
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100,
                    fileOutputStream);
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //插入图库
        if (isShowPhotos){
            try {
                MediaStore.Images.Media.insertImage(MyApplication.getAppInstance().getContentResolver(),
                        file.getAbsolutePath(), name, null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // 最后通知图库更新
            MyApplication.getAppInstance().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file)));
        }
        return true;
    }
}
