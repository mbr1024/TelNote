package cn.itcast;
public class Person {
	private int id;// 用户ID 属性
	private String name;// 用户姓名属性
	private int age; //用户年龄属性
	private String sex; //用户性别属性
	private String telNum; //用户电话号码属性
	private String address;// 用户地址属性

	Person() {
		//无参数构造方法
	}

	public Person(String name, int age, String sex, String telNum, String address) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.telNum = telNum;
		this.address = address;
	}
	
	public String getName() {//读取用户名
		
		return this.name;
		
	}

	public void setName(String name) {//设置用户名
		
		this.name=name;
		
	}
	
	public int getAge() {//读取用户年龄
		
		return this.age;
	}
	
	public void setAge(int age){//设置用户年龄
		
		this.age=age;
	}
	
	public String getSex() {//读取用户性别
		
		return this.sex;
	}
	
	public void setSex(String sex) {//设置用户性别
		
		this.sex=sex;
	}
	
	public String getTelNum() {//读取用户电话号码
		
		return this.telNum;
		
	}
	
	public void setTelNum (String telNum){ //设置用户电话号码
		
		this.telNum=telNum;
		
	}
	
	public String getAddress(){//读取用户地址
		
		return this.address;
	}
	
	public void setAddress(String address) {//设置用户地址
		 
		this.address=address;
		
	}
	 
	public int getId () {//读取用户ID号
		
		return this.id;
	}
	
	public void setId (int id) {//设置用户ID号
		
		this.id=id;
		
	}
	
	public String toString() {
		return "序号   " + id + "  姓名  " + name + "      年龄    " + age + "       性别   " + sex + "       电话号码" + telNum
				+ "       住址" + address + "\n\t";
	}

}

