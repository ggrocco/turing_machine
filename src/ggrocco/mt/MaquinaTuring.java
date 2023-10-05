package ggrocco.mt;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;


public class MaquinaTuring extends Thread{
	
	private String[] linguagem;
	private String entrada;
	private JTextArea saida;
	private List<Estado> estados;
	private int posicao;
	private Fita fita;
	private boolean estadoFinal = false;
	
	
	public MaquinaTuring(){		
		estados = new ArrayList<Estado>();
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem.split("\\n");
	}
	public void setSaida(JTextArea saida){
		this.saida = saida;
	}
	
	public void setPosicao(int posicao){
		this.posicao = posicao;
	}
	
	// Para poder ser testada sem a parte grafica.
	private void printSaida(String texto){
		if(saida != null){
			saida.setText(saida.getText() + texto);
		}else{
			System.out.print(texto);
		}
	}
	
	public void parar(){
		estadoFinal = true;
	}
	
	@Override
	public void run() {
		int estadoAtual = 0;
		int ciclo = 0;
		
		estadoFinal = false;
		fita = new Fita(entrada.toCharArray(), posicao);
		
		try{		
			construirLinguagem();
		}catch (Exception e) {
			printSaida(e.getMessage());
			estadoFinal = true;
		}
				
		while(!estadoFinal){
			
			// Pega a açao do ciclo.			
			for(Acao acaoAtual : estados.get(estadoAtual).getAcoes()){
				
				printSaida("\nCiclo: "  +(++ciclo) );
				
				try {
					sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				
				if(fita.ler() == acaoAtual.getLer()){
					
					String outSaida = "Estado: "+ (estadoAtual + 1) + " Fita: " + fita.toString() + " - Ação: " + acaoAtual.toString();					
					printSaida("\n" +  outSaida);					
					
					if(acaoAtual.getNovoEstado() == -1){
						estadoFinal = true;
						break;
					}else{
						estadoAtual = acaoAtual.getNovoEstado() - 1;
					}
					// Se o que ja ta na fita é igual ao que iria gravar
					// não perde tempo gravando
					if(fita.ler() != acaoAtual.getGravar()){
						fita.gravar(acaoAtual.getGravar());
					}
					
					if(acaoAtual.getMovimento() == '>'){
						fita.moverDireita();
					}else{
						fita.moverEsquerda();
					}
					break;
				}					
			}
		}
	}
	
	private void construirLinguagem() throws Exception{
		for(int i = 0; i<linguagem.length; i++){
			if(linguagem[i].matches("([1-9][0-9]|[0-9])\\,\\p{ASCII}\\,\\p{ASCII}\\,(\\<|\\>)\\,-?([1-9][0-9]|[0-9])")){
				String[] splitacao = linguagem[i].split("\\,");
				Acao acao = new Acao(splitacao[1].charAt(0), splitacao[2].charAt(0), splitacao[3].charAt(0), Integer.parseInt(splitacao[4]));
				
				int estadoAgrava = Integer.parseInt(splitacao[0]);
				while(estados.size() < estadoAgrava){
					estados.add(new Estado());
				}
				
				estados.get(estadoAgrava - 1).addAcao(acao);
			}else{
				throw new Exception("Erro na linguagem -> " + linguagem[i]);
			}			
		}
	}	
		
}
