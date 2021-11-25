package adapter_pattern;

public class JapaneseAdapter implements Korean {

	Japanese japanese;
	
	public JapaneseAdapter(Japanese japanese) {
		this.japanese = japanese;
	}
	
	@Override
	public void helloInKorean() {
		japanese.helloInJapanese();
	}

	@Override
	public void goodbyeInKorean() {
		japanese.goodbyeInJapanese();
	}

}
