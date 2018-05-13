package com.luopc.serializable;
/**
 * java 序列化
 * @author luopc
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo{

    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:\\java-output\\result.obj"));
        out.writeObject(new StaticTest(10));
        out.close();
        
        StaticTest.staticVar = 10;
        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:\\java-output\\result.obj"));
        StaticTest demo = (StaticTest) in.readObject();
        in.close();
        
        System.out.println(demo.staticVar);
        System.out.println(demo.getIntvar());
        System.out.println(demo.getPassword());
    }

}
