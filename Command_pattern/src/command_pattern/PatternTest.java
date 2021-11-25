package command_pattern;

public class PatternTest {
	public static void main(String[] args) {
		
		RemoteControl remote = new RemoteControl();
		
		Command lightOnCommand = new LightOnCommand(new Light());
		remote.setCommand(lightOnCommand);
		remote.onButtonPushed();
		remote.offButtonPushed();
		
		Command televisionOnCommand = new TelevisionOnCommand(new Television());
		remote.setCommand(televisionOnCommand);
		remote.onButtonPushed();
		remote.offButtonPushed();
		
		Command televisionVolumeCommand = new TelevisionVolumeCommand(new Television());
		remote.setCommand(televisionVolumeCommand);
		remote.onButtonPushed();
		remote.offButtonPushed();
	}
}
