/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionclient;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
        

/**
 *
 * @author FiercePC
 */
public class Client implements Serializable{
    protected String nom;
    protected String prenom;
    protected String dateNaiss;
    protected String phone;
    protected String mail;
    public ArrayList<Vente> listVente;
    
    public Client()  {
        Scanner lectureData = new Scanner(System.in);
        System.out.println("Nom du client: ");
        this.nom = lectureData.nextLine();
        System.out.println("Prénom du client: ");
        this.prenom = lectureData.nextLine();
        System.out.println("Date de naissance du client");
        this.dateNaiss = lectureData.nextLine();
        System.out.println("Numéro de téléphone du client");
        this.phone = lectureData.nextLine();
        System.out.println("Email du client");
        this.mail = lectureData.nextLine();
        this.listVente = new ArrayList<>();
    }
}
