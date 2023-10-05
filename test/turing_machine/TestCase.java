package turing_machine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCase {
	@Test
	public void testMachine(){
		TuringMachine turingMachine = new TuringMachine();
		turingMachine.setInput("11111111");
		turingMachine.setLanguage("1,1,2,>,1\n1,B,B,<,2\n2,2,2,<,2\n2,B,B,>,-1");
		turingMachine.setPosition(0);
		turingMachine.run();
	}
	
	@Test
	public void testAction(){
		Action action = new Action('a', 'b', '>', -1);
		assertEquals(action.getRead(), 'a');
		assertEquals(action.getWrite(), 'b');
		assertEquals(action.getMovement(), '>');
		assertEquals(action.getNewState(), -1);

        assertEquals(action, action);
		assertEquals(action.toString(), "a,b,>,-1" );
	}

	@Test
	public void testType(){
		Tape tape = new Tape("abc".toCharArray(), 0);

		assertEquals(tape.read(), 'a');
		tape.write('b');
		assertEquals(tape.read(), 'b');
		
		tape.moveRight();
		assertEquals(tape.read(), 'b');
		tape.write('c');
		assertEquals(tape.read(), 'c');
		
		tape.moveRight();
		assertEquals(tape.read(), 'c');
		tape.write('a');
		assertEquals(tape.read(), 'a');

		tape.moveRight();
		assertEquals(tape.read(), 'B');
		tape.write('b');
		assertEquals(tape.read(), 'b');
		
		tape.moveRight();
		assertEquals(tape.read(), 'B');
		
		tape.moveLeft();
		assertEquals(tape.read(), 'b');
		tape.moveLeft();
		assertEquals(tape.read(), 'a');
		tape.moveLeft();
		assertEquals(tape.read(), 'c');
		tape.moveLeft();
		assertEquals(tape.read(), 'b');
		tape.moveLeft();
		assertEquals(tape.read(), 'B');
		tape.write('B');
		
		assertEquals(tape.toString(), "Bbcab");

		// expanding the tape.
		tape.moveLeft();
		tape.moveLeft();
		tape.moveLeft();
		assertEquals(tape.read(), 'B');
		tape.write('B');
		assertEquals(tape.toString(), "BBBBbcab");

		// expanding the tape.
		tape.moveRight();
		tape.moveRight();
		tape.moveRight();
		tape.moveRight();
		
		tape.moveRight();
		tape.moveRight();
		tape.moveRight();
		
		tape.moveRight();
		tape.moveRight();
		tape.moveRight();
		tape.moveRight();
		
		assertEquals(tape.read(), 'B');
		tape.write('B');
		assertEquals(tape.toString(), "BBBBbcabBBBB");
	}
}
