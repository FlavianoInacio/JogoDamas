package Aplicação;

import java.util.List;

import EntidadesJogo.JogadaPossivel;
import EntidadesJogo.Peca;
import EntidadesJogo.Posicao;
import Enums.Cor;

public class IO {
		public static int pecasBrancas=0;
		public static int pecasPretas=0;
		public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
		public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
		public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
		public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
		public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
		public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
		public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";
	 // Reset
	    public static final String RESET = "\033[0m";  // Text Reset
	    // Regular Colors
	    public static final String BLACK = "\033[0;30m";   // BLACK
	    public static final String RED = "\033[0;31m";     // RED
	    public static final String GREEN = "\033[0;32m";   // GREEN
	    public static final String YELLOW = "\033[0;33m";  // YELLOW
	    public static final String BLUE = "\033[0;34m";    // BLUE
	    public static final String PURPLE = "\033[0;35m";  // PURPLE
	    public static final String CYAN = "\033[0;36m";    // CYAN
	    public static final String WHITE = "\033[0;37m";   // WHITE
	    // Bold
	    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
	    public static final String RED_BOLD = "\033[1;31m";    // RED
	    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
	    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
	    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
	    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
	    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
	    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
	    // Underline
	    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
	    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
	    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
	    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
	    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
	    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
	    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
	    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
	    // Background
	    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
	    public static final String RED_BACKGROUND = "\033[41m";    // RED
	    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
	    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
	    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
	    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
	    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
	    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
	    // High Intensity
	    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
	    public static final String RED_BRIGHT = "\033[0;91m";    // RED
	    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
	    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
	    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
	    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
	    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
	    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE
	    // Bold High Intensity
	    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
	    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
	    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
	    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
	    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
	    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
	    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
	    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
	    // High Intensity backgrounds
	    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
	    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
	    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
	    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
	    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
	    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
	    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
	    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
	    
    public static void clearScreen() {
	    	System.out.print("\033[H\033[2J");
	    	System.out.flush();
	} 
	public static void printTabuleiro(Peca pecas[][]) {
		for(int i=0;i<pecas.length;i++) {
			System.out.print(WHITE+i+"  ");
			for(int j =0;j<pecas.length;j++) {
				printPeca(pecas[i][j],false);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(WHITE+"   A B C D E F G H");
		System.out.println();
		imprimirPlacar();
	}
	
	public static void printTabuleiro(Peca pecas[][],List<JogadaPossivel> possicoes) {
		for(int i=0;i<pecas.length;i++) {
			System.out.print(WHITE+i+"  ");
			for(int j =0;j<pecas.length;j++) {
				if(validaPosicao(possicoes,i,j)) {
					printPeca(pecas[i][j],true);
				}
				else {
					printPeca(pecas[i][j],false);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(WHITE+"   A B C D E F G H");
		System.out.println();
		imprimirPlacar();
	}
	private static void printPeca(Peca peca, boolean background) {
		if(background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if(peca == null) {
				System.out.print(ANSI_WHITE+"-"+ANSI_RESET);
		}
		else {
			if(peca.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_YELLOW+peca+ANSI_RESET);
				pecasBrancas++;
			}
			else {
				System.out.print(ANSI_RED+peca+ANSI_RESET);
				pecasPretas++;
			}
			
		}
	}
	private static boolean validaPosicao(List<JogadaPossivel> possicoes,int i,int j) {
		for (JogadaPossivel posicao : possicoes) {
			if(posicao.getPosicao().getLinha()==i && posicao.getPosicao().getColuna() ==j) {
				return true;
			}
		}
		return false;
	}
	public static void imprimirPlacar() {
		System.out.println(ANSI_RED+"Peças Pretas: "+pecasBrancas+ANSI_RESET);
		System.out.println(ANSI_YELLOW+"Peças Brancas: "+pecasPretas+ANSI_RESET);
		pecasBrancas=0;
		pecasPretas=0;
	}
}
