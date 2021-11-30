package proxy_pattern;

public class Proxy implements IService {
	
	IService iService;
	
	@Override
	public String runSomething() {
		iService = new Service();
		return iService.runSomething();
	}

}
