/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionclient;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.function.Predicate;
import java.util.Scanner;
/**
 *
 * @author FiercePC
 */
public class listeClient implements  Serializable{
    public LinkedHashSet<Client>listClient;
    
    public listeClient()  {
     listClient = new LinkedHashSet<>();
}
    
   
    
    
    public void affichListClient()  {
         for (Client C: listClient)  {
                    System.out.println(C.nom +" "+ C.prenom+" " + C.dateNaiss +" "+ C.phone+" " +C.mail );
                }
         System.out.println();
    }
    
     public void ajoutClient()  {
         listClient.add(new Client());
     }
     
     public void ajoutClient(Client C)  {
         listClient.add(C);
     }
     
     public void supprClient(String nom,String prenom)  {
   
       
         Predicate<Client> filter = C -> (C.nom.equalsIgnoreCase(nom) && C.prenom.equalsIgnoreCase(prenom));
            boolean value = listClient.removeIf(filter); 
            if(value) {
                System.out.println("Le client a été retiré de la liste");
                System.out.println("");
            }
            else {
                System.out.println("Ce client n'existe pas et n'a pu être retiré de la liste!");
                System.out.println("");
            }
         }
        
     
      public void enregistrerVente(Double prix, String dateLivr, String nom, String prenom)  {
          boolean noExistClient=true;
          for( Client C: listClient)   {
            
            if(C.nom.equalsIgnoreCase(nom) && C.prenom.equalsIgnoreCase(prenom))  {
                C.listVente.add(new Vente( prix, dateLivr));
                noExistClient=false;
            }
        }
          if(noExistClient)  {
              System.out.println("Ce client n'est pas encore enregistré, l'enregistrement de la vente a donc échoué!");
              System.out.println();
          }
          else  { 
              System.out.println("Votre transaction a bien été enregistrée!");
               System.out.println();
          }
          }
        
     public void afficherLesVentes(String nom, String prenom)  {
         boolean noExistClient= true;
         for( Client C: listClient)   {
            if(C.nom.equalsIgnoreCase(nom) && C.prenom.equalsIgnoreCase(prenom))  {
                System.out.println("Ventes à "+C.nom+" "+C.prenom+" :");
                for(Vente V: C.listVente)  {
                    System.out.println( V.prix +" "+ V.dateLivraison);
                    noExistClient= false;
                }
            }
            if(noExistClient)  {
              System.out.println("Ce client n'existe pas!");
              System.out.println();
          } 
            else System.out.println();
        }  
     }
     
     public void afficherToutesLesVentes()  {
        
            System.out.println("Liste de toutes les ventes enregistrées: ");
            System.out.println();
            for (Client C: listClient)  { 
                System.out.println(C.nom+" "+C.prenom);
                for(Vente V: C.listVente)  {
                    System.out.println( V.prix +" "+ V.dateLivraison);
                }
            }
            System.out.println();
     }
     
     public void venteSuppr(String nom,String prenom)  {
        
         boolean noExistClient= true;
         for( Client C: listClient)   {
            if(C.nom.equalsIgnoreCase(nom) && C.prenom.equalsIgnoreCase(prenom))  {
                System.out.println("Ventes à "+C.nom+" "+C.prenom+" :");
                noExistClient= false;
              int i= 0;
                for(Vente V: C.listVente)  {
                    System.out.println(i+ " - " + V.prix +" "+ V.dateLivraison);
                    i++;
                }
                 Scanner lectureScanner = new Scanner(System.in); 
                System.out.println("Quel est le numéro de la vente que vous souhaitez supprimer?");
               if (lectureScanner.hasNextInt())  {
                   int choix;
                   do {
                        choix = lectureScanner.nextInt();
                    } while(choix<0 || choix>C.listVente.size());
                    C.listVente.remove(choix);
                    System.out.println("La vente a bien été retiré de la liste");
               }
                else {
                   System.out.println("Vous n'avez pas entré un chiffre, veuillez recommencer!");
                   }
            }
            if(noExistClient)  {
              System.out.println("Ce client n'existe pas!");
              System.out.println();
          } 
            else  { 
                System.out.println();  
        }  
     
     }
     }
     
     
     public void enregistrement()  {
         try {
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\FiercePC\\listeClient.dat"));
             for (Client C: listClient)  {
                 oos.writeObject(C);
             }
             oos.close();
             System.out.println("La liste a bien été mise à jour!");
         } catch (FileNotFoundException e)  {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

   
}
