
import atm.view.cmd.CashDispenser;
import atm.view.cmd.DepositSlot;
import atm.view.cmd.Keypad;
import atm.view.cmd.Screen;

// ATMCaseStudy.java
// Driver program for the ATM case study

public class ATMCaseStudy
{
    private static Screen screen; // ATM's screen
    private static Keypad keypad; // ATM's keypad
    private static  CashDispenser cashDispenser; // ATM's cash dispenser
    private static DepositSlot depositSlot; // ATM's deposit slot
    private static BankDatabase bankDatabase; // account information database
    
    public static void main( String[] args )
    {
       ATM theATM;
       theATM = new ATM(screen,keypad, cashDispenser, depositSlot, bankDatabase);
       theATM.run();
     
       
       
       
} // end main
} // end class ATMCaseStudy 



/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/