package ggrocco.mt;

import java.util.ArrayList;
import java.util.List;

public class Estado{
	List<Acao> acoes = new ArrayList<Acao>();
	
	public void addAcao(Acao nova){
		acoes.add(nova);
	}
	
	public List<Acao> getAcoes(){
		return acoes;
	}
}