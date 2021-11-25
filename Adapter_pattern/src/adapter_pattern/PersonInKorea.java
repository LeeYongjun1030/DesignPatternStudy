package adapter_pattern;

public class PersonInKorea implements Korean {

	@Override
	public void helloInKorean() {
		System.out.println("안녕하세요! ");
	}

	@Override
	public void goodbyeInKorean() {
		System.out.println("안녕히계세요! ");
	}

}
