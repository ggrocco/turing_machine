package ggrocco.mt;

public class Fita{
	private int posicao;
	private char[] fita;
	
	public Fita(char[] fita, int posicao){
		this.fita = fita;
		this.posicao = posicao;
	}
	
	public char ler(){
		if(posicao < 0 || posicao > (fita.length-1)){
			return 'B'; 
		}
		return fita[posicao];
	}
	
	public void gravar(char info){
		// cria uma nova fita e copia se precisar.			
		criaFita();
			
		// grava o valor.
		fita[posicao] = info;			
	}
	
	public void moverEsquerda(){
		this.posicao--;
	}
	
	public void moverDireita(){
		this.posicao++;
	}
	
	private void criaFita(){
		char[] novaFita = null;
		
		if(posicao < 0){
			int inicio = (posicao * -1);
			novaFita = contruirFitaNova(inicio + fita.length);
			
			for(int i = inicio; i < novaFita.length; i++){
				novaFita[i] = fita[i - inicio];
			}
			
			posicao = 0;				
		}
		else if(posicao > fita.length -1){
			novaFita = contruirFitaNova(posicao + 1);
			for(int i = 0; i < fita.length; i++){
				novaFita[i] = fita[i];
			}
		}
		if(novaFita != null){
			this.fita = novaFita;
		}
	}
	
	private char[] contruirFitaNova(int tamanho){
		char[] novaFita = new char[tamanho];
		
		for(int i=0; i < novaFita.length; i++){
			novaFita[i] = 'B';
		}
		
		return novaFita;			
	}
	
	@Override
	public String toString() {
		String out = "";
		for(char letra : fita){
			out += letra + "";
		}
		return out;
	}
}
