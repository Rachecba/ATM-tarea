package atm.presenter;

import atm.model.BankDatabase;
import java.util.logging.Logger;
import atm.view.Screen;
import atm.view.KeyPad;
import atm.view.CashDispenser;
import atm.view.DepositSlot;

// ATM.java
// Represents an automated teller machine

public class ATM 
{
   private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private Screen screen; // ATM's screen
   private KeyPad keypad; // ATM's keypad
   private CashDispenser cashDispenser; // ATM's cash dispenser
   private DepositSlot depositSlot; // ATM's deposit slot
   private BankDatabase bankDatabase; // account information database
   
   private static final String CLASSNAME = ATM.class.getCanonicalName(); 
   private static final Logger logger = Logger.getLogger(CLASSNAME); 

   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int EXIT = 4;

   // no-argument ATM constructor initializes instance variables

   public ATM(Screen screen, KeyPad keypad, CashDispenser cashDispenser, DepositSlot depositSlot, BankDatabase bankDatabase) 
   {
      userAuthenticated = false; // user is not authenticated to start
      currentAccountNumber = 0; // no current account number to start
      this.screen = screen; // create screen
      this.keypad = keypad; // create keypad 
      this.cashDispenser = cashDispenser; // create cash dispenser
      this.depositSlot = depositSlot; // create deposit slot
      this.bankDatabase = bankDatabase; // create acct info database
   } // end no-argument ATM constructor
      
   public void setUserAuthenticated(boolean user){
        this.userAuthenticated = user;
   }
   
   public void setCurrenAccountNumber(int number){
       this.currentAccountNumber = number;
   }
   
   // start ATM 
   public void run()
   {
      // welcome and authenticate user; perform transactions
      while ( true )
      {
         // loop while user is not yet authenticated
         while ( !this.userAuthenticated ) 
         {
            this.screen.displayMessageLine( "\nWelcome!" );       
            authenticateUser(); // authenticate user
         } // end while
         
         performTransactions(); // user is now authenticated 
         this.userAuthenticated = false; // reset before next ATM session
         this.currentAccountNumber = 0; // reset before next ATM session 
         this.screen.displayMessageLine( "\nThank you! Goodbye!" );
      } // end while   
   } // end method run

   // attempts to authenticate user against database
   private void authenticateUser() 
   {
      this.screen.displayMessage( "\nPlease enter your account number: " );
      int accountNumber = this.keypad.getInput(); // input account number
      this.screen.displayMessage( "\nEnter your PIN: " ); // prompt for PIN
      int pin = this.keypad.getInput(); // input PIN
      
      // set userAuthenticated to boolean value returned by database
      this.userAuthenticated = 
         this.bankDatabase.authenticateUser( accountNumber, pin );
      
      // check whether authentication succeeded
      if ( this.userAuthenticated )
      {
         this.currentAccountNumber = accountNumber; // save user's account #
      } // end if
      else
         this.screen.displayMessageLine( 
             "Invalid account number or PIN. Please try again." );
   } // end method authenticateUser

   // display the main menu and perform transactions
   private void performTransactions() 
   {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while ( !userExited )
      {     
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenu();

         // decide how to proceed based on user's menu selection
         switch ( mainMenuSelection )
         {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY: 
            case WITHDRAWAL: 
            case DEPOSIT:

               // initialize as new object of chosen type
               currentTransaction = 
                  createTransaction( mainMenuSelection );

               currentTransaction.execute(); // execute transaction
               break; 
            case EXIT: // user chose to terminate session
               this.screen.displayMessageLine( "\nExiting the system..." );
               userExited = true; // this ATM session should end
               break;
            default: // user did not enter an integer from 1-4
               this.screen.displayMessageLine( 
                  "\nYou did not enter a valid selection. Try again." );
               break;
         } // end switch
      } // end while
   } // end method performTransactions
   
   // display the main menu and return an input selection
   private int displayMainMenu()
   {
      this.screen.displayMessageLine( "\nMain menu:" );
      this.screen.displayMessageLine( "1 - View my balance" );
      this.screen.displayMessageLine( "2 - Withdraw cash" );
      this.screen.displayMessageLine( "3 - Deposit funds" );
      this.screen.displayMessageLine( "4 - Exit\n" );
      this.screen.displayMessage( "Enter a choice: " );
      
      return this.keypad.getInput(); // return user's selection
   } // end method displayMainMenu
         
   // return object of specified Transaction subclass
   private Transaction createTransaction( int type )
   {
      Transaction temp = null; // temporary Transaction variable
      
      // determine which type of Transaction to create     
      switch ( type )
      {
         case BALANCE_INQUIRY: // create new BalanceInquiry transaction
            temp = new BalanceInquiry( 
               this.currentAccountNumber, this.screen, this.bankDatabase );
            break;
         case WITHDRAWAL: // create new Withdrawal transaction
            temp = new Withdrawal( this.currentAccountNumber, this.screen, 
               this.bankDatabase, this.keypad, this.cashDispenser );
            break; 
         case DEPOSIT: // create new Deposit transaction
            temp = new Deposit( this.currentAccountNumber, this.screen, 
               this.bankDatabase, this.keypad, this.depositSlot );
            break;
      } // end switch

      return temp; // return the newly created object
   } // end method createTransaction
} // end class ATM



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