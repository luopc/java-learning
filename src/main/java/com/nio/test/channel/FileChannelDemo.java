package com.nio.test.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile afile = new RandomAccessFile("D:\\test.txt", "rw");
        FileChannel fchannel = afile.getChannel();
        // create buffer with capacity of 64 bytes
        ByteBuffer buf = ByteBuffer.allocate(64);

        // read into buffer.
        int byteRead = fchannel.read(buf);
        while (byteRead != -1) {
            System.out.println("Read:" + byteRead);

            //flip方法将Buffer从写模式切换到读模式。
            buf.flip();// make buffer ready for read
            while (buf.hasRemaining()) {
                System.out.println(buf.get());
            }
            
            buf.clear();// make buffer ready for writing
            byteRead = fchannel.read(buf);
        }
        afile.close();
    }

}
