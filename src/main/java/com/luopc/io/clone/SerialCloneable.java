package com.luopc.io.clone;

import java.io.*;

public class SerialCloneable implements Serializable, Cloneable {

    private static final long serialVersionUID = -2167327824425342502L;

    @Override
    public Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream boot = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(boot);
             ByteArrayInputStream bin = new ByteArrayInputStream(boot.toByteArray());
             ObjectInputStream in = new ObjectInputStream(bin)) {

            out.writeObject(this);
            out.close();

            Object ret = in.readObject();
            in.close();
            return ret;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return super.clone();
    }

}
