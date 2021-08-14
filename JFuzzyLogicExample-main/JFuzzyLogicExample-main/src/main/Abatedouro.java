package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Abatedouro {

	public static void main(String[] args) {
		
		FIS fis = FIS.load("src/resource/abatedouroMandani.fcl", true); // MANDANI
		//FIS fis = FIS.load("src/resource/tipperSingleton.fcl", true); // USANDO SINGLETON
		//FIS fis = FIS.load("src/resource/tipperTS.fcl", true); // TAKAGI-SUGENO
			
		//APRESENTA AS VARIÃ�VEIS MODELADAS
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));
		
        //SETA AS ENTRADAS
	    fis.setVariable("pesoAnimal", 10);
	    fis.setVariable("alturaAnimal", 1.5);
	    
	    //AVALIA
	    fis.evaluate();

	    //MOSTRA O GRÃ�FICO DA VARIÃ�VEL DE SAÃ�DA
        Variable condicaoAbate = fis.getFunctionBlock("tipper").getVariable("condicaoAbate");
        JFuzzyChart.get().chart(condicaoAbate, condicaoAbate.getDefuzzifier(), true);

        //PRINTA VARIÃ�VEL DE SAÃ�DA    
        System.out.println(condicaoAbate.getValue());
        
        //MOSTRA CADA REGRA COM O VALOR DE ATIVAÃ‡ÃƒO
        for( Rule r : fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules() )
          System.out.println(r);
	}

}
