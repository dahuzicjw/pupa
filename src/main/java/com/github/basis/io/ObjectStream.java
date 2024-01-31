package com.github.basis.io;

import java.io.*;

public class ObjectStream {

	public static void main(String[] args) throws Exception{
//		ObjectOutputStream out = new ObjectOutputStream(
//				new FileOutputStream("c://obj.txt"));
//		Student kevin1 = new Student("kevin1","b1","male",27);
//		Student.i = 111;
//		out.writeObject(kevin1);
//		out.writeObject(new Student("kevin2","b2","male",27));
//		out.writeObject(new Student("kevin3","b3","male",27));
//		out.writeObject(null);
//		out.flush();
//		out.close();
		
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("c://obj.txt"));
		Object s;
		while((s = in.readObject()) != null){
			System.out.println(s);
		}
		in.close();
	}
}

class Student implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private String name = "";
	private String grade;
	private String sex;
	private transient int age;
	public static int i = 0;
	
//	private void writeObject(ObjectOutputStream out) throws IOException {  
//        out.defaultWriteObject();  
//        out.writeInt(age);  
//    } 
//	
//	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException{
//		in.defaultReadObject();
//		age = in.readInt();
//	}
	
	public Student(String name, String grade, String sex, int age) {
		super();
		this.name = name;
		this.grade = grade;
		this.sex = sex;
		this.age = age;
	}
	
	public String toString(){
		return name+ "," + grade +", age:" + age + "," + sex
		+ ",i:" + i;
	}
	
	
}
