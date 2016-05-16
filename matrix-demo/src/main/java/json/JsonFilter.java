package json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class JsonFilter {

	public static void main(String[] args) {

		Person p = new Person("1", "a", "aa");

		List<Person> list = new ArrayList<>();
		list.add(p);

		getSubNodeJson(list);

	}

	public static JSONObject getSubNodeJson(List<Person> nodes) {
		JsonConfig jsonConfig = new JsonConfig();
		JSONObject json = new JSONObject();
		// 字段过滤器
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object source, String name, Object value) {
				System.out.println(name);
				if (source != null) {
					if (name.equals("birthday") || name.equals("operaMap")) {
						return true;
					}
				}
				return false;
			}
		});

		json.put("data", JSONArray.fromObject(nodes, jsonConfig));

		return json;
	}

}

class Person {

	private String id;
	private String name;
	private String sex;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
