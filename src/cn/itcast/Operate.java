package cn.itcast;
import java.util.*;
import java.util.Scanner;

public class Operate {
	private Vector<Person> v=new Vector<Person>();
	static Menu m = new Menu();
	Scanner scanner = new Scanner(System.in);
	public void mainLogic(){
		m.mainMenu();
		int a = TelNoteRegex.menuRegex(1, 6);
		switch (a) {
		case 1:
			m.addMenu();//��Ӽ�¼   
			addLogic();
			break;
		case 2:
			m.searchMenu();//���Ҽ�¼ 
			searchLogic();
			break;
		case 3:
			m.modifyMenu();//�޸ļ�¼  
			modifyLogic();
			break;
		case 4:
			m.deleteMenu();//ɾ����¼
			deleteLogic();
			break;
		case 5:
			m.orderMenu();//�����¼
			orderLogic();
			break;
		case 6:
			break;
		}
	}

	public void addLogic() {
		
		int a = TelNoteRegex.menuRegex(1, 3);
		switch (a) {
		case 1:
			addOperation();//����¼�¼ 
			break;
		case 2:
			showAll();// �鿴ȫ��¼ 
			mainLogic();
			break;
		case 3:
			mainLogic();//������һ�� 
		}
	}

	public void searchLogic() {
		
		int a = TelNoteRegex.menuRegex(1, 7);
		switch (a) {
		case 1:
			searchByName();//����������   
			break;
		case 2:
			searchByAge();//���������  
			break;
		case 3:
			searchBySex();//���Ա����  
			break;
		case 4:
			searchByTelNum();//���������
			break;
		case 5:
			searchByAdd();//��סַ����   
			break;
		case 6:
			showAll();// �鿴ȫ��¼  
			m.searchMenu();
			searchLogic();
		    break;
		case 7:
			mainLogic();
			break;
		}
	}

	public void modifyLogic() {
		
		int a = TelNoteRegex.menuRegex(1, 3);
		switch (a) {
		case 1:
			showAll();//�鿴ȫ��¼  
			m.modifyMenu();//�޸ļ�¼  
			modifyLogic();
			break;
		case 2:
			modify();//�޸�ָ����¼ 
			modifyLogic();
			break;
		case 3:
			mainLogic();
			break;
		}
	}

	public void deleteLogic() {
		int a = TelNoteRegex.menuRegex(1, 4);
		switch (a) {
		case 1:
			showAll();// �鿴ȫ��¼ 
			m.deleteMenu();
			deleteLogic();
			break;
		case 2:
			delete();//ɾ��ָ����¼    
			m.deleteMenu();
			deleteLogic();
			break;
		case 3:
			deleteAll();// ɾ��ȫ����¼ 
			m.deleteMenu();
			deleteLogic();
			break;
		case 4:
			mainLogic();
			break;
		}
	}

	public void orderLogic() {
		while(true){
		int a = TelNoteRegex.menuRegex(1, 5);
		switch (a) {
		case 1:
			orderName();//����������   
			m.orderMenu();
			break;
		case 2:
			orderAge();//����������   
			m.orderMenu();
			break;
		case 3:
			orderSex();// ���Ա����� 
			m.orderMenu();
			break;
		case 4:
			showAll();//�鿴ȫ����¼
			m.orderMenu();
			break;
		case 5:
			mainLogic();//������һ�� 
			break;
		}
	}
}

public void addOperation() {
//	
//	
//	for (int i = 0; i < n; i++) {
		System.out.println("��������Ա��Ϣ��");
		System.out.println("����������1~10���ַ�");
		String name = scanner.next();
		name = TelNoteRegex.nameRegex(name);
		System.out.println("�������䣺1~100+");
		int age = scanner.nextInt();
		age = TelNoteRegex.ageRegex(age);
		System.out.println("�����Ա���m or M,Ů f or F");
		String sex = scanner.next();
		sex=TelNoteRegex.sexRegex(sex);
		System.out.println("������绰���룬6~11λ����");
		String telNum = scanner.next();
		telNum=TelNoteRegex.telNumRegex(telNum);
		System.out.println("�������ַ:(����3-50)");
		String address = scanner.next();
		address=TelNoteRegex.addressRegex(address);
		Person p1 = new Person();
		int id = v.size() + 1;
		p1.setId(id);
		p1.setName(name);
		p1.setAge(age);
		p1.setSex(sex);
		p1.setTelNum(telNum);
		p1.setAddress(address);
		v.add(p1);
		System.out.println("�洢�ɹ�");
//		if (i == n - 1) {
//			m.addMenu();
//			addLogic();
//		} 
//		else {
		System.out.println("�Ƿ�������룺1 �� 2 ��   �����룺");
		int n = TelNoteRegex.menuRegex(1,2);
		if(n==1)
			addOperation();
		else
			
		m.addMenu();//��Ӽ�¼   
		addLogic();
		}
//	}


// ��ѯȫ���û���Ϣ
public void showAll() {
	if(!v.isEmpty()) {
	Iterator<Person> it = v.iterator();
	
	while (it.hasNext()) {
		Object obj = it.next();
		System.out.println(obj.toString());
		}
	}
	else
		System.out.println("ͨѶ¼Ϊ�գ�");
}

// ��������ѯ�û���Ϣ
public void searchByName() {
	Iterator<Person> it = v.iterator();
	System.out.println("������Ҫ���ҵ����֣�");
	String name = scanner.next();
	name = TelNoteRegex.nameRegex(name);
	boolean a = false;
	while (it.hasNext()) {
		Person obj = it.next();
		if (obj.getName().equals(name)) {
			System.out.println(obj);
			a = true;
		}
	}
	if (a == false) {
		System.out.println("���޴�����!");
	}
	m.searchMenu();
	searchLogic();
}

// ���������ѯ�û���Ϣ
public void searchByAge() {
	Iterator<Person> it = v.iterator();
	System.out.println("������Ҫ���ҵ����䣺");
	int Age = scanner.nextInt();
	Age=TelNoteRegex.ageRegex(Age);
	boolean a = false;
	while (it.hasNext()) {
		Person obj = it.next();
		if (obj.getAge() == Age) {
			System.out.println(obj);
			a = true;
		}
	}
	if (a == false) {
		System.out.println("���޴�����!");
	}
	m.searchMenu();
	searchLogic();
}

// �����Ա��ѯ�û���Ϣ
public void searchBySex() {
	Iterator<Person> it = v.iterator();
	System.out.println("������Ҫ���ҵ��Ա�,�� m or M ��Ůf or F��");
	String sex = scanner.next();
	sex=TelNoteRegex.sexRegex(sex);
	boolean a = false;
	while (it.hasNext()) {
		Person obj = it.next();
		if (obj.getSex().equals(sex)) {
			System.out.println(obj);
			a = true;
		}
	}
	if (a == false) {
		System.out.println("���޴��Ա�!");
	}
	m.searchMenu();
	searchLogic();
}

// ���յ绰�����ѯ�û���Ϣ
public void searchByTelNum() {
	Iterator<Person> it = v.iterator();
	System.out.println("������Ҫ���ҵĵ绰���룺");
	String telNum = scanner.next();
	telNum=TelNoteRegex.telNumRegex(telNum);
	boolean a = false;
	while (it.hasNext()) {
		Person obj = it.next();
		if (obj.getTelNum().equals(telNum)) {
			System.out.println(obj);
			a = true;
		}
	}
	if (a == false) {
		System.out.println("���޴˵绰���룡");
	}
	m.searchMenu();
	searchLogic();
}

// ���յ�ַ��ѯ�û���Ϣ
public void searchByAdd() {
	Iterator<Person> it = v.iterator();
	System.out.println("������Ҫ���ҵĵ�ַ��");
	String address = scanner.next();
	address=TelNoteRegex.addressRegex(address);
	boolean a = false;
	while (it.hasNext()) {
		Person obj = it.next();
		if (obj.getAddress().equals(address)) {
			System.out.println(obj);
			a = true;
		}
	}
	if (a == false) {
		System.out.println("���޴�סַ!");
	}
	m.searchMenu();
	searchLogic();
}

// �޸�ָ����¼��Ϣ
public void modify() {
	System.out.println("������ָ���û���ID��");
	int id = scanner.nextInt();
	m.subModifyMenu();//�޸Ĳ˵�
	int a = TelNoteRegex.menuRegex(1, 6);
	while (a >= 1 && a <= 6) {
		if (a == 1) {
			System.out.println("������ĺ��������");
			String name = scanner.next();
			name = TelNoteRegex.nameRegex(name);
			v.get(id - 1).setName(name);
			System.out.println("�޸ĳɹ�!");
		}
		if (a == 2) {
			System.out.println("������ĺ�����䣺");
			int age = scanner.nextInt();
			age=TelNoteRegex.ageRegex(age);
			v.get(id - 1).setAge(age);
			System.out.println("�޸ĳɹ�!");
		}
		if (a == 3) {
			System.out.println("������ĺ���Ա�");
			String sex = scanner.next();
			sex=TelNoteRegex.sexRegex(sex);
			v.get(id - 1).setSex(sex);
			System.out.println("�޸ĳɹ�!");
		}
		if (a == 4) {
			System.out.println("������ĺ�ĵ绰���룺");
			String telNum = scanner.next();
			telNum=TelNoteRegex.telNumRegex(telNum);
			v.get(id - 1).setTelNum(telNum);
			System.out.println("�޸ĳɹ�!");
		}
		if (a == 5) {
			System.out.println("������ĺ�ĵ�ַ��");
			String address = scanner.next();
			address=TelNoteRegex.addressRegex(address);
			v.get(id - 1).setAddress(address);
			System.out.println("�޸ĳɹ�!");
		}
		if (a == 6) {
			m.modifyMenu();
			break;
		}
		System.out.println("�Ƿ�����޸ģ�1��,2��.");
		int b =TelNoteRegex.menuRegex(1, 2);
		if (b == 1) {
			m.subModifyMenu();
			a = TelNoteRegex.menuRegex(1, 6);
			continue;

		} else {
			m.modifyMenu ();
			modifyLogic();//�����޸�
		}
	}
}

// ɾ��ָ���û���Ϣ
public void delete() {
	System.out.println("����ɾ��id");
	int id = scanner.nextInt();
	v.remove(id - 1);
	System.out.println("ɾ���ɹ���");
	for(int i=id-1;i<v.size();i++){
		Person p=v.get(i);
		p.setId(p.getId()-1);
	}
}

// ɾ��ȫ���û���Ϣ
public void deleteAll() {
	v.removeAll(v);
	System.out.println("ȫ��ɾ���ɹ���");
}

// ���û�����������Ϣ
public void orderName() {
	Collections.sort(v, new NameComparator());
	System.out.println("����ɹ�");
}

// ���û�����������Ϣ
public void orderAge() {
	Collections.sort(v, new AgeComparator());
	System.out.println("����ɹ�");

}

// ���û��Ա�������Ϣ
public void orderSex() {
	Collections.sort(v, new SexComparator());
	System.out.println("����ɹ�");
	}

}

class NameComparator implements Comparator<Person> {
public int compare(Person p1, Person p2) {
	return p1.getName().compareTo(p2.getName());
	}
}

class AgeComparator implements Comparator<Person> {
public int compare(Person p1, Person p2) {
	return Integer.valueOf(p1.getAge()).compareTo(Integer.valueOf(p2.getAge()));
	}
}

class SexComparator implements Comparator<Person> {
public int compare(Person p1, Person p2) {
	return p1.getSex().compareTo(p2.getSex());
	}
}


