package model;

public class Memo {
	private int memoid;
	private String name;
	private int age;
	
	
	public int getMemoid() {
		return memoid;
	}
	public void setMemoid(int memoid) {
		this.memoid = memoid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Memo [memoid=" + memoid + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
