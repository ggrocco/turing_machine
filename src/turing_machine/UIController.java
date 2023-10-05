package turing_machine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UIController {

	private UI ui = null;
	private TuringMachine turingMachine = null;
	
	public UIController(UI ui){
		this.ui = ui;
		this.ui.addEventButtonStart(new StartMachine());
		this.ui.addEventButtonStop(new StopMachine());
	}
	
	public void setVisible(){
		this.ui.setVisible(true);
	}
	
	private class StartMachine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	ui.getAreaOutput().setText("");
        	turingMachine = new TuringMachine();
        	turingMachine.setLanguage(ui.getAreaLanguage().getText());
        	turingMachine.setInput(ui.getInput().getText());
        	turingMachine.setOutput(ui.getAreaOutput());
        	int position = 0;
        	try{
        		position = Integer.parseInt(ui.getPosition().getText());
        	}catch(Exception err){
        		 
        	}
        	turingMachine.setPosition(position);
        	turingMachine.start();
        }
	}
	
	private class StopMachine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(turingMachine != null){
        		turingMachine.setFinalState();
        	}
        }
	}
}
