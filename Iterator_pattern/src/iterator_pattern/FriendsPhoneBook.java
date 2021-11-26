package iterator_pattern;

import java.util.ArrayList;
import java.util.Iterator;

public class FriendsPhoneBook implements PhoneBook {
	
	ArrayList<Phone> phones; // ArrayList肺 硅凯阑 积己

	
	public FriendsPhoneBook() {
		phones = new ArrayList();
		
		phones.add(new Phone("模备1", "123"));
		phones.add(new Phone("模备2", "456"));
	}

	@Override
	public Iterator<Phone> createIterator() {
		return phones.iterator();
	}
	


}
