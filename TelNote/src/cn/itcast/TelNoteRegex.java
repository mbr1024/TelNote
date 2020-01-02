package cn.itcast;
import java.util.*;
public class TelNoteRegex {
	@SuppressWarnings("resource")
	public static int menuRegex(int min, int max) {
		int a = new Scanner(System.in).nextInt();
		if (a < min || a > max) {
			System.out.println("没有该选项！请重新输入：");
			a = new Scanner(System.in).nextInt();
		}
		return a;
	}

	// 验证姓名
	public static String nameRegex(String name) {

		if (name.length() < 2 || name.length() > 10) {
			System.out.println("您输入的姓名格式不正确！请重新输入：");
			name = new Scanner(System.in).next();
			nameRegex(name);
		}

		return name;
	}

	// 验证年龄
	public static int ageRegex(int age) {
		if (age < 0 ||age >= 130) {
			System.out.println("您输入的年龄格式不正确！请重新输入：");
			age = new Scanner(System.in).nextInt();
			ageRegex(age);
		}
		return age;
	}

	// 验证性别
	public static String sexRegex(String sex) {
		if (sex.equals("m") == false && sex.equals("f") == false ) {
			if(sex.equals("M")==false && sex.equals("F")==false){
				System.out.println("您输入的性别格式不正确！请重新输入：");
			sex = new Scanner(System.in).next();
			sexRegex(sex);
			}
			
		}
		return sex;
	}

	// 验证地址
	public static String addressRegex(String address) {
		if (address.length() < 3 || address.length() > 50) {
			System.out.println("您输入的地址格式不正确！请重新输入：");
			address = new Scanner(System.in).next();
			addressRegex(address);
		}
		return address;
	}

	// 验证号码
	public static String telNumRegex(String telNum) {
		if (telNum.length() != 6 && telNum.length() != 7 && telNum.length() != 8 && telNum.length() != 9 && telNum.length() != 10) {
			System.out.println("您输入的号码格式不正确！请重新输入：");
			telNum = new Scanner(System.in).next();
			telNumRegex(telNum);
		}

		return telNum;
	}
}
