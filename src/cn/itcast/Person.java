package cn.itcast;
public class Person {
	private int id;// �û�ID ����
	private String name;// �û���������
	private int age; //�û���������
	private String sex; //�û��Ա�����
	private String telNum; //�û��绰��������
	private String address;// �û���ַ����

	Person() {
		//�޲������췽��
	}

	public Person(String name, int age, String sex, String telNum, String address) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.telNum = telNum;
		this.address = address;
	}
	
	public String getName() {//��ȡ�û���
		
		return this.name;
		
	}

	public void setName(String name) {//�����û���
		
		this.name=name;
		
	}
	
	public int getAge() {//��ȡ�û�����
		
		return this.age;
	}
	
	public void setAge(int age){//�����û�����
		
		this.age=age;
	}
	
	public String getSex() {//��ȡ�û��Ա�
		
		return this.sex;
	}
	
	public void setSex(String sex) {//�����û��Ա�
		
		this.sex=sex;
	}
	
	public String getTelNum() {//��ȡ�û��绰����
		
		return this.telNum;
		
	}
	
	public void setTelNum (String telNum){ //�����û��绰����
		
		this.telNum=telNum;
		
	}
	
	public String getAddress(){//��ȡ�û���ַ
		
		return this.address;
	}
	
	public void setAddress(String address) {//�����û���ַ
		 
		this.address=address;
		
	}
	 
	public int getId () {//��ȡ�û�ID��
		
		return this.id;
	}
	
	public void setId (int id) {//�����û�ID��
		
		this.id=id;
		
	}
	
	public String toString() {
		return "���   " + id + "  ����  " + name + "      ����    " + age + "       �Ա�   " + sex + "       �绰����" + telNum
				+ "       סַ" + address + "\n\t";
	}

}

