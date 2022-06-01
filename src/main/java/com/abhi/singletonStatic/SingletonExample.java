package com.abhi.singletonStatic;

class TestSingleton {
	private static TestSingleton singletonObj;
	static int count;

	static {
		count = 0;
		singletonObj = new TestSingleton();
	}
	private TestSingleton() {

	}
	
	public static TestSingleton getInstance(){
		/*if(singletonObj == null){
			singletonObj = new SingletonExample();
			return singletonObj;
		} else {
			return singletonObj;
		}*/
		count++;
		return singletonObj;
	}
	public void display() {
		System.out.println("Object is " + this);
	}
}

public class SingletonExample {
	public static void main(String[] args) {
		TestSingleton obj1 = TestSingleton.getInstance();
		obj1.display();
		TestSingleton obj2 = TestSingleton.getInstance();
		obj2.display();
		
		System.out.println(obj1 == obj2);
	}
}
