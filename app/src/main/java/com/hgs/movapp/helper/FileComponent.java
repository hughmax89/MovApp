package com.hgs.movapp.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;


import com.hgs.data.utils.Logger;
import com.hgs.movapp.component.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class FileComponent {
    public static String getUrlMediaFile(String extension){

        File file = new File(Environment.getExternalStorageDirectory(), Constants.MEDIA_DIRECTORY);
        if (!file.exists()) {
            file.mkdirs();
        }

        Long timestamp = System.currentTimeMillis() / 1000;
        Random r = new Random();
        int i1 = r.nextInt(1000);

        String imagen_codigo = timestamp.toString() + "_" + i1;
        String imagen_nombre = imagen_codigo + extension;
        return Environment.getExternalStorageDirectory()
                + File.separator
                + Constants.MEDIA_DIRECTORY
                + File.separator
                + imagen_nombre;
    }

    public static String ReziseImageFile(String photoPath){

        String fileName = getUrlMediaFile(Constants.EXTENSION_JPG);
        File fileDelete = new File(photoPath);
        if (fileDelete.exists()) {
            File file = new File(fileName);
            try {
                FileOutputStream out = new FileOutputStream(file);
                resizeBitmap(photoPath).compress(Bitmap.CompressFormat.JPEG, 90, out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
                Logger.e("FileComponent",e.getMessage());
            }

            fileDelete.delete();

            return fileName;
        }

        return photoPath;
    }

    private static Bitmap resizeBitmap(String photoPath) {
        Bitmap yourBitmap = BitmapFactory.decodeFile(photoPath);

        return Bitmap.createScaledBitmap(
                yourBitmap,(int)(yourBitmap.getWidth()*0.5), (int)(yourBitmap.getHeight()*0.5), true);
    }
}
