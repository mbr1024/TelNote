package cn.itcast;
import java.util.*;
public class TelNoteRegex {
	@SuppressWarnings("resource")
	public static int menuRegex(int min, int max) {
		int a = new Scanner(System.in).nextInt();
		if (a < min || a > max) {
			System.out.println("û�и�ѡ����������룺");
			a = new Scanner(System.in).nextInt();
		}
		return a;
	}

	// ��֤����
	public static String nameRegex(String name) {

		if (name.length() < 2 || name.length() > 10) {
			System.out.println("�������������ʽ����ȷ�����������룺");
			name = new Scanner(System.in).next();
			nameRegex(name);
		}

		return name;
	}

	// ��֤����
	public static int ageRegex(int age) {
		if (age < 0 ||age >= 130) {
			System.out.println("������������ʽ����ȷ�����������룺");
			age = new Scanner(System.in).nextInt();
			ageRegex(age);
		}
		return age;
	}

	// ��֤�Ա�
	public static String sexRegex(String sex) {
		if (sex.equals("m") == false && sex.equals("f") == false ) {
			if(sex.equals("M")==false && sex.equals("F")==false){
				System.out.println("��������Ա��ʽ����ȷ�����������룺");
			sex = new Scanner(System.in).next();
			sexRegex(sex);
			}
			
		}
		return sex;
	}

	// ��֤��ַ
	public static String addressRegex(String address) {
		if (address.length() < 3 || address.length() > 50) {
			System.out.println("������ĵ�ַ��ʽ����ȷ�����������룺");
			address = new Scanner(System.in).next();
			addressRegex(address);
		}
		return address;
	}

	// ��֤����
	public static String telNumRegex(String telNum) {
		if (telNum.length() != 6 && telNum.length() != 7 && telNum.length() != 8 && telNum.length() != 9 && telNum.length() != 10) {
			System.out.println("������ĺ����ʽ����ȷ�����������룺");
			telNum = new Scanner(System.in).next();
			telNumRegex(telNum);
		}

		return telNum;
	}
}
