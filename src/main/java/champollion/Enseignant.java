package champollion;

import java.util.ArrayList;
import java.util.Date;

public class Enseignant extends Personne {
 
     
    

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
       
        
    }

    
    
    ArrayList<ServicePrevu> serviceprevu = new ArrayList<>();
    ArrayList<Intervention> lesInterventions = new ArrayList<>(); 

    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
    }

    
    
    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        int equivalentTD = 0; 
        for (ServicePrevu servicep : serviceprevu){
            equivalentTD += 1.5 * servicep.getVolumeCM(); 
            equivalentTD += servicep.getVolumeTD(); 
            equivalentTD += 0.75 * servicep.getVolumeTP(); 
        }
        return equivalentTD ; 
    }
    
    public boolean enSouService(){
        return(this.heuresPrevues() < 192); 
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        int equivalentTD_UE = 0; 
        for (ServicePrevu servicepUe : serviceprevu){
            if (servicepUe.getUe().equals(ue)){
                equivalentTD_UE += 1.5 * servicepUe.getVolumeCM(); 
                equivalentTD_UE +=  servicepUe.getVolumeTD();
                equivalentTD_UE += 0.75 * servicepUe.getVolumeTP();
            }
        }
        return equivalentTD_UE; 
        
   
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouterEnseignement( UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
      ServicePrevu sp = new ServicePrevu(ue, volumeCM, volumeTD, volumeTP, this);
      serviceprevu.add(sp); 
    }
    
    public void ajouterIntervention (Intervention inter){
        
       lesInterventions.add(inter); 
    }
    
    public int resteAPlanifier(UE ue, TypeIntervention type){
   
        int nb_heure_ue = 0; 
        int nb_heure_planifiee = 0; 
        for(ServicePrevu sp : serviceprevu){
            
                switch (type){
                    case CM : 
                        nb_heure_ue = sp.getVolumeCM(); 
                    case TD : 
                        nb_heure_ue = sp.getVolumeTD();  
                    case TP : 
                        nb_heure_ue = sp.getVolumeTP(); 
                    default: 
                        break;
                }
        
        }
        for(Intervention i : lesInterventions){
            if(i.getU().equals(ue) && i.getTypeInter() == type){
                nb_heure_planifiee = nb_heure_planifiee + i.getDuree(); 
            }
        }
        return nb_heure_ue - nb_heure_planifiee; 
    }
    
    

}
