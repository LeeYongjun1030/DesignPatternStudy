package command_pattern;

public class TelevisionVolumeCommand implements Command {

	Television tv;
	
	public TelevisionVolumeCommand(Television tv) {
		this.tv = tv;
	}
	
	@Override
	public void excute() {
		tv.volumeUp();
	}

	@Override
	public void undo() {
		tv.volumeDown();
	}

}
