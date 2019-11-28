package Aplicação;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesJogo.JogadaPossivel;
import EntidadesJogo.Partida;
import EntidadesJogo.Posicao;
import Enums.Cor;
import Exception.BoardException;
import Util.PosicaoDama;

public class Aplicacao {

	public static void main(String[] args) {
		Partida partida = new Partida();
		Scanner sc = new Scanner(System.in);
		List<JogadaPossivel> posicoes = new ArrayList();
		while(true) {
			try {
				IO.clearScreen();
				IO.printTabuleiro(partida.getTabuleiro().getPecas());
				System.out.println();
				System.out.println("Jogada da peça: "+ partida.getTabuleiro().getJogadaVez());
				System.out.print("Escolha a posição da peça: ");
				String posicaoDama = sc.next();
				sc.nextLine();
				Posicao posicaoOrigem = PosicaoDama.posicaoDamaToPosicao(posicaoDama);
				
				posicoes= partida.getTabuleiro().getPossibilidadesPeca(posicaoOrigem);	
				IO.clearScreen();
				IO.printTabuleiro(partida.getTabuleiro().getPecas(),posicoes);
				System.out.print("Escolha a posição destino da peça: ");
				posicaoDama = sc.next();
				sc.nextLine();
				Posicao posicaoDestino= PosicaoDama.posicaoDamaToPosicao(posicaoDama);
				partida.getTabuleiro().movePeca(posicaoOrigem, posicaoDestino,posicoes);
			}
			catch (BoardException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				sc.nextLine();			
				}
			
		}
	}

}
