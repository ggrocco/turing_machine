package ggrocco.mt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlTelaMaquina {

	private TelaMaquina tela = null;
	private MaquinaTuring maquina = null;
	
	public ControlTelaMaquina(TelaMaquina tela){
		this.tela = tela;
		this.tela.addEventBotaoIniciar(new IniciarMaquina());
		this.tela.addEventBotaoParar(new PararMaquina());
	}
	
	public void inicarTela(){
		this.tela.setVisible(true);
	}
	
	private class IniciarMaquina implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	tela.getAreaSaida().setText("");
        	maquina = new MaquinaTuring();
        	maquina.setLinguagem(tela.getAreaLinguagem().getText());
        	maquina.setEntrada(tela.getEntrada().getText());
        	maquina.setSaida(tela.getAreaSaida());  
        	int posicao = 0;
        	try{
        		posicao = Integer.parseInt(tela.getPosicao().getText());
        	}catch(Exception err){
        		 
        	}
        	maquina.setPosicao(posicao);
        	maquina.start();			
        }
	}
	
	private class PararMaquina implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	if(maquina != null){
        		maquina.parar();
        	}
        }
	}
}
