package command_pattern;

public class TelevisionOnCommand implements Command {
	
	Television tv;
	
	public TelevisionOnCommand(Television tv) {
		this.tv = tv;
	}
	
	@Override
	public void excute() {
		tv.on();
	}

	@Override
	public void undo() {
		tv.off();
	}

}
