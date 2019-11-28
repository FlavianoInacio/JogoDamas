package EntidadesJogo;

import java.util.ArrayList;
import java.util.List;

import Enums.Cor;

public abstract class Peca {
	protected Posicao posicao;
	protected Tabuleiro tabuleiro;
	private Cor cor;
	
	public Peca(Tabuleiro tabuleiro, Cor cor) {
		this.posicao = null;
		this.tabuleiro = tabuleiro;
		this.cor = cor;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	public abstract List<JogadaPossivel> verificarPosibilidadesJogadas();
	@Override
	public String toString() {
		if(cor == Cor.BRANCO) {
			return "B";
		}
		else {
			return "P";
		}
	}
	
	
	
}
