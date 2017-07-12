import java.io.*;

public class Cat implements Pet, Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String color;
	private int age;
	public Cat (String n, String c, int a) {
		name = n;
		color = c;
		age = a;
		a = a;
	}
	@Override
	public void setName (String n) {
		name = n;
	}
	@Override
	public void setColor (String c) {
		color = c;
	}
	@Override
	public void setAge (int a) {
		age = a;
	}
	@Override
	public String getName () {
		return name;
	}
	@Override
	public String getColor () {
		return color;
	}
	@Override
	public int getAge () {
		return age;
	}
	@Override
	public String toString () {
		return "Name : " + name + " Color : " + color + " Age : " + age + " miao!";
	}
}
