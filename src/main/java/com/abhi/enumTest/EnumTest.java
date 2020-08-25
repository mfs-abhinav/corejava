package com.abhi.enumTest;

// enum is collection of named constant value.Can contains constructor,method,variables
// All enum is converted to class. All constant are bt deafult public static final.
// enum can not extend but implements. enum is child class of java.lang.Enum 
enum Beer {
	KF(100), RC(200) {
		@Override
		public void info() {
			System.out.println(this + " is costly beer and price is " + this.price);
		}
	},
	PQ(60), PO;

	int price;

	Beer() {
		System.out.println("enum default constructor is called");
	}

	Beer(int price) {
		this.price = price;
		System.out.println("enum parametrized constructor is called for " + price);
	}

//	 abstract  void info(); //in this case method has to be implemented by enum variables

	void info() {
		System.out.println(this + " is cheap beer and price is " + this.price);
	}
}

public class EnumTest {
	public static void main(String[] args) {
		Beer b2 = Beer.PO;
		Beer b3 = Beer.KF;
		System.out.println(b2);
		System.out.println(b3.ordinal());

		Beer[] b = Beer.values();
		System.out.println(Beer.KF.getClass().getSuperclass());

		for (Beer b1 : b) {
			b1.info();
		}
	}
}
