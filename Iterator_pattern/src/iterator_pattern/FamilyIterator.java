package iterator_pattern;

import java.util.Iterator;

public class FamilyIterator implements Iterator<Phone> {

	Phone[] list;
	int position = 0;
	
	public FamilyIterator(Phone[] list) {
		this.list = list; 
	}
	
	
	@Override
	public boolean hasNext() {
		return position < list.length;
	}

	@Override
	public Phone next() {
		Phone phone = list[position];
		position ++;
		return phone;
	}
	
}
