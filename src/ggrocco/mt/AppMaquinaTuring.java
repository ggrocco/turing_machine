package ggrocco.mt;

public class AppMaquinaTuring {
	public static void main(String[] args) {
		
		TelaMaquina tela = new TelaMaquina();
		ControlTelaMaquina contro = new ControlTelaMaquina(tela);
		contro.inicarTela();
	}

}
