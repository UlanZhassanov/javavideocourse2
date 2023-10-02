package io_and_nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("text10.txt", "rw");
             FileChannel fileChannel = file.getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(25);
            StringBuilder stringBuilder = new StringBuilder();

            int bytRead = fileChannel.read(byteBuffer);
            while (bytRead>0){
                System.out.println("Read" + bytRead);

                byteBuffer.flip();

                while (byteBuffer.hasRemaining()){
                    stringBuilder.append((char) byteBuffer.get());
                }

                byteBuffer.clear();
                bytRead = fileChannel.read(byteBuffer);
            }
            System.out.println(stringBuilder);

            String text = "\nYour Winter-garment of Repentance fling:Your Winter-garment of Repentance fling:Your Winter-garment of Repentance fling:";

            ByteBuffer byteBuffer2 = ByteBuffer.allocate(text.getBytes().length);
            byteBuffer2.put(text.getBytes());
            byteBuffer2.flip();
            fileChannel.write(byteBuffer2);


            ByteBuffer byteBuffer3 = ByteBuffer.wrap(text.getBytes());
            fileChannel.write(byteBuffer3); 

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
