import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {
	static JFrame ihm=new JFrame();
	static String interet;
	static String age;
	static String editeur;
	static String pegi;
	static String objectifjeu;
	static Fait objectif;
	
    public static void main(String[] args) {
    	interet="";
    	editeur="";
    	pegi="";
    	age="1";
    	objectifjeu=" ";
    	
        String fichier = "regles.txt";
        final ArrayList<Fait> base_de_faits = new ArrayList<>();
        ArrayList<Regle> base_de_regles = BasedeRegles.Initialisation(fichier);

       /* System.out.println("Entrez votre age : ");
        Scanner scan1 = new Scanner(System.in);
        String age = scan1.next();

        base_de_faits.add(new Fait("age",age,"="));
        base_de_faits.add(new Fait("editeur","konami","="));
        base_de_faits.add(new Fait("interet","peur","="));
        base_de_faits.add(new Fait("pegi","18","="));*/





        /*System.out.println("Entrez le nom d'un fichier (Si il ne se trouve pas à la racine, entrez son adresse relative ou absolue");
        Scanner scan1 = new Scanner(System.in);
        fichier = scan1.next();*/



        final Moteur m = new Moteur(base_de_regles,base_de_faits);

        System.out.println("Exploration en chainage avant ou arriere ? ");
        System.out.println("1: Chainage avant");
        System.out.println("2: Chaine arrière");
        
        
        ihm.setTitle("Systeme Expert");
		ihm.setLocation(0,0);
		ihm.setSize(1000,100);
		GridLayout grid=new GridLayout();
		JPanel gridpan=new JPanel();
		grid.setColumns(1);
		grid.setRows(2);
		gridpan.setLayout(grid);
		GridLayout grid2=new GridLayout();
		grid2.setColumns(6);
		grid2.setRows(2);
		JPanel grid2pan=new JPanel();
		grid2pan.setLayout(grid2);
		
		JTextArea tage=new JTextArea ("Age :");
		JTextArea tediteur=new JTextArea ("Editeur :");
		JTextArea tinteret=new JTextArea ("Interet :");
		JTextArea tpegi=new JTextArea ("Pegi :");
		JTextArea tobjectif= new JTextArea("Objectif :");
		JTextArea tav=new JTextArea ("");
		JTextArea tarr=new JTextArea ("");
		String[] ages = { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18+"}; 
		final JComboBox<String> jComboAge = new JComboBox<String>(ages);
		jComboAge.setSelectedIndex(0);
		jComboAge.setVisible(true);
		
		
		String[] editeurs = { "","capcom","konami","nintendo","square enix"}; 
		final JComboBox<String> jComboEdit = new JComboBox<String>(editeurs);
		jComboEdit.setSelectedIndex(0);
		jComboEdit.setVisible(true);
		
		String[] interets = { "","angoisse","challenge","peur"}; 
		final JComboBox<String> jComboInteret = new JComboBox<String>(interets);
		jComboInteret.setSelectedIndex(0);
		jComboInteret.setVisible(true);
		
		String[] pegis = { "","3","7","12","16","18"}; 
		final JComboBox<String> jComboPegi = new JComboBox<String>(pegis);
		jComboPegi.setSelectedIndex(0);
		jComboPegi.setVisible(true);


		ArrayList<String> jeux= new ArrayList<>();
		jeux.add("");
		for (Regle r : base_de_regles){
		    if(r.get_conclusion().get_attribut().equalsIgnoreCase("jeu") && !jeux.contains(r.get_conclusion().get_valeur())){
		        jeux.add(r.get_conclusion().get_valeur());
            }
        }
        String[] jeuxbox = jeux.toArray(new String[jeux.size()]);
        final JComboBox<String> jComboObjectif = new JComboBox<String>(jeuxbox);
        jComboObjectif.setSelectedIndex(0);
        jComboObjectif.setVisible(true);

		
		JButton chAv=new JButton("Chainage Avant");
		JButton chAr=new JButton("Chainage Arrière");
		
		final JTextArea Affresult=new JTextArea("");
		
		jComboAge.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				age=(String) jComboAge.getSelectedItem();
			}
			
		});
		jComboEdit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				editeur=(String) jComboEdit.getSelectedItem();
			}
			
		});
		jComboInteret.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				interet=(String) jComboInteret.getSelectedItem();
			}
			
		});
		jComboPegi.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pegi=(String) jComboPegi.getSelectedItem();
			}
			
		});
		jComboObjectif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectifjeu = (String) jComboObjectif.getSelectedItem();
                System.out.println(objectifjeu);

            }
        });
		chAv.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				objectif = new Fait("jeu",objectifjeu,"=");
				base_de_faits.add(new Fait("age",age,"="));
				if (editeur!=""&& !base_de_faits.contains(new Fait("editeur",editeur,"=")))base_de_faits.add(new Fait("editeur",editeur,"="));
				if (interet!=""&& !base_de_faits.contains(new Fait("interet",interet,"=")))base_de_faits.add(new Fait("interet",interet,"="));
				if (pegi!=""&& !base_de_faits.contains(new Fait("pegi",pegi,"=")))base_de_faits.add(new Fait("pegi",pegi,"="));

				Affresult.setText("Objectif : "+objectif.toString()+"\nRésultat : "+m.chainageAvant(objectif));
			}
			
		});
		chAr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				objectif = new Fait("jeu",objectifjeu,"=");
				base_de_faits.add(new Fait("age",age,"="));
				if (editeur!="")base_de_faits.add(new Fait("editeur",editeur,"="));
				if (interet!="")base_de_faits.add(new Fait("interet",interet,"="));
				if (pegi!="")base_de_faits.add(new Fait("pegi",pegi,"="));
				
				Affresult.setText("Objectif : "+objectif.toString()+"\nRésultat : "+m.chainageArriere(objectif));
			}
			
		});
		
		
		ihm.add(gridpan);
		gridpan.add(grid2pan);
		grid2pan.add(tage);
		grid2pan.add(tediteur);
		grid2pan.add(tinteret);
		grid2pan.add(tpegi);
		grid2pan.add(tobjectif);
		grid2pan.add(tav);
		grid2pan.add(tarr);
		grid2pan.add(jComboAge);
		grid2pan.add(jComboEdit);
		grid2pan.add(jComboInteret);
		grid2pan.add(jComboPegi);
		grid2pan.add(jComboObjectif);
		grid2pan.add(chAv);
		grid2pan.add(chAr);
		gridpan.add(Affresult);
		ihm.setVisible(true);
		
		
		
        /*Scanner scan = new Scanner(System.in);
        int reponse = scan.nextInt();
        System.out.println(reponse);
        scan.close();
        switch(reponse){
            case 1:
                System.out.println(m.chainageAvant(objectif));
                break;
            case 2:
                System.out.println(m.chainageArriere(objectif));
                break;
            case 3:
                break;
            default:
                System.out.println("Erreur");
                break;
        }*/



    }
}
