package com.github.desn.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    StringBuffer              sb               = new StringBuffer("x");

    /* ǳ���� */
    public Object clone() throws CloneNotSupportedException {
        Prototype p = (Prototype) super.clone();
        return p;
    }

    /* ��� */
    public Object deepClone() throws IOException, ClassNotFoundException {

        /* д�뵱ǰ����Ķ������� */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* �������������������¶��� */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();

        // ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // ObjectOutputStream oos = new ObjectOutputStream(bos);
        // oos.writeObject(this);
        //        
        // ByteArrayInputStream bis = new
        // ByteArrayInputStream(bos.toByteArray());
        // ObjectInputStream ois = new ObjectInputStream(bis);
        // return ois.readObject();
    }

    public static void main(String[] args) throws Exception {
        Prototype p1 = new Prototype();
        Prototype p2 = (Prototype) p1.clone();
        p1.sb.append("p2");
        System.out.println(p2.sb);
        
        Prototype p3 = (Prototype) p1.deepClone();
        p1.sb.append("p3");
        System.out.println(p3.sb);
    }

}
