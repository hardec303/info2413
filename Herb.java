// Updated
// This code is for herb searching, and adding, deleting, and modifying the herb.
// Bug, searching for a herb after deleting a herb causes error. (FIXED)

import java.util.*;
public class Herb
{
        public static void main(String[] args) 
        {
                    String[] herbName={"Chamomile","Echinacea","Feverfew","Ginger","Ginkgo","Saint John's Wort","Valerian"};
                    String[] herbDescrip={"Ananxiolytic and sedative.","Dietary supplement.","Dietary supplement.","Used as a spice and a folk medicine.","Improves blood circulation and acts as an antioxidant.","A flowering plant popular for depression.","A floweing plant popular for relaxation."};
                    String[] medicalUse={"For anxiety and relaxation.","For common cold and other infections.","For migraine, headache prevention, problems with menstruation, rheumatoid arthritis, psoriasis, allergies, asthma, tinnitus (ringing or roaring sounds in the ears), dizziness, nausea, vomiting, and for intestinal parasites.","For motion sickness, morning sickness, colic, upset stomach, gas, diarrhea, irritable bowel syndrome (IBS), and nausea.","For altitude sickness, cerebral vascular insufficiency, cognitive disorders, dementia, dizziness/vertigo","For depression and symptoms that sometimes go along with mood such as nervousness, tiredness, poor appetite, and trouble sleeping.","For sleep disorders, especially insomnia."};
            
                    String[] symptom={"Anxiety","Infections","Headaches","Heartburn, Diarrhea, Burping","Dementia, Alzheimer's, Fatigue","Depression","Insomnia, Anxiety"};
                    System.out.println("List of herbs:");
        
                    for(int i=0;i<herbName.length;i++)
                    {
                                System.out.println(herbName[i]);
                    }
        
                    boolean bCont=true;
               
                    System.out.println("~~~~~~");
                    
                    while  (bCont)
                    {
                                System.out.println("Please choose an operation: (case-sensitive) \n 1) Type 'Add' to add a new herb. \n 2) Type 'Modify' to modify an existing herb. \n 3) Type 'Delete' to delete an existing herb. \n 4) Type 'End' to exit. \n 5) Type 'Search' to advanced search a herb, and learn more about it.");
                                Scanner s=new Scanner(System.in);
                                String input=s.nextLine();
                                
                                switch(input)
                                {
                                            case "Search":
                                            System.out.println("Please enter either a: HERB NAME, HERB DESCRIPTION, MEDICAL USE, or SYMPTOM:");

                                            String SearchInput=s.nextLine();
                                            System.out.println("\nResults:");

                                            boolean found=false;
                                            
                                            for(int i=0;i<herbName.length;i++)
                                            {
                                                if(herbName[i]!=null){
                                                        if(herbName[i].contains(SearchInput) || herbDescrip[i].contains(SearchInput) || medicalUse[i].contains(SearchInput) || symptom[i].contains(SearchInput))
                                                        {
                                                                    found=true;
                                                                    System.out.println(herbName[i]+", Medical use: "+medicalUse[i]+", Description: "+herbDescrip[i]+", Symptom: "+symptom[i]);
                                                        }               
                                            System.out.println();
                                            }
                                            }
                      
                                            if(!found)
                                            {
                                                        System.out.println("No match found.");
                                            }
                    
                                            break;
                                            case "Add":
                                            System.out.println("Please enter the details of the new herb.");
                                            System.out.println("Name:");
                                            String name =s.nextLine();
                                            System.out.println("Description:");
                                            String desc =s.nextLine();
                                            System.out.println("Medical use:");
                                            String gen =s.nextLine();
                                            System.out.println("Symptoms:");
                                            String nSym =s.nextLine();
                                            herbName= incArray(herbName,1);
                                            herbDescrip=incArray(herbDescrip,1);
                                            medicalUse=incArray(medicalUse,1);
                                            symptom=incArray(symptom,1);
                                            herbName[herbName.length-1]=name;herbDescrip[herbDescrip.length-1]=desc;medicalUse[medicalUse.length-1]=gen;symptom[symptom.length-1]=nSym;
                                            System.out.println("Added Successfully.");
                          
                                            System.out.println("\nList of herbs:");
                                            
                                            for(int i=0;i<herbName.length;i++)
                                            {
                                                        if(herbName[i]!=null)
                                                        System.out.println(herbName[i]+", Medical use: "+medicalUse[i]+", Description: "+herbDescrip[i]+", Symptom: "+symptom[i]);
                                            }
        
                                            break;
                                            case "Modify":
                                            System.out.println("Please enter the name of the herb you wish to modify.");
                                            String in= s.nextLine();
                      
                                            for(int i=0;i<herbName.length;i++)
                                            {
                                                        if(in.equals(herbName[i]))
                                                        {
                                                                    System.out.println("Please enter what you'd like to modify about this herb: \n Type 1 for herb name. \n Type 2 for symptom(s). \n Type 3 for the herb description. \n Type 4 for medical use.");
                                                                    try
                                                                    {  
                                                                                int ch=Integer.parseInt(s.nextLine());
                                                                                if(ch==1)
                                                                                {
                                                                                            System.out.println("Enter the new herb name:");
                                                                                            String newName= s.nextLine();
                                                                                            herbName[i]=newName;
                                                                                }
                                                                                else if(ch==2)
                                                                                {
                                                                                            System.out.println("Enter the new symptom(s):");
                                                                                            String newSym= s.nextLine();
                                                                                            try
                                                                                            {
                                                                                                        symptom[i]=newSym;
                                
                                                                                            }catch(Exception ex){};
                            
                                                                                }
                                                                                else if(ch==3)
                                                                                {
                                                                                            System.out.println("Enter the new herb description:");
                                                                                            String newDesc= s.nextLine();
                                                                                            herbDescrip[i]=newDesc;
                                                                                }
                                                                                else if(ch==4)
                                                                                {
                                                                                            System.out.println("Enter the new medical use data:");
                                                                                            String newUse = s.nextLine();
                                                                                            medicalUse[i] = newUse;
                                                                                }
                                                                    }catch(Exception ex){}
                                                        }
                                                        System.out.println();
                                            }
                      
                                            System.out.println("\nList of herbs:");
                      
                                            for(int i=0;i<herbName.length;i++)
                                            {
                                                        if(herbName[i]!=null)
                                                        System.out.println(herbName[i]+", Medical use: "+medicalUse[i]+", Description: "+herbDescrip[i]+", Symptom: "+symptom[i]);
                                            }
                         
                                            break;
                                            case "Delete":
                                            System.out.println("Please enter the name of the herb you want to delete.");
                                            String inp= s.nextLine();
                      
                                            for(int i=0;i<herbName.length;i++)
                                            {
                                                        if(inp.equals(herbName[i]))
                                                        {
                                                                    herbName[i]=null;
                                                                    symptom[i]=null;
                                                                    herbDescrip[i]=null;
                                                                    medicalUse[i]=null;
                                                                    System.out.println("Delete success.");
                                                        }
                                            }
                 
                                            System.out.println("\nList of herbs:");
                    
                                            for(int i=0;i<herbName.length;i++)
                                            {
                                                        if(herbName[i]!=null)
                                                        System.out.println(herbName[i]+", Medical use: "+medicalUse[i]+", Description: "+herbDescrip[i]+", Symptom: "+symptom[i]);
                                            }
                      
                                            break;
                                            case "End":
                                            System.out.println("Terminated.\n");
                                            bCont=false;
                                            break;
                                            default:
                                            break;
                          
                                }
                    }
        }
        
        public static String[] incArray(String[] theArray, int increaseBy)  
        {  
                    int i = theArray.length;  
                    int n = ++i;  
                    String[] newArray = new String[n];  
    
                    for(int cnt=0;cnt<theArray.length;cnt++)
                    {  
                                newArray[cnt] = theArray[cnt];  
                    }  
                    return newArray;  
        } 
}
