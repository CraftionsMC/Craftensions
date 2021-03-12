/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.craftensions.api;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetUtils {

    public static void download(String url1, File dest) {
        try {
            URL url = new URL(url1);
            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            FileOutputStream fis = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bis.read(buffer, 0, 1024)) != -1)
                fis.write(buffer, 0, count);
            fis.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Boolean urlExists(String u){
        try {
            URL url = new URL(u);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            if(huc.getResponseCode() != 404){
                return true;
            }else {
                return false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
