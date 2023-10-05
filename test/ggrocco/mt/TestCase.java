package ggrocco.mt;

import static org.junit.Assert.*;

import org.junit.Test;
import ggrocco.mt.Acao;
import ggrocco.mt.Fita;
import ggrocco.mt.MaquinaTuring;

public class TestCase {
	public void testMaquinaT1(){
		MaquinaTuring maquina = new MaquinaTuring();
		maquina.setEntrada("11111111");
		maquina.setLinguagem("1,1,2,>,1\n1,B,B,<,2\n2,2,2,<,2\n2,B,B,>,-1");
		maquina.setPosicao(0);
		maquina.run();
	}
	
	@Test
	public void testAcao(){
		Acao acao = new Acao('a','b','>',-1);
		assertEquals(acao.getLer(), 'a');
		assertEquals(acao.getGravar(), 'b');
		assertEquals(acao.getMovimento(), '>');
		assertEquals(acao.getNovoEstado(), -1);
		

		assertTrue(acao.equals(acao));
		assertEquals(acao.toString(), "a,b,>,-1" );		
	}

	@Test
	public void testFita(){
		Fita fita = new Fita("abc".toCharArray(),0);
		
		
		assertEquals(fita.ler(), 'a');
		fita.gravar('b');
		assertEquals(fita.ler(), 'b');
		
		fita.moverDireita();
		assertEquals(fita.ler(), 'b');
		fita.gravar('c');
		assertEquals(fita.ler(), 'c');
		
		fita.moverDireita();
		assertEquals(fita.ler(), 'c');
		fita.gravar('a');
		assertEquals(fita.ler(), 'a');		

		fita.moverDireita();
		assertEquals(fita.ler(), 'B');
		fita.gravar('b');
		assertEquals(fita.ler(), 'b');
		
		fita.moverDireita();
		assertEquals(fita.ler(), 'B');
		
		fita.moverEsquerda();
		assertEquals(fita.ler(), 'b');
		fita.moverEsquerda();
		assertEquals(fita.ler(), 'a');
		fita.moverEsquerda();
		assertEquals(fita.ler(), 'c');
		fita.moverEsquerda();
		assertEquals(fita.ler(), 'b');
		fita.moverEsquerda();
		assertEquals(fita.ler(), 'B');
		fita.gravar('B');
		
		assertEquals(fita.toString(), "Bbcab");
		

		// expandindo a fita.
		fita.moverEsquerda();
		fita.moverEsquerda();
		fita.moverEsquerda();
		assertEquals(fita.ler(), 'B');
		fita.gravar('B');
		assertEquals(fita.toString(), "BBBBbcab");
		

		// expandindo a fita.
		fita.moverDireita();
		fita.moverDireita();
		fita.moverDireita();
		fita.moverDireita();
		
		fita.moverDireita();
		fita.moverDireita();
		fita.moverDireita();
		
		fita.moverDireita();		
		fita.moverDireita();
		fita.moverDireita();
		fita.moverDireita();
		
		assertEquals(fita.ler(), 'B');
		fita.gravar('B');
		assertEquals(fita.toString(), "BBBBbcabBBBB");
		
	}
}
