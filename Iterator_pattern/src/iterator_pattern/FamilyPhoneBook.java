package iterator_pattern;

import java.util.Iterator;

public class FamilyPhoneBook implements PhoneBook {
	
	private Phone[] phones; // ���� �迭�� ����
	
	public FamilyPhoneBook() {
		phones = new Phone[2];
		
		phones[0] = new Phone("����","111");
		phones[1] = new Phone("�ƺ�","222");
	}

	@Override
	public Iterator<Phone> createIterator() {
		return new FamilyIterator(phones);
	}

}
