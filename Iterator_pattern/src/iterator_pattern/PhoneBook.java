package iterator_pattern;

import java.util.Iterator;

public interface PhoneBook {
	public Iterator<Phone> createIterator();
}