package adapter_pattern;

public class PersonInKorea implements Korean {

	@Override
	public void helloInKorean() {
		System.out.println("�ȳ��ϼ���! ");
	}

	@Override
	public void goodbyeInKorean() {
		System.out.println("�ȳ����輼��! ");
	}

}
