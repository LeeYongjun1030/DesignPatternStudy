package iterator_pattern;

import java.util.Iterator;

public class PatternTest {

	public static void main(String[] args) {
		Iterator iterator;
		
		System.out.println("== 친구 전화번호부 ==");
		FriendsPhoneBook friends = new FriendsPhoneBook();
		iterator = friends.createIterator();
		
		while(iterator.hasNext()) {
			Phone phone = (Phone) iterator.next();
			String name = phone.getName();
			String number = phone.getNumber();
			
			System.out.println("이름은 "+name+", 번호는 "+number);
		}

		
		System.out.println("== 가족 전화번호부 ==");
		FamilyPhoneBook family = new FamilyPhoneBook();
		iterator = family.createIterator();
		
		while(iterator.hasNext()) {
			Phone phone = (Phone) iterator.next();
			String name = phone.getName();
			String number = phone.getNumber();
			
			System.out.println("이름은 "+name+", 번호는 "+number);
		}
		
		
	}

}
