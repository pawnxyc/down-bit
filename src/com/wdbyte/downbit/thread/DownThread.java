package com.wdbyte.downbit.thread;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.Callable;

public class DownThread implements Callable {
    private String str;

    public DownThread(String str){
        this.str = str;
    }
    @Override
    public Boolean call() throws Exception {
        File f = new File("text.txt");
        RandomAccessFile file = new RandomAccessFile("text.txt","rw");
        int i = 0;
        while (i++<10){
//            file.seek(f.length());
            file.writeChars(str);
        }
        file.close();
        return true;
    }
}
