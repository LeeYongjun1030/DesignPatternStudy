package iterator_pattern;

import java.util.Iterator;

public class PatternTest {

	public static void main(String[] args) {
		Iterator iterator;
		
		System.out.println("== ģ�� ��ȭ��ȣ�� ==");
		FriendsPhoneBook friends = new FriendsPhoneBook();
		iterator = friends.createIterator();
		
		while(iterator.hasNext()) {
			Phone phone = (Phone) iterator.next();
			String name = phone.getName();
			String number = phone.getNumber();
			
			System.out.println("�̸��� "+name+", ��ȣ�� "+number);
		}

		
		System.out.println("== ���� ��ȭ��ȣ�� ==");
		FamilyPhoneBook family = new FamilyPhoneBook();
		iterator = family.createIterator();
		
		while(iterator.hasNext()) {
			Phone phone = (Phone) iterator.next();
			String name = phone.getName();
			String number = phone.getNumber();
			
			System.out.println("�̸��� "+name+", ��ȣ�� "+number);
		}
		
		
	}

}
