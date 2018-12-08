package atm;

import atm.model.BankDatabase;
import atm.presenter.ATM;
import atm.view.cmd.CashDispenser;
import atm.view.cmd.DepositSlot;
import atm.view.swing.HardwareSwing;
import com.sun.istack.internal.logging.Logger;

// ATMCaseStudy.java
// Driver program for the ATM case study

public class ATMCaseStudy
{
    public static void main( String[] args )
    {
//       Screen screen = new Screen();
//       Keypad keypad = new Keypad();
       CashDispenser cashDispenser = new CashDispenser();
       DepositSlot depositSlot = new DepositSlot();
       BankDatabase bankDatabase = new BankDatabase();
       
       HardwareSwing view = new HardwareSwing();
       
      // Logger.getLogger(string, type);
       
       ATM theATM = new ATM(view, view, cashDispenser, depositSlot, bankDatabase);
       
       view.setVisible(true);
     
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