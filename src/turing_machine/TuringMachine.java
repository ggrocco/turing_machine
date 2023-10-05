package turing_machine;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TuringMachine extends Thread{
	private String[] language;
	private String input;
	private JTextArea output;
	private final List<turing_machine.State> states;
	private int position;
	private Tape tape;
	private boolean finalState = false;

	public TuringMachine(){
		states = new ArrayList<turing_machine.State>();
	}
	public void setInput(String input) {
		this.input = input;
	}
	public void setLanguage(String language) {
		this.language = language.split("\\n");
	}
	public void setOutput(JTextArea output){
		this.output = output;
	}
	public void setPosition(int position){
		this.position = position;
	}
	
	// To be able to be tested without the graphics part.
	private void printOutput(String text){
		if(output != null){
			output.setText(output.getText() + text);
		}else{
			System.out.print(text);
		}
	}
	
	public void setFinalState(){
		finalState = true;
	}
	
	@Override
	public void run() {
		int actualState = 0;
		int cycle = 0;
		
		finalState = false;
		tape = new Tape(input.toCharArray(), position);
		
		try{		
			buildLanguage();
		}catch (Exception e) {
			printOutput(e.getMessage());
			finalState = true;
		}
				
		while(!finalState){
			
			// Take the action of the cycle.
			for(Action action : states.get(actualState).getActions()){
				
				printOutput("\nCycle: "  +(++cycle) );
				
				try {
					sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				
				if(tape.read() == action.getRead()){
					String output = "State: " + ( actualState + 1 ) + " Type: " + tape.toString() + " - Action: " + action;
					printOutput("\n" +  output);
					
					if(action.getNewState() == -1){
						finalState = true;
						break;
					}else{
						actualState = action.getNewState() - 1;
					}
					// If what is already on the tape is the same as what you would record, don't waste time recording
					if(tape.read() != action.getWrite()){
						tape.write(action.getWrite());
					}
					
					if(action.getMovement() == '>'){
						tape.moveRight();
					}else{
						tape.moveLeft();
					}
					break;
				}					
			}
		}
	}
	
	private void buildLanguage() throws Exception{
		for(int i = 0; i< language.length; i++){
			if(language[i].matches("([1-9][0-9]|[0-9])\\,\\p{ASCII}\\,\\p{ASCII}\\,(\\<|\\>)\\,-?([1-9][0-9]|[0-9])")){
				String[] splits = language[i].split("\\,");
				Action action = new Action(splits[1].charAt(0), splits[2].charAt(0), splits[3].charAt(0), Integer.parseInt(splits[4]));
				
				int state = Integer.parseInt(splits[0]);
				while(states.size() < state){
					states.add(new turing_machine.State());
				}
				
				states.get(state - 1).addAction(action);
			}else{
				throw new Exception("Error na language -> " + language[i]);
			}			
		}
	}	
		
}
