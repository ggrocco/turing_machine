package turing_machine;

public class Tape {
	private int position;
	private char[] type;
	
	public Tape(char[] type, int position){
		this.type = type;
		this.position = position;
	}
	
	public char read(){
		if(position < 0 || position > ( type.length-1)){
			return 'B'; 
		}
		return type[position];
	}
	
	public void write(char info){
		// Create a new tape and copy if necessary.
		createType();
			
		// write value.
		type[position] = info;
	}
	
	public void moveLeft(){
		this.position--;
	}
	
	public void moveRight(){
		this.position++;
	}
	
	private void createType(){
		char[] newType = null;
		
		if(position < 0){
			int initial = ( position * -1);
			newType = buildNewType(initial + type.length);

			if (newType.length - initial >= 0)
				System.arraycopy(type, 0, newType, initial, newType.length - initial);
			
			position = 0;
		}
		else if(position > type.length -1){
			newType = buildNewType(position + 1);
			System.arraycopy(type, 0, newType, 0, type.length);
		}
		if(newType != null){
			this.type = newType;
		}
	}
	
	private char[] buildNewType(int size){
		char[] newType = new char[size];
		
		for(int i=0; i < newType.length; i++){
			newType[i] = 'B';
		}
		
		return newType;
	}
	
	@Override
	public String toString() {
		String out = "";
		for(char c : type){
			out += c + "";
		}
		return out;
	}
}
