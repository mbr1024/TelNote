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
			m.addMenu();//添加记录   
			addLogic();
			break;
		case 2:
			m.searchMenu();//查找记录 
			searchLogic();
			break;
		case 3:
			m.modifyMenu();//修改记录  
			modifyLogic();
			break;
		case 4:
			m.deleteMenu();//删除记录
			deleteLogic();
			break;
		case 5:
			m.orderMenu();//排序记录
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
			addOperation();//添加新记录 
			break;
		case 2:
			showAll();// 查看全记录 
			mainLogic();
			break;
		case 3:
			mainLogic();//返回上一级 
		}
	}

	public void searchLogic() {
		
		int a = TelNoteRegex.menuRegex(1, 7);
		switch (a) {
		case 1:
			searchByName();//按姓名查找   
			break;
		case 2:
			searchByAge();//按年龄查找  
			break;
		case 3:
			searchBySex();//按性别查找  
			break;
		case 4:
			searchByTelNum();//按号码查找
			break;
		case 5:
			searchByAdd();//按住址查找   
			break;
		case 6:
			showAll();// 查看全记录  
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
			showAll();//查看全记录  
			m.modifyMenu();//修改记录  
			modifyLogic();
			break;
		case 2:
			modify();//修改指定记录 
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
			showAll();// 查看全记录 
			m.deleteMenu();
			deleteLogic();
			break;
		case 2:
			delete();//删除指定记录    
			m.deleteMenu();
			deleteLogic();
			break;
		case 3:
			deleteAll();// 删除全部记录 
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
			orderName();//按姓名排序   
			m.orderMenu();
			break;
		case 2:
			orderAge();//按年龄排序   
			m.orderMenu();
			break;
		case 3:
			orderSex();// 按性别排序 
			m.orderMenu();
			break;
		case 4:
			showAll();//查看全部记录
			m.orderMenu();
			break;
		case 5:
			mainLogic();//返回上一级 
			break;
		}
	}
}

public void addOperation() {
//	
//	
//	for (int i = 0; i < n; i++) {
		System.out.println("请输入人员信息：");
		System.out.println("输入姓名：1~10个字符");
		String name = scanner.next();
		name = TelNoteRegex.nameRegex(name);
		System.out.println("输入年龄：1~100+");
		int age = scanner.nextInt();
		age = TelNoteRegex.ageRegex(age);
		System.out.println("输入性别，男m or M,女 f or F");
		String sex = scanner.next();
		sex=TelNoteRegex.sexRegex(sex);
		System.out.println("请输入电话号码，6~11位数字");
		String telNum = scanner.next();
		telNum=TelNoteRegex.telNumRegex(telNum);
		System.out.println("请输入地址:(长度3-50)");
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
		System.out.println("存储成功");
//		if (i == n - 1) {
//			m.addMenu();
//			addLogic();
//		} 
//		else {
		System.out.println("是否继续输入：1 是 2 否   请输入：");
		int n = TelNoteRegex.menuRegex(1,2);
		if(n==1)
			addOperation();
		else
			
		m.addMenu();//添加记录   
		addLogic();
		}
//	}


// 查询全部用户信息
public void showAll() {
	if(!v.isEmpty()) {
	Iterator<Person> it = v.iterator();
	
	while (it.hasNext()) {
		Object obj = it.next();
		System.out.println(obj.toString());
		}
	}
	else
		System.out.println("通讯录为空！");
}

// 按姓名查询用户信息
public void searchByName() {
	Iterator<Person> it = v.iterator();
	System.out.println("请输入要查找的名字：");
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
		System.out.println("查无此姓名!");
	}
	m.searchMenu();
	searchLogic();
}

// 按照年龄查询用户信息
public void searchByAge() {
	Iterator<Person> it = v.iterator();
	System.out.println("请输入要查找的年龄：");
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
		System.out.println("查无此年龄!");
	}
	m.searchMenu();
	searchLogic();
}

// 按照性别查询用户信息
public void searchBySex() {
	Iterator<Person> it = v.iterator();
	System.out.println("请输入要查找的性别,男 m or M ，女f or F：");
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
		System.out.println("查无此性别!");
	}
	m.searchMenu();
	searchLogic();
}

// 按照电话号码查询用户信息
public void searchByTelNum() {
	Iterator<Person> it = v.iterator();
	System.out.println("请输入要查找的电话号码：");
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
		System.out.println("查无此电话号码！");
	}
	m.searchMenu();
	searchLogic();
}

// 按照地址查询用户信息
public void searchByAdd() {
	Iterator<Person> it = v.iterator();
	System.out.println("请输入要查找的地址：");
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
		System.out.println("查无此住址!");
	}
	m.searchMenu();
	searchLogic();
}

// 修改指定记录信息
public void modify() {
	System.out.println("请输入指定用户的ID：");
	int id = scanner.nextInt();
	m.subModifyMenu();//修改菜单
	int a = TelNoteRegex.menuRegex(1, 6);
	while (a >= 1 && a <= 6) {
		if (a == 1) {
			System.out.println("请输入改后的姓名：");
			String name = scanner.next();
			name = TelNoteRegex.nameRegex(name);
			v.get(id - 1).setName(name);
			System.out.println("修改成功!");
		}
		if (a == 2) {
			System.out.println("请输入改后的年龄：");
			int age = scanner.nextInt();
			age=TelNoteRegex.ageRegex(age);
			v.get(id - 1).setAge(age);
			System.out.println("修改成功!");
		}
		if (a == 3) {
			System.out.println("请输入改后的性别：");
			String sex = scanner.next();
			sex=TelNoteRegex.sexRegex(sex);
			v.get(id - 1).setSex(sex);
			System.out.println("修改成功!");
		}
		if (a == 4) {
			System.out.println("请输入改后的电话号码：");
			String telNum = scanner.next();
			telNum=TelNoteRegex.telNumRegex(telNum);
			v.get(id - 1).setTelNum(telNum);
			System.out.println("修改成功!");
		}
		if (a == 5) {
			System.out.println("请输入改后的地址：");
			String address = scanner.next();
			address=TelNoteRegex.addressRegex(address);
			v.get(id - 1).setAddress(address);
			System.out.println("修改成功!");
		}
		if (a == 6) {
			m.modifyMenu();
			break;
		}
		System.out.println("是否继续修改：1是,2否.");
		int b =TelNoteRegex.menuRegex(1, 2);
		if (b == 1) {
			m.subModifyMenu();
			a = TelNoteRegex.menuRegex(1, 6);
			continue;

		} else {
			m.modifyMenu ();
			modifyLogic();//结束修改
		}
	}
}

// 删除指定用户信息
public void delete() {
	System.out.println("输入删除id");
	int id = scanner.nextInt();
	v.remove(id - 1);
	System.out.println("删除成功！");
	for(int i=id-1;i<v.size();i++){
		Person p=v.get(i);
		p.setId(p.getId()-1);
	}
}

// 删除全部用户信息
public void deleteAll() {
	v.removeAll(v);
	System.out.println("全部删除成功！");
}

// 按用户姓名排序信息
public void orderName() {
	Collections.sort(v, new NameComparator());
	System.out.println("排序成功");
}

// 按用户年龄排序信息
public void orderAge() {
	Collections.sort(v, new AgeComparator());
	System.out.println("排序成功");

}

// 按用户性别排序信息
public void orderSex() {
	Collections.sort(v, new SexComparator());
	System.out.println("排序成功");
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


