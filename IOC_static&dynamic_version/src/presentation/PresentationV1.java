package presentation;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {
     public static void main(String[] args) {
    	 //Version Static
    	 MetierImpl metier = new MetierImpl();
    	 //methode2 pas de setter mais via un constructeur
    	 //MetierImpl metier = new MetierImpl(dao);
    	 DaoImpl dao = new DaoImpl();
    	 metier.setDao(dao);
    	 System.out.println("Result = "+metier.calcul());
     }
}
