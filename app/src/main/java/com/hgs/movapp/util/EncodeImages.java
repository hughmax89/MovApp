package com.hgs.movapp.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class EncodeImages {

    public static String encodeImageToBase(String photoPath){
        String codeBase64 = "data:image/jpeg;base64,";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        byte[] imageBytes = baos.toByteArray();
        String imageString = null;
        try {
            imageString = new String(Base64.encode(imageBytes, Base64.DEFAULT), "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return codeBase64 + imageString;
    }
}
