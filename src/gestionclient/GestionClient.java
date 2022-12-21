/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionclient ;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;
  
/**
 *
 * @author FiercePC
 */
public class GestionClient implements Serializable {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       listeClient listClient = new listeClient(); 
       int choix;
       String nom, prenom, dateLivr;
       Double prix;
        //Recuperation du contenu du fichier de sauvegarde
       try {
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\FiercePC\\listeClient.dat"));
             
             Object object = ois.readObject();
        while (object != null) {
           listClient.ajoutClient((Client) object);
           object = ois.readObject();
           if (object != null) {
               ois.close();
               System.out.println("Le fichier de sauvegarde a bien été chargé.");
               System.out.println("");      
           }
        }       
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
         }
        
        
       //Affichage du menu principal
        do {
        Scanner lectureScanner = new Scanner(System.in);   
        System.out.println("Que voulez-vous faire? (indiquer le numéro correspondant)");
        System.out.println("1- Enregistrer un nouveau client ");
        System.out.println("2- Supprimer un client ");
        System.out.println("3- Consulter la liste et les informations des clients ");
        System.out.println("4- Consulter l'historique des ventes d'un client ");
        System.out.println("5- Enregistrer une vente ");
        System.out.println("6- Supprimer une vente ");
        System.out.println("7- Afficher la liste de toutes les ventes");
        System.out.println("8- Sortie de l'application ");
        System.out.println("Quel est votre choix?");
       
        if (lectureScanner.hasNextInt())  {
            choix = lectureScanner.nextInt();}
        else {
            choix=0;
        }
         
   
        switch(choix) {
            case 1:
                 
                listClient.ajoutClient();
                
                
                
                break;
            case 2: 
               lectureScanner.nextLine();
                System.out.println("Nom du client: ");
                nom = lectureScanner.nextLine();
                System.out.println("Prenom du client: ");
                prenom =lectureScanner.nextLine();
                listClient.supprClient(nom, prenom);
                break;
            case 3:
                listClient.affichListClient();
                break;
            case 4:
                lectureScanner.nextLine();
                 System.out.println("Nom du client: ");
                nom= lectureScanner.nextLine();
                System.out.println("Prenom du client: ");
                prenom =lectureScanner.nextLine();
                listClient.afficherLesVentes(nom, prenom);
                break;
            case 5:
                
                 lectureScanner.nextLine();
                System.out.println("Nom du client: ");
                nom = lectureScanner.nextLine();
                System.out.println("Prenom du client: ");
                prenom =lectureScanner.nextLine();
                System.out.println("Prix du gâteau: ");
                prix = lectureScanner.nextDouble();
                System.out.println("Date de livraison: ");
                dateLivr = lectureScanner.next();
                listClient.enregistrerVente(prix,dateLivr,nom,prenom);
                break;
            case 6:
                System.out.println("A quel client souhaitez-vous supprimer une vente?");
                lectureScanner.nextLine();
                System.out.println("Nom du client: ");
                nom = lectureScanner.nextLine();
                System.out.println("Prenom du client: ");
                prenom =lectureScanner.nextLine();
                listClient.venteSuppr(nom, prenom);
                   break;
            case 7:
               listClient.afficherToutesLesVentes();
                break;
            case 8: 
                listClient.enregistrement();
                System.out.println("Au revoir et à bientôt!");
                System.exit(0);
                break;
            
            default:
                System.out.println("Choix non valide, veuillez recommencer!");
                System.out.println();
                break;
               
        }
        
    } while(choix!=8);
    
   
}
    
     
}
