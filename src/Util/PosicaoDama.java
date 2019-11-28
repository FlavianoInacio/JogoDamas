package Util;

import EntidadesJogo.Posicao;

public class PosicaoDama {
	
	public static Posicao posicaoDamaToPosicao(String posicaoDama) {
		int coluna = posicaoDama.substring(0, 1).charAt(0) - 'a';
		int linha  = Integer.parseInt(posicaoDama.substring(1, 2));
		return new  Posicao(linha, coluna);
	}

}
