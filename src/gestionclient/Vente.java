/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionclient;

import java.io.Serializable;

/**
 *
 * @author FiercePC
 */
public class Vente implements Serializable{
    protected double prix;
    protected String dateLivraison;
    
    public Vente(double prix, String dateLivr)  {
        this.prix= prix;
        this.dateLivraison= dateLivr;
    }
    
   
}
