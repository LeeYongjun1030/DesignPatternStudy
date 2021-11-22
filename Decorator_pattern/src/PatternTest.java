import javax.print.attribute.standard.PrinterInfo;

public class PatternTest {

	public static void main(String[] args) {
		
		System.out.println("Atom verson1");
		Robot atom_v1 = new DefaultRobot();
		atom_v1.operate();
		
		System.out.println("\n\nAtom verson2");
		Robot atom_v2 = new Fly(new DefaultRobot());	
		atom_v2.operate();
		
		
		System.out.println("\n\nAtom verson3");
		Robot atom_v3 = new Attack(new Fly(new DefaultRobot()));
		atom_v3.operate();
		

	}

}
