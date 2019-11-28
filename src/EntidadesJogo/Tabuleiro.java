package EntidadesJogo;
import java.util.ArrayList;
import java.util.List;

import Enums.Cor;
import Exception.BoardException;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca pecas[][];
	private Cor jogadaVez;
	
	public Tabuleiro(int linhas, int colunas,Cor jogadaVez) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.pecas = new Peca[linhas][colunas];
		this.jogadaVez = jogadaVez;
	}
	
	public Cor getJogadaVez() {
		return jogadaVez;
	}

	public void setJogadaVez(Cor jogadaVez) {
		this.jogadaVez = jogadaVez;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public Peca[][] getPecas() {
		return pecas;
	}

	public void setPecas(Peca[][] pecas) {
		this.pecas = pecas;
	}
	public void addPecaTabuleiro(Peca peca, Posicao posicao) {
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.setPosicao(posicao);
	}
	public Peca getPeca(Posicao posicao) {
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public Peca removerPecaTabuleiro(Posicao posicao) {
		Peca aux;
		aux = pecas[posicao.getLinha()][posicao.getColuna()];
		aux.setPosicao(null);
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
	public void movePeca(Posicao posicaoOrigem, Posicao posicaoDestino,List<JogadaPossivel> jogadasPossiveis) {
		boolean posicaoTab = false;
		List<Peca> pecaCapturada = new ArrayList();
		if(verificaExistenciaPecaPosicao(posicaoDestino)) {
			throw new BoardException("Peça na Posição Destino");
		}
		if(!verificaExistenciaPecaPosicao(posicaoOrigem)) {
			throw new BoardException("Não existe peça na posição Origem");
		}
		for (JogadaPossivel jogadaPossivel : jogadasPossiveis) {
			if(jogadaPossivel.getPosicao().getLinha() == posicaoDestino.getLinha() &&  jogadaPossivel.getPosicao().getColuna() == posicaoDestino.getColuna()) {
				posicaoTab = true;
				pecaCapturada = jogadaPossivel.getPecas();
			}
		}
		if(!validarPosicaoTabuleiro(posicaoOrigem) || !validarPosicaoTabuleiro(posicaoDestino) || !posicaoTab) {
			throw new BoardException("Posição Inválida");
		}
		Peca peca = removerPecaTabuleiro(posicaoOrigem);
		addPecaTabuleiro(peca, posicaoDestino);
		for (Peca peca2 : pecaCapturada) {
			capturarPeca(peca2);
		}
		jogadaVez = nextJogada(jogadaVez);
	}
	public boolean validarPosicaoTabuleiro(Posicao posicao) {
		if( (posicao.getLinha()>=0 && posicao.getLinha()<8) && (posicao.getColuna()>=0 && posicao.getColuna()<8)  ) {
			return true;
		}
		else {
			return false;
		}
	}
	protected boolean verificaExistenciaPecaPosicao(Posicao posicao) {
		if(getPeca(posicao)!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	public List<JogadaPossivel> getPossibilidadesPeca(Posicao posicao){
		if(!verificaExistenciaPecaPosicao(posicao)) {
			throw new BoardException("Não existe peça na posição Origem");
		}
		Peca peca = getPeca(posicao);
		if(peca.getCor()!=jogadaVez) {
		//	throw new BoardException("Essa peça não corresponde a cor da jogada!");
		}
		return peca.verificarPosibilidadesJogadas();
	}
	public void capturarPeca(Peca peca) {
		if(peca!=null) {
			removerPecaTabuleiro(peca.posicao);
		}
		
	}
	public Cor nextJogada(Cor oponent) {
		return (oponent == Cor.BRANCO)?Cor.PRETO:Cor.BRANCO;
	}
}