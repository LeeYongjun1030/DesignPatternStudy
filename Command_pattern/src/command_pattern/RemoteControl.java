package command_pattern;

public class RemoteControl {
	Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void onButtonPushed() {
		command.excute();
	}
	
	public void offButtonPushed() {
		command.undo();
	}
}
