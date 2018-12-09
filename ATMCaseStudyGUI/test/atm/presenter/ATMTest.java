/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.presenter;

import atm.model.BankDatabase;
import atm.view.cmd.DepositSlot;
import atm.view.cmd.CashDispenser;
import atm.view.cmd.Keypad;
import atm.view.cmd.Screen;
import atm.view.swing.HardwareSwing;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rachel
 */
public class ATMTest {
    
    public ATMTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    public ATM instanciaATM(){    
        HardwareSwing view = new HardwareSwing();
        
        DepositSlot deposit = new DepositSlot();
        CashDispenser dispenser = new CashDispenser();
        BankDatabase dataBase = new BankDatabase();
        
        ATM instancia = new ATM(view, view, dispenser, deposit, dataBase);
        
        instancia.setCurrenAccountNumber(12345);
        instancia.setUserAuthenticated(true);
        
        return instancia;
        
    }
    
    @Test
    public void authenticateUserTest(){
        System.out.println("* Testing authenticateUser *");
        ATM instance = this.instanciaATM();
        
    }

    /**
     * Test of run method, of class ATM.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ATM instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
