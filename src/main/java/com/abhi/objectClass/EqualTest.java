package com.abhi.objectClass;

class Student {
	String name;
	int roll;

	Student(String name, int roll) {
		this.name = name;
		this.roll = roll;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + this.roll;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else {
			if (obj instanceof Student) {
				Student s = (Student) obj;
				if (this.name.equals(s.name) && this.roll == s.roll) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
}

public class EqualTest {

	public static void main(String[] args) {
		Student obj1 = new Student("Abhinav", 2);
		Student obj2 = new Student("Banti", 10);
		Student obj3 = new Student("Abhinav", 2);
		//System.out.println(obj1);
		//System.out.println(obj2);
		System.out.println(obj1==obj3);
		System.out.println("Object is equal: " + obj1.equals(obj3));
		System.out.println("Hash Code is equal: " + (obj1.hashCode() == obj3.hashCode()));
		
		
		String s1 = new String("Banti");
		String s2 = new String("Banti");
		String s3 = "Banti";
		
		/*System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));*/
		
		/*StringBuffer sb1 = new StringBuffer("Banti");
		StringBuffer sb2 = new StringBuffer("Banti");
		
		System.out.println(sb1==sb2);
		System.out.println(sb1.equals(sb2));*/
	}

}
