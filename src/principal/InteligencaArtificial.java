package principal;

import agente.AgenteLabirinto;
import ambiente.Labirinto;
import geral.PosicaoXY;

public class InteligencaArtificial {

	public static void main(String[] args) throws InterruptedException	 {
		
		Labirinto labirinto = new Labirinto(4);	
		labirinto.exibirLabirinto();

		AgenteLabirinto[] agentes = new AgenteLabirinto[2];

		for (int i = 0; i < agentes.length; i++) {			
			agentes[i] = new AgenteLabirinto();
			agentes[i].setNomeAgente("*A"+(1+i)+"*");
			agentes[i].setPosicao(new PosicaoXY(i, i));
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
