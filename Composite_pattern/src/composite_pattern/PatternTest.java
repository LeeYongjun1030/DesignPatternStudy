package composite_pattern;

public class PatternTest {
	public static void main(String[] args) {
		Folder folder1 = new Folder();
		Folder folder2 = new Folder();
		
		File file1 = new File("picture.jpg", 5);
		File file2 = new File("video.avi", 100);
		File file3 = new File("music.mp3", 10);
		File file4 = new File("text.txt", 1);
		
		System.out.println("==Test1==");
		folder1.add(file1);
		folder1.add(file2);
		folder1.getInfo();
		
		System.out.println("==Test2==");
		folder2.add(file3);
		folder2.add(file4);
		folder2.getInfo();
		
		System.out.println("==Test3==");
		Folder folder3 = new Folder();
		folder3.add(folder1); // folder ∞¥√ºø° file¿Ã æ∆¥— folder ∞¥√º∏¶ add
		folder3.add(folder2);
		folder3.getInfo();
		
		
	
		
	}
}
