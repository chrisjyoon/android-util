package com.chrisjyoon.library;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chris on 2016. 3. 9..
 *
 */
public class FileUtil {

    public static boolean copyFile(File src, File dest) {
        try {
            Logger.d("src = " + src.getAbsolutePath());
            Logger.d("dest = " + dest.getAbsolutePath());
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            copyFile(fis, fos);
            fos.close();
            fis.close();
        } catch (IOException e) {
            Logger.e("Copy File IOException : " + e.getMessage());
            return false;
        }
        return true;
    }

    public static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }

    }

    public static File getPictureFile(Context context, String fileName) {
        fileName = removeFilePath(fileName);
        File externalFilesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            externalFilesDir = context.getExternalFilesDir(null);
        }


        return new File(externalFilesDir, fileName);
    }

    private static String removeFilePath(String org) {
        if (!org.contains("/")) return org;
        String fileName = "";

        Pattern p = Pattern.compile(".+/(.+)$");
        Matcher m = p.matcher(org);

        if (m.find()) {
            fileName = m.group(1);
        }
        return fileName;
    }

}
