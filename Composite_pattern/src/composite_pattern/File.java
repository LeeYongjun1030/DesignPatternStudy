package composite_pattern;

public class File implements Component {
	
	String name;
	int fileSize;
	
	public File(String name, int fileSize) {
		this.name = name;
		this.fileSize = fileSize;
	}
	
	
	@Override
	public void getInfo() {
		System.out.println("�̸� : "+ name + ", ���� ũ��� : "+ fileSize);
	}

}
