package ggrocco.mt;

public class Acao {
	int novoEstado = 0;
	char ler = 'B';
	char gravar = 'B';
	char movimento = '>';

	public Acao(char ler, char gravar, char movimento, int novoEstado) {
		this.ler = ler;
		this.gravar = gravar;
		this.movimento = movimento;
		this.novoEstado = novoEstado;
	}

	@Override
	public String toString() {
		return ler + "," + gravar + "," + movimento + "," + novoEstado;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ler;
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
		final Acao other = (Acao) obj;
		return ler == other.ler;
	}

	public char getGravar() {
		return gravar;
	}

	public char getLer() {
		return ler;
	}

	public char getMovimento() {
		return movimento;
	}

	public int getNovoEstado() {
		return novoEstado;
	}
}
