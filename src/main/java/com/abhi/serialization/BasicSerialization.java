package com.abhi.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Color {
	private int color;

	Color(int c) {
		this.color = c;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}

class Cat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int catCount;
	transient private Color color;

	Cat(Color c, int count) {
		this.color = c;
		this.catCount = count;
	}

	public int getCatCount() {
		return catCount;
	}

	public Color getColor() {
		return color;
	}

	public void setCatCount(int catCount) {
		this.catCount = catCount;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	private void writeObject(ObjectOutputStream os) throws IOException {

		os.defaultWriteObject();
		os.writeInt(this.color.getColor());
	}

	private void readObject(ObjectInputStream oi) throws IOException,
			ClassNotFoundException {

		oi.defaultReadObject();
		this.color = new Color(oi.readInt());
	}
}

public class BasicSerialization {
	public static void main(String[] args) {
		Color color = new Color(190);

		Cat obj = new Cat(color, 10);

		try {
			FileOutputStream fs = new FileOutputStream("testSer.txt");

			ObjectOutputStream os = new ObjectOutputStream(fs);

			System.out.println(obj.getCatCount() + "  " + obj.getColor().getColor());

			os.writeObject(obj);

			os.flush();
			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fi = new FileInputStream("testSer.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);

			Cat obj1 = (Cat) oi.readObject();

			System.out.println(obj1.getCatCount() + "  " + obj1.getColor().getColor());

			oi.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
