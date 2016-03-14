package javase.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) {
		Customer cust = new Customer("zhangsan", 18);

		try {
			Customer copy = (Customer) new ReflectTest().copy(cust);

			System.out.println(copy);

		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public Object copy(Object obj) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {

		Class<?> clazz = obj.getClass();

		System.out.println("class: " + clazz.getName());

		Object copyObject = clazz.newInstance();

		Field[] fields = clazz.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {

			Field field = fields[i];

			String fieldName = field.getName();

			String firstLetter = fieldName.substring(0, 1).toUpperCase();

			String getMethodName = "get" + firstLetter + fieldName.substring(1);

			String setMethodName = "set" + firstLetter + fieldName.substring(1);

			Method getMethod = clazz.getMethod(getMethodName, new Class[] {});

			Method setMethod = clazz.getMethod(setMethodName, new Class[] { field.getType() });

			Object value = getMethod.invoke(obj, new Object[] {});

			System.out.println(fieldName + " : " + value);

			setMethod.invoke(copyObject, new Object[] { value });
		}

		return copyObject;

	}

}

class Customer {
	private Long id;
	private String name;
	private int age;

	public Customer() {
	}

	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "name:" + name + ",age:" + age;
	}

}