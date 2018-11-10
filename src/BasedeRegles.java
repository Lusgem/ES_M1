import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasedeRegles {

    public static ArrayList<Regle> Initialisation(String nomFichier){
        ArrayList<Regle> base_de_regles = new ArrayList<>();
        Pattern p = Pattern.compile("([a-zA-Z0-9_]+)(<|>|=|>=|<=)([a-zA-Z0-9_]+)"); //Expression régulière permettant de reconnaitre un fait
        try {
            InputStream ips = new FileInputStream(nomFichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String line;

            while((line=br.readLine())!=null){
                Regle r = new Regle();
                String []parts = line.split("THEN");
                if (parts.length>1) {
                    String conditions = parts[0];
                    String conclusion = parts[1];
                    conditions = conditions.split("IF ")[1];
                    String []condition = conditions.split("AND");
                    for(String cdt : condition){
                        Fait tempCondition = new Fait();

                        Matcher match = p.matcher(cdt);
                        if(match.find()){
                            tempCondition.set_attribut(match.group(1));
                            tempCondition.set_operateur(match.group(2));
                            tempCondition.set_valeur(match.group(3));
                            r.ajoutCondition(tempCondition);
                        }

                    }
                    Fait tempConclusion = new Fait();
                    Matcher match = p.matcher(conclusion);
                    if(match.find()){
                        tempConclusion.set_attribut(match.group(1));
                        tempConclusion.set_operateur(match.group(2));
                        tempConclusion.set_valeur(match.group(3));
                        r.set_conclusion(tempConclusion);
                        //System.out.println(tempConclusion.toString());
                    }
                    System.out.println(r.toString());
                    base_de_regles.add(r);
                }
            }
            br.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return base_de_regles;
    }
}
