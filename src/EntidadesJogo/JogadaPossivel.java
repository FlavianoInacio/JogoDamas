package EntidadesJogo;

import java.util.ArrayList;
import java.util.List;

public class JogadaPossivel {
	private Posicao posicao;
	private Peca possivelPecaCapturada;
	private List<Peca> pecas = new ArrayList<>();
	
	public JogadaPossivel(Posicao posicao, List<Peca> pecas) {
		this.posicao = posicao;
		this.pecas = pecas;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Peca getPossivelPecaCapturada() {
		return possivelPecaCapturada;
	}

	public void setPossivelPecaCapturada(Peca possivelPecaCapturada) {
		this.possivelPecaCapturada = possivelPecaCapturada;
	}
	public void addPecas(Peca peca) {
		pecas.add(peca);
	}
	
	
}
