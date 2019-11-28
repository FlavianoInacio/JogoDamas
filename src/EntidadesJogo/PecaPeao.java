package EntidadesJogo;

import java.util.ArrayList;
import java.util.List;

import Enums.Cor;
import Enums.Sentido;

public class PecaPeao extends Peca{
	private Sentido sentido;

	public PecaPeao(Tabuleiro tabuleiro, Cor cor,Sentido sentido) {
		super(tabuleiro, cor);
		this.sentido = sentido;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<JogadaPossivel> verificarPosibilidadesJogadas(){
		List<JogadaPossivel> jogadasPossiveis = new ArrayList();
		List<Peca> pecas = new ArrayList<>();
		int linha;
		int coluna;
		Peca peca = null;
		boolean posicaoMarcada = false;
			linha = posicao.getLinha();
			coluna = posicao.getColuna();
			// Subindo Diagonal Principal
			while( (linha>0 && coluna>0) && !posicaoMarcada ) {
				linha--;
				coluna--;
				Posicao posicao = new Posicao(linha, coluna);
				if(!tabuleiro.verificaExistenciaPecaPosicao(posicao)) {
					if(sentido == Sentido.CIMA || peca!=null) {
						jogadasPossiveis.add(getJogadaPossivel(posicao,pecas));
					}
					if(tabuleiro.validarPosicaoTabuleiro(new Posicao(linha-1, coluna-1))) {
						if(!tabuleiro.verificaExistenciaPecaPosicao(new Posicao(linha-1, coluna-1)) || peca==null) {
							posicaoMarcada = true;
							peca = null;
						}
					}
					
				}
				else {
					peca = tabuleiro.getPeca(posicao);
					if(peca.getCor() == getCor()) {
						posicaoMarcada = true;
						peca = null;
					}
					pecas.add(peca);
				}
			}
			linha = posicao.getLinha();
			coluna = posicao.getColuna();
			posicaoMarcada = false;
			pecas = new ArrayList<>();
			// Subindo Diagonal Secundaria
			while( linha>0 && coluna<tabuleiro.getColunas()-1  && !posicaoMarcada) {
				linha--;
				coluna++;
				Posicao posicao = new Posicao(linha, coluna);
				if(!tabuleiro.verificaExistenciaPecaPosicao(posicao)) {
					if(sentido == Sentido.CIMA || peca!=null) {
						jogadasPossiveis.add(getJogadaPossivel(posicao,pecas));
					}
					
					if(tabuleiro.validarPosicaoTabuleiro(new Posicao(linha-1, coluna+1))) {
						if(!tabuleiro.verificaExistenciaPecaPosicao(new Posicao(linha-1, coluna+1)) || peca==null) {
							posicaoMarcada = true;
							peca = null;
						}
					}
				}
				else {
					peca = tabuleiro.getPeca(posicao);
					if(peca.getCor() == getCor()) {
						posicaoMarcada = true;
						peca = null;
					}
					pecas.add(peca);
				}
			}
			linha = posicao.getLinha();
			coluna = posicao.getColuna();
			posicaoMarcada = false;
			pecas = new ArrayList<>();
			// Descendo Diagonal Principal
			while( linha<tabuleiro.getLinhas()-1 && coluna<tabuleiro.getColunas()-1  && !posicaoMarcada) {
				linha++;
				coluna++;
				Posicao posicao = new Posicao(linha, coluna);
				if(!tabuleiro.verificaExistenciaPecaPosicao(posicao)) {
					if(sentido == Sentido.BAIXO || peca!=null) {
						jogadasPossiveis.add(getJogadaPossivel(posicao,pecas));
					}
					if(tabuleiro.validarPosicaoTabuleiro(new Posicao(linha+1, coluna+1))) {
						if(!tabuleiro.verificaExistenciaPecaPosicao(new Posicao(linha+1, coluna+1)) || peca==null) {
							posicaoMarcada = true;
							peca = null;
						}
					}
				}
				else {
					peca = tabuleiro.getPeca(posicao);
					if(peca.getCor() == getCor()) {
						posicaoMarcada = true;
						peca = null;
					}
					pecas.add(peca);
				}
			}
			linha = posicao.getLinha();
			coluna = posicao.getColuna();
			posicaoMarcada = false;
			pecas = new ArrayList<>();
			// Descendo Diagonal Principal
			while( linha<tabuleiro.getLinhas()-1 && coluna>0 && !posicaoMarcada ) {
				linha++;
				coluna--;
				Posicao posicao = new Posicao(linha, coluna);
				if(!tabuleiro.verificaExistenciaPecaPosicao(posicao)) {
					if(sentido == Sentido.BAIXO || peca!=null) {
					jogadasPossiveis.add(getJogadaPossivel(posicao,pecas));
					}
					if(tabuleiro.validarPosicaoTabuleiro(new Posicao(linha+1, coluna-1))) {
						if(!tabuleiro.verificaExistenciaPecaPosicao(new Posicao(linha+1, coluna-1)) || peca==null) {
							posicaoMarcada = true;
							peca = null;
						}
					}
				}
				else {
					peca = tabuleiro.getPeca(posicao);
					if(peca.getCor() == getCor()) {
						posicaoMarcada = true;
						peca = null;
					}
					pecas.add(peca);
				}
			}
		return jogadasPossiveis;
	}
	
	private JogadaPossivel getJogadaPossivel(Posicao posicao,List<Peca> pecas) {
		List<Peca> aux = new ArrayList();
		for (Peca peca : pecas) {
			aux.add(peca);
		}
		return new JogadaPossivel(posicao, aux);
	}

}
