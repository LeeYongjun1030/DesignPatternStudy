package adapter_pattern;

public class PatternTest {

	public static void main(String[] args) {
		
		PersonInKorea kim = new PersonInKorea();
		kim.helloInKorean();
		kim.goodbyeInKorean();
		
		System.out.println("==�����⸦ �̿��Ͽ� ����==");
		Korean japaneseAdapter = new JapaneseAdapter(new PersonInJapan());
		japaneseAdapter.helloInKorean();
		japaneseAdapter.goodbyeInKorean();

	}

}
