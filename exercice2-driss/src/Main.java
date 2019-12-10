import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) throws IOException {
		
		
		  
		  String st;
		  int somme=0;
		  int moyenne=0;
		  HashMap<String, String> map = new HashMap<>();
		  Instant start = Instant.now() ;

		try {
			BufferedReader br = new BufferedReader(new FileReader("fichier.txt"));
			while ((st = br.readLine()) != null) { 
				String[] ligne = st.split(":");
				map.put(ligne[0],ligne[1]);
			 } 
			
			for (String i : map.keySet()) {
				 System.out.println("email : " + i + " score : " + map.get(i));
				 somme=somme+Integer.parseInt(map.get(i));
			}
			
			System.out.println("La somme est :"+somme);
			moyenne= somme / map.size() ;
			System.out.println("La moyenne est :"+moyenne);
			BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("L'entre d'email a recherche :");
		    String email = entree.readLine();
		    String score =map.get(email);
		    System.out.println("le score de l'email "+email+" est :"+score);
		    
		    Duration duration = Duration.between(start, Instant.now()) ;
		    
		    System.out.println("la durée de cette opération est: "+duration.getSeconds()+" seconde");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
