package iterator_pattern;

import java.util.Iterator;

public class FamilyPhoneBook implements PhoneBook {
	
	private Phone[] phones; // 고정 배열을 생성
	
	public FamilyPhoneBook() {
		phones = new Phone[2];
		
		phones[0] = new Phone("엄마","111");
		phones[1] = new Phone("아빠","222");
	}

	@Override
	public Iterator<Phone> createIterator() {
		return new FamilyIterator(phones);
	}

}
