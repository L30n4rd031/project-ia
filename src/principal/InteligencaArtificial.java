package principal;

import agente.AgenteLabirinto;
import ambiente.Labirinto;
import geral.PosicaoXY;
import java.util.Scanner; 

public class InteligencaArtificial {

	public static void main(String[] args) throws InterruptedException	 {

		Scanner sc = new Scanner(System.in);

		int tamAmbiente;
		int qtdAgentes;

		do {

			System.out.println("Tamanho do Ambiente (Int):");			
			tamAmbiente = sc.nextInt();

			System.out.println("Quantidade de Agentes (Int):");
			qtdAgentes = sc.nextInt();

			if(qtdAgentes > tamAmbiente || qtdAgentes == tamAmbiente) {
				System.out.println("O número de agentes deve ser menor que o tamanho do ambiente!");			
			}
			
		} while (qtdAgentes > tamAmbiente || qtdAgentes == tamAmbiente);


		Labirinto labirinto = new Labirinto(tamAmbiente);	
		labirinto.exibirLabirinto();

		AgenteLabirinto[] agentes = new AgenteLabirinto[qtdAgentes];

		for (int i = 0; i < agentes.length; i++) {			
			agentes[i] = new AgenteLabirinto();
			agentes[i].setNomeAgente("*A"+(1+i)+"*");
			agentes[i].setPosicao(new PosicaoXY((agentes.length - i) , (agentes.length - i)));
		}
				
		while(labirinto.isAgentesAindaLimpando(agentes)) {

			for (AgenteLabirinto agente : agentes) {
				agente.setLabirinto(labirinto);

				agente.zerarPilha();
				agente.movimentar(); 	
				
				labirinto.exibirLabirinto();
				Thread.sleep(1500);	
			}		

		}
			
		return;
	}

}
