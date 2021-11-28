package composite_pattern;

import java.util.ArrayList;
import java.util.Iterator;

public class Folder implements Component {

	ArrayList<Component> folder;
	
	public Folder() {
		folder = new ArrayList<>();
	}
	
	public void add(Component component) {
		folder.add(component);
	}

	
	@Override
	public void getInfo() {
		for(Component component : folder) {
			component.getInfo();
		}
	}

}
