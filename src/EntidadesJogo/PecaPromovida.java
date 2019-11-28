package EntidadesJogo;

import java.util.ArrayList;
import java.util.List;

import Enums.Cor;

public class PecaPromovida extends Peca{

	public PecaPromovida(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<JogadaPossivel> verificarPosibilidadesJogadas() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	/*public List<Posicao> verificarPosibilidadesJogadas(){
		
		List<Posicao> posicoes = new ArrayList();
		int linha;
		int coluna;
		
		linha = posicao.getLinha();
		coluna = posicao.getColuna();
		// Subindo Diagonal Principal
		while( linha>0 && coluna>0 ) {
			linha--;
			coluna--;
			posicoes.add(new Posicao(linha, coluna));
			
		}	
		linha = posicao.getLinha();
		coluna = posicao.getColuna();
		// Descendo Diagonal Principal
		while( linha<tabuleiro.getLinhas()-1 && coluna<tabuleiro.getColunas()-1 ) {
			linha++;
			coluna++;
			posicoes.add(new Posicao(linha, coluna));
			
		}
		
		linha = posicao.getLinha();
		coluna = posicao.getColuna();
		// Subindo Diagonal Secundaria
		while( linha>0 && coluna<tabuleiro.getColunas()-1 ) {
			linha--;
			coluna++;
			posicoes.add(new Posicao(linha, coluna));
			
		}
		linha = posicao.getLinha();
		coluna = posicao.getColuna();
		// Descendo Diagonal Principal
		
		while( linha<tabuleiro.getLinhas()-1 && coluna>0 ) {
			linha++;
			coluna--;
			posicoes.add(new Posicao(linha, coluna));
			
		}
		return posicoes;
	}*/

}
