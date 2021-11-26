package iterator_pattern;

import java.util.ArrayList;
import java.util.Iterator;

public class FriendsPhoneBook implements PhoneBook {
	
	ArrayList<Phone> phones; // ArrayList�� �迭�� ����

	
	public FriendsPhoneBook() {
		phones = new ArrayList();
		
		phones.add(new Phone("ģ��1", "123"));
		phones.add(new Phone("ģ��2", "456"));
	}

	@Override
	public Iterator<Phone> createIterator() {
		return phones.iterator();
	}
	


}
