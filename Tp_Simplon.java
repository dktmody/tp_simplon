public class Tp_Simplon{
  /*
   La classe Terminal, regroupe les principales m?thodes de saisie et d?affichage
   au terminal pour les types pred?finis : int, double, boolean,
   char et String. Le fichier source Terminal.java, doit se trouver pr?sent dans le m?me r?pertoire que le tp.
   * 
   */
  
  // Fonction qui demande au User de saisir rang?e, si?ge et nombre de place.
  public static void remplirPlaceCinema ( boolean [][] placeCinema) {    
    int numRangee, numSiege, nombrePlace ;    
    String temp ;  
    do{
      do{
        System.out.println ( "saisissez le n? de la rang?e o? vous souhaitez r?server ! " );    
        System.out.println ( "Attention! le num?ro que vous devez saisir doit ?tre compris entre 1 - 8." );    
        numRangee = Terminal.lireInt (); 
      } while (numRangee <= 0 || numRangee >= 9);
      do{
        System.out.println ( "Selectionnez le si?ge o? vous souhaitez r?server ! " );    
        System.out.println ( "Attention! le num?ro que vous devez saisir doit ?tre compris entre 1 - 9." );    
        numSiege = Terminal.lireInt (); 
      } while (numSiege <= 0 || numSiege >= 10);
      do{
        System.out.println ( "Choissisez le nombre de place que vous souhaitez r?server ! " );    
        System.out.println ( "Attention! le nombre doit se faire selon la disponibilit? de la rang?e." );    
        nombrePlace = Terminal.lireInt (); 
      } while (nombrePlace <= 0 || nombrePlace > 10);    
      if (siegeDispo(placeCinema, numRangee, numSiege)  || 
          nombreSiegeDispo(placeCinema, numRangee, numSiege, nombrePlace)){
        if (nombrePlace ==1){
          placeCinema[numRangee -1][numSiege -1] = true;
        } else{
          placeCinema = remplirSieges(placeCinema, numRangee, numSiege, nombrePlace);
        }
      } 
      afficherPlace(placeCinema);
      System.out.println ( "Tapez sur la touche entrer si vous ne souhaitez plus r?server ! " );  
      System.out.println ( "Pour continuer ? r?server, il vous suffit de taper sur n'importe quelle lettre, puis sur entr?e! " );  
      temp = Terminal.lireString(); 
    }while (!temp.equals(""));
  }
  
  // Fonction qui indique si un si?ge est dispo ou pas.
  public static boolean siegeDispo(boolean[][] tab, int numRangee, int numSiege){
    if(!tab[numRangee-1][numSiege-1]){
      return true;
    }      
    return false;
  }
  
  // Cette fonction modifie le statut non-r?serv? ? r?serv? lorsqu'on choisi plusieurs si?ges.
  public static boolean[][] remplirSieges(boolean[][] tab, int numRangee, int numSiege, int nombreSiege){
    int numbreSiegeLineDispo = 0; 
     
    for(int i =0; i < tab[numRangee-1].length && nombreSiege >= 1; i++){
      if (!tab[numRangee-1][i]){
        tab[numRangee-1][i] = true;
        nombreSiege--;
        //numbreSiegeLineDispo +=1; 
      }
    } 
    for (int i = 0 ; i < tab[numRangee-1].length ; i++) {  
      if ( tab [numRangee-1] [i]){
        numbreSiegeLineDispo +=1;
      } 
    }
    if (numbreSiegeLineDispo >=9){
      System.out.println( "Il n'y a maintenant plus assez de si?ge sur la rang?e " );
    }
    return tab;
    //  }
  }
  
  // Fonction qui indique que la saisie d'user pour le nombre de si?ges peut ?tre effectu?, car il y'a assez de si?ge
  // sur la rang?e
  public static boolean nombreSiegeDispo(boolean[][] tab, int numRangee, int numSiege, int nombreSiege){
    int numbreSiegeLineDispo = 0; 
    for (int i = 0 ; i < tab.length ; i++) {  
      for(int j = 0; j < tab[i].length; j ++){   
        if ( !tab [i] [j]){
          numbreSiegeLineDispo +=1;
        } 
      }
    } 
    if (numbreSiegeLineDispo > 0 && numbreSiegeLineDispo >= nombreSiege){
      return true;     
    }
    else {
      return false;
    }
  }
  
  // simple fonction qui affiche le tableau
  public static void afficherPlace ( boolean [][] placeCinema ) {
    System.out.print ( "Les places du cin?ma sont les suivantes ! ") ;      
    System.out.println () ;
    System.out.println () ;    
    for (int i = 0 ; i < placeCinema.length ; i++) {
      System.out.print ("La rang?e ");  
      System.out.print (i + 1 + " "); 
      for(int j = 0; j < placeCinema[i].length; j ++){   
        if ( placeCinema [i] [j]){
          System.out.print ( "[ R?serv? ]");  
        } else {
          System.out.print ( "[ Non-r?serv? ]");  
        }
      }
      System.out.println () ;
    }    
    System.out.println () ;         
  }
  
  public static void main ( String [] args ) {    
    boolean [][] tableauPlaceCinema = new boolean [8] [9] ;  
    afficherPlace(tableauPlaceCinema);
    remplirPlaceCinema(tableauPlaceCinema);
  }  
}