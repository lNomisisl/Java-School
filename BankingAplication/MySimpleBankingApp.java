                    package BankingAplication;

                         import java.io.File;
                         import java.io.FileNotFoundException;
                         import java.io.IOException;
                         import java.nio.charset.StandardCharsets;
                         import java.nio.file.Files;
                         import java.util.Scanner;
                         import java.util.stream.Stream;
                         import HelpersFile.Keyboard;
                         
 
                        
                         

                         /**
                          * This is a simple menu-driven program for simple banking.
                          * Transactions are read from a file and loaded into an array.
                          * This application allows the user to display information,
                          * send money, add money and exit the program.
                          */
                             public class MySimpleBankingApp {
                             /**
                              * Declare variables that can be used by every method here! 
                              */
                             public static double balance = 250.00;
                         
                             public static String currency = "Euro";

                             public static String[] transactions = new String[100];
                         
                             public static String[] contacts = {"melb1234", "wchurchill456"};
                         
                             public static void main(String[] args) throws FileNotFoundException {
                         
                                    
                                 char userChoice ;

                                boolean quit = false;

                                double AmountToAdd;
                                double CardNumber;
                                String ExpirationDate;
                                double SecurityCode;
                                String Recipient;
                                double AmountSent;
                   
                               do {
                                 // provide a menu of options:
                                 // A. Display Account Information
                                 // B. Add Money
                                 // C. Send Money
                                 // D. Quit
                   
                                     System.out.println("A. Display Account Information");

                                     System.out.println("B. Send Money");

                                     System.out.println("C. Add Money");
                   
                                     System.out.println("D. Quit:");
                   
                                     
                   
                                     userChoice = Keyboard.readChar();
                                     // while userChoice != 'd'
                                     //     trigger appropriate action based on user choice (use switch case statement)
                                     //     ask for user choice again
                                     // create custom methods here for: add money, display all transactions, send
                   
                                     switch (userChoice) {

                                     case 'A':
                                           System.out.println("Your balance: " + balance + "Euro");
                                           File file = new File("C:\\Users\\Simon Grech\\Downloads\\captmidn.txt");
                                            Scanner scan = new Scanner(file);
                                            System.out.println("Transaction History: ");

                                            while(scan.hasNextLine()){
                                            System.out.println(scan.nextLine());
                                            }

                                           break;

                                     case 'B':
                                           System.out.println("To whom would you like to send money:");
                                           Recipient = Keyboard.readString();
                                           System.out.println("How much would you like to send:");
                                           AmountSent = Keyboard.readDouble();
                                           if (AmountSent <= 0 || AmountSent > balance)
                                           System.out.println("Withdrawal can't be completed.");
                                           else {
                                           balance -= AmountSent;
                                           System.out.println(+ AmountSent + "Euro" + " has been withdrawn.");
                                           }
                                           break;

                                     case 'C':
                                           System.out.println("Please enter the card details whit which you wish to add money to the account");
                                           System.out.println("Card Number:");
                                           CardNumber = Keyboard.readDouble();
                                           System.out.println("Please enter the expiration date:");
                                           ExpirationDate = Keyboard.readString();
                                           System.out.println("Please enter the security code:");
                                           SecurityCode = Keyboard.readDouble();
                                           System.out.println("Great. Now enter the amount you wish to add:" );
                                           AmountToAdd = Keyboard.readDouble();
                                           if (AmountToAdd <= 0)
                                           System.out.println("Can't deposit a negitive amount.");
                                           else {
                                          balance += AmountToAdd;
                                           System.out.println("Euro" + AmountToAdd + " has been added to your balance.");
                                           }
                                           System.out.println("Your updated balance is: " + balance + "Euro");
                                           break;

                                     case 'D':
                                           quit = true;
                                           break;

                                     default://  Declare char userChoice and set it to 'A' by default
                                           userChoice = 'A';
                                           break;
                                     }

                                     System.out.println();
                   
                               } while (!quit);
                   
                               System.out.println("Bye!");     
                            
                                 }
                             }
                         
                        

