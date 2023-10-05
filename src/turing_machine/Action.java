package turing_machine;

public class Action {
	int newState = 0;
	char read = 'B';
	char write = 'B';
	char movement = '>';

	public Action(char read, char write, char movement, int newState) {
		this.read = read;
		this.write = write;
		this.movement = movement;
		this.newState = newState;
	}

	@Override
	public String toString() {
		return read + "," + write + "," + movement + "," + newState;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + read;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Action other = (Action) obj;
		return read == other.read;
	}

	public char getWrite() {
		return write;
	}

	public char getRead() {
		return read;
	}

	public char getMovement() {
		return movement;
	}

	public int getNewState() {
		return newState;
	}
}
