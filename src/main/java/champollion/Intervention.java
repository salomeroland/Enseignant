/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champollion;

import java.util.Date;

/**
 *
 * @author salom
 */
public class Intervention {
    private Salle s; 
    private UE u; 
    private Enseignant e; 
    private Date debut; 
    private int duree; 
    private boolean annulee = false;  
    private int heureDebut ; 
    private TypeIntervention typeInter; 

    public Intervention(Date debut, int heureDebut, int duree, Salle s, TypeIntervention typeInter, Enseignant e, UE u) {
        this.s = s; 
        this.u = u; 
        this.e = e; 
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.typeInter = typeInter; 
    }
    public Intervention(Date debut, int duree, Salle s, TypeIntervention typeInter, Enseignant e, UE u) {
        this.s = s; 
        this.u = u; 
        this.e = e; 
        this.debut = debut;
        this.duree = duree;
        this.typeInter = typeInter; 
    
        
         
    }

    public Salle getS() {
        return s;
    }

    public UE getU() {
        return u;
    }

    public Enseignant getE() {
        return e;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    
    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public TypeIntervention getTypeInter() {
        return typeInter;
    }
    
    
    
}
