package adapter_pattern;

public class PersonInJapan implements Japanese{

	@Override
	public void helloInJapanese() {
		System.out.println("Konnichiwa! ");
	}

	@Override
	public void goodbyeInJapanese() {
		System.out.println("Sayonara! ");
	}

}
