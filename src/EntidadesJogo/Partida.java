package EntidadesJogo;

import Enums.Cor;
import Enums.Sentido;

public class Partida {

	private int turno;
	private Tabuleiro tabuleiro;
	
	public Partida() {
		turno = 1;
		tabuleiro = new Tabuleiro(8, 8,Cor.BRANCO);
		initialSetup();
	}
	public void proximoTurno() {
		turno++;
	}
	
	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public void initialSetup() {
		for(int i =0;i<tabuleiro.getLinhas();i++) {
			for(int j=0;j<tabuleiro.getColunas();j++) {
				if(i<3) {
					if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
							tabuleiro.addPecaTabuleiro(new PecaPeao(tabuleiro, Cor.PRETO,Sentido.BAIXO), new Posicao(i, j));
					}
				}
				if(i>4) {
					if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
						tabuleiro.addPecaTabuleiro(new PecaPeao(tabuleiro, Cor.BRANCO,Sentido.CIMA), new Posicao(i, j));
				}
				}
			
			}
		}
	}
	
	
}
