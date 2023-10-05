package turing_machine;

import java.util.ArrayList;
import java.util.List;

public class State {
	List<Action> actions;

    public State() { actions = new ArrayList<>(); }

    public void addAction(Action newAction){
		actions.add(newAction);
	}
	
	public List<Action> getActions(){
		return actions;
	}
}