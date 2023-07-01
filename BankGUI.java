
/**
 * Write a description of class BankGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;

public class BankGUI 
{
    private JFrame frame;
    private JPanel pnl1,pnl2,pnl3,pnl4;
    private JLabel cardId, clientName, issuerBank, bankAccount, balanceAmount, pinNumber,
            wCardId,wPinNumber, WithdrawalAmount, WithdrawalDate,
            creditCardId, creditClientName, creditBalanceAmount, creditBankAmount, interestRate, cvcNumber, creditIssuerBank, expirationDate, 
            limitcardId, creditLimit, graceperiod;
    private JTextField cardIdTxt, clientNameTxt, issuerBankTxt, bankAccountTxt, balanceAmountTxt, pinNumberTxt, 
            wCardIdTxt, wPinNumberTxt, withdrawalAmountTxt, 
            creditCardIdTxt, creditClientNameTxt, creditBalanceAmountTxt, creditBankAccountTxt, interestRateTxt, cvcNumberTxt, creditIssuerBankTxt,  
            limitCardIdTxt, creditLimitTxt, gracePeriodTxt ;
    private JComboBox<String> wyearbox, wmonthbox, wdaybox, eyearbox, emonthbox, edaybox;
    private JButton  addDebitCard, addCreditCard, withdraw, cancelcreditcard, addcreditlimit, Displaydebit, Displaycredit, clear;
    private String[] year ={"Year", "2018", "2019","2020", "2021", "2022", "2023","2024", "2025","2026"};
    private String[] month = {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] day = {"Day","1", "2", "3", "4", "5", "6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private final static int INVALID = -1;        
    ArrayList<BankCard> list = new ArrayList<BankCard>();
    public BankGUI()
    {
        //frame
        frame = new JFrame("Bank GUI");
        frame.setSize(975, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        //Debit card panel
        pnl1 = new JPanel();
        pnl1.setSize( 450,350);
        pnl1.setLocation(25,15);
        pnl1.setLayout(null);
        pnl1.setBorder(BorderFactory.createLineBorder(Color.black, 2)); 
        frame.add(pnl1);
        

        cardId = new JLabel("card Id");
        cardId.setBounds(25,25,120,35);
        pnl1.add(cardId);
        cardIdTxt = new JTextField();
        cardIdTxt.setBounds(150,25, 120, 35);
        pnl1.add(cardIdTxt);

        clientName = new JLabel("Client Name");
        clientName.setBounds(25, 70, 120, 35);
        pnl1.add(clientName);
        clientNameTxt = new JTextField();
        clientNameTxt.setBounds(150,70, 120, 35);
        pnl1.add(clientNameTxt);

        issuerBank = new JLabel("Issuer Bank");
        issuerBank.setBounds(25, 115, 120, 35);
        pnl1.add(issuerBank);
        issuerBankTxt = new JTextField();
        issuerBankTxt.setBounds(150,115, 120, 35);
        pnl1.add(issuerBankTxt);

        bankAccount = new JLabel("Bank Account");
        bankAccount.setBounds(25, 160, 120, 35);
        pnl1.add(bankAccount);
        bankAccountTxt = new JTextField();
        bankAccountTxt.setBounds(150,160, 120, 35);
        pnl1.add(bankAccountTxt);

        balanceAmount = new JLabel("Balance Amount");
        balanceAmount.setBounds(25,205,120,35);
        pnl1.add(balanceAmount);
        balanceAmountTxt = new JTextField();
        balanceAmountTxt.setBounds(150,205, 120, 35);
        pnl1.add(balanceAmountTxt);

        pinNumber = new JLabel("Pin Number");
        pinNumber.setBounds(25,250, 120,35);
        pnl1.add(pinNumber);
        pinNumberTxt = new JTextField();
        pinNumberTxt.setBounds(150,250, 120, 35);
        pnl1.add(pinNumberTxt);

        addDebitCard = new JButton("add Debit Card");
        addDebitCard.setBounds(80, 295, 120, 35);
        pnl1.add(addDebitCard);
        addDebitCard.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                addDebitCard();
            }
        });

        Displaydebit = new JButton("Display");
        Displaydebit.setBounds(210, 295, 120, 35);
        pnl1.add(Displaydebit);
        Displaydebit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                displayDebitCard();
            }
        });       
        
        pnl2 = new JPanel();
        pnl2.setSize(450, 350);
        pnl2.setLocation(485, 15);
        pnl2.setLayout(null);
        frame.add(pnl2);
        pnl2.setBorder(BorderFactory.createLineBorder(Color.black, 2)); 

        wCardId = new JLabel("Card Id");
        wCardId.setBounds(25,25, 120,35);
        pnl2.add(wCardId);
        wCardIdTxt = new JTextField();  
        wCardIdTxt.setBounds(150,25, 120, 35);
        pnl2.add(wCardIdTxt);

        wPinNumber = new JLabel("Pin Number");
        wPinNumber.setBounds(25,70, 120,35);
        pnl2.add(wPinNumber);
        wPinNumberTxt = new JTextField();
        wPinNumberTxt.setBounds(150,70, 120, 35);
        pnl2.add(wPinNumberTxt);

        WithdrawalAmount = new JLabel("Withdrawal Amount");
        WithdrawalAmount.setBounds(25, 115, 120, 35);
        pnl2.add(WithdrawalAmount);
        withdrawalAmountTxt = new JTextField();
        withdrawalAmountTxt.setBounds(150,115, 120, 35);
        pnl2.add(withdrawalAmountTxt);

        WithdrawalDate  = new JLabel("WithdrawalDate");
        WithdrawalDate.setBounds(25, 160, 120, 35);
        pnl2.add(WithdrawalDate);
        
        wyearbox = new JComboBox<String>(year);
        wyearbox.setBounds(150,160, 75, 35);
        pnl2.add(wyearbox);
        
        wmonthbox = new JComboBox<String>(month);
        wmonthbox.setBounds(235, 160, 75, 35);
        pnl2.add(wmonthbox);
        
        wdaybox = new JComboBox<String>(day);
        wdaybox.setBounds(315, 160, 75, 35);
        pnl2.add(wdaybox);

        
        clear = new JButton("Clear All");
        clear.setBounds(100, 205, 120, 35);
        pnl2.add(clear);;
        clear.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                cardIdTxt.setText("");
                clientNameTxt.setText("");
                issuerBankTxt.setText("");
                bankAccountTxt.setText("");
                balanceAmountTxt.setText("");
                pinNumberTxt.setText("");
                wCardIdTxt.setText("");
                wPinNumberTxt.setText("");
                withdrawalAmountTxt.setText("");
                wyearbox.setSelectedIndex(0);
                wmonthbox.setSelectedIndex(0);
                wdaybox.setSelectedIndex(0);
                creditCardIdTxt.setText("");
                creditClientNameTxt.setText("");
                creditBalanceAmountTxt.setText("");
                creditBankAccountTxt.setText("");
                interestRateTxt.setText("");
                cvcNumberTxt.setText("");
                creditIssuerBankTxt.setText("");
                eyearbox.setSelectedIndex(0);
                emonthbox.setSelectedIndex(0);
                edaybox.setSelectedIndex(0);
                limitCardIdTxt.setText("");
                creditLimitTxt.setText("");
                gracePeriodTxt.setText("");
            }
        });

        withdraw = new JButton("withdraw");
        withdraw.setBounds(240, 205, 120, 35);
        pnl2.add(withdraw);
        withdraw.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {              
                Withdraw();
            }
        });
        
        //Credit Card Panel
        pnl3 = new JPanel();
        pnl3.setSize(450,450);
        pnl3.setLocation(25, 380);
        pnl3.setLayout(null);
        pnl3.setBorder(BorderFactory.createLineBorder(Color.black, 2)); 
        frame.add(pnl3);

        creditCardId = new JLabel("Card Id");
        creditCardId.setBounds(25,25, 120,35);
        pnl3.add(creditCardId);
        creditCardIdTxt = new JTextField();
        creditCardIdTxt.setBounds(150,25, 120, 35);
        pnl3.add(creditCardIdTxt);
        
        creditClientName = new JLabel(" Client Name");
        creditClientName.setBounds(25,70, 120,35);
        pnl3.add(creditClientName);
        creditClientNameTxt = new JTextField();
        creditClientNameTxt.setBounds(150,70, 120, 35);
        pnl3.add(creditClientNameTxt);

        creditBalanceAmount = new JLabel("Balance Amount");
        creditBalanceAmount.setBounds(25, 115, 120, 35);
        pnl3.add(creditBalanceAmount);
        creditBalanceAmountTxt = new JTextField();
        creditBalanceAmountTxt.setBounds(150,115, 120, 35);
        pnl3.add(creditBalanceAmountTxt);

        creditBankAmount = new JLabel("Bank Account");
        creditBankAmount.setBounds(25, 160, 120, 35);
        pnl3.add(creditBankAmount);
        creditBankAccountTxt =  new JTextField();
        creditBankAccountTxt.setBounds(150,160, 120, 35);
        pnl3.add(creditBankAccountTxt);


        interestRate = new JLabel("Interest Rate");
        interestRate.setBounds(25, 205, 120, 35);
        pnl3.add(interestRate);
        interestRateTxt = new JTextField();
        interestRateTxt.setBounds(150,205, 120, 35);
        pnl3.add(interestRateTxt);

        cvcNumber = new JLabel("CVC Number");
        cvcNumber.setBounds(25, 250, 120, 35);
        pnl3.add(cvcNumber);
        cvcNumberTxt = new JTextField();
        cvcNumberTxt.setBounds(150,250, 120, 35);
        pnl3.add(cvcNumberTxt);

        creditIssuerBank = new JLabel("Issuer bank");
        creditIssuerBank.setBounds(25, 295, 120, 35);
        pnl3.add(creditIssuerBank);
        creditIssuerBankTxt = new JTextField();
        creditIssuerBankTxt.setBounds(150,295, 120, 35);
        pnl3.add(creditIssuerBankTxt);

        expirationDate = new JLabel("Expiration Date");
        expirationDate.setBounds(25,340,120,35);
        pnl3.add(expirationDate);

        eyearbox = new JComboBox<String>(year);
        eyearbox.setBounds(150,340, 75, 35);
        pnl3.add(eyearbox);
        
        emonthbox = new JComboBox<String>(month);
        emonthbox.setBounds(235,340, 75, 35);
        pnl3.add(emonthbox);
        
        edaybox = new JComboBox<String>(day);
        edaybox.setBounds(315,340, 75, 35);
        pnl3.add(edaybox);

        addCreditCard = new JButton("Add Credit Card");
        addCreditCard.setBounds(80, 385, 160, 35);
        pnl3.add(addCreditCard);
        addCreditCard.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                addCredit();
            }
        });

        Displaycredit = new JButton("Display");
        Displaycredit.setBounds(250, 385, 160, 35);
        pnl3.add(Displaycredit);
        Displaycredit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                displayCreditCard();
            }
        });
        
        pnl4 = new JPanel();
        pnl4.setSize(450,450);
        pnl4.setLocation(485, 380);
        pnl4.setLayout(null);
        pnl4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        frame.add(pnl4);

        limitcardId = new JLabel("Card Id");
        limitcardId.setBounds(25,25, 120,35);
        pnl4.add(limitcardId);
        limitCardIdTxt = new JTextField();
        limitCardIdTxt.setBounds(150,25, 120, 35);
        pnl4.add(limitCardIdTxt);

        creditLimit = new JLabel("Credit Limit");
        creditLimit.setBounds(25, 70, 120, 35);
        pnl4.add(creditLimit);
        creditLimitTxt = new JTextField();
        creditLimitTxt.setBounds(150,70, 120, 35);
        pnl4.add(creditLimitTxt);

        graceperiod = new JLabel("Grace Period");
        graceperiod.setBounds(25, 115, 120, 35);
        pnl4.add(graceperiod);
        gracePeriodTxt = new JTextField();
        gracePeriodTxt.setBounds(150,115, 120, 35);
        pnl4.add(gracePeriodTxt);

        addcreditlimit = new JButton("Add Credit Limit");
        addcreditlimit.setBounds(80, 160, 160, 35);
        pnl4.add(addcreditlimit);
        addcreditlimit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                addCreditLimit();
            }
        });

        cancelcreditcard = new JButton("Cancel Credit Card");
        cancelcreditcard.setBounds(250, 160, 160, 35);
        pnl4.add(cancelcreditcard);
        cancelcreditcard.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                cancelCreditCard();
            }
        });

        frame.setVisible(true);
        
    }
    
    //debit card
     public int getDebitCardID()// throws NumberFormatException
    {
        int DebitCardId = INVALID;
        try {
            DebitCardId = Integer.parseInt(cardIdTxt.getText().trim());
            if (DebitCardId <= 0) 
            {
                DebitCardId = INVALID;
            }
        } catch (NumberFormatException ae) 
        {
            JOptionPane.showMessageDialog(pnl1, "INVALID ERROR" + "\n" + "Please enter cardId in Number",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw ae;
        }
        return DebitCardId;
    }

    public String getDebitClientName() //throws NumberFormatException 
    {
        String debitClientName = clientNameTxt.getText().trim();
        if (debitClientName.isEmpty() ) 
        {
            JOptionPane.showMessageDialog(pnl1, "INVALID INPUT" + "\n" + "please enter client textfields",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return debitClientName;
    }

    public String getDebitIssuerBank() //throws NumberFormatException 
    {
        String debitIssuerBank = issuerBankTxt.getText().trim();
        if ( debitIssuerBank.isEmpty() )
        {
            JOptionPane.showMessageDialog(pnl1, "INVALID INPUT" + "\n" + "please enter issuer textfields",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);   
        }
        return debitIssuerBank;
    }

    public String getDebitBankAccount() //throws NumberFormatException 
    {
        String debitBankAccount = bankAccountTxt.getText().trim();
        if ( debitBankAccount.isEmpty() )
        {   
            JOptionPane.showMessageDialog(pnl1, "INVALID INPUT" + "\n" + "please enter bank text fields",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);   
        }
        return debitBankAccount;
    }

    public int getDebitBalanceAmount() throws NumberFormatException
    {
        int debitBalanceAmount = INVALID;
        try {
            debitBalanceAmount = Integer.parseInt(balanceAmountTxt.getText().trim());
            if (debitBalanceAmount <= 0) 
            {
                debitBalanceAmount = INVALID;
            }
        } catch (NumberFormatException ae) 
        {
            JOptionPane.showMessageDialog(pnl1, "INVALID INPUT" + "\n" + "Please enter balance amount in number",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw ae;
        }
        return debitBalanceAmount;
    }

    public int getDebitPinNumber() throws NumberFormatException
    {
        int debitPinNumber = INVALID;
        try {
            debitPinNumber = Integer.parseInt(pinNumberTxt.getText().trim());
            if (debitPinNumber <= 0) 
            {
                debitPinNumber = INVALID;
            }
        } catch (NumberFormatException ae) 
        {
            JOptionPane.showMessageDialog(pnl1, "INVALID INPUT" + "\n" + "Please enter valid Pin Number",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw ae;
        }
        return debitPinNumber;
    }

    public boolean checkDebitCardUniqueCardId(int debitCardId) 
    {
        boolean result = true;
        for (BankCard obj : list) 
        {
            if (obj instanceof DebitCard) 
            {
                DebitCard list = (DebitCard) obj;
                if (list.getCardId() == debitCardId) 
                {
                    result = false;
                }
            }
        }
        return result;
    }
    
    public void addDebitCard() 
    {
        int debitCardId = getDebitCardID();
        String debitClientName = getDebitClientName();
        String debitIssuerBank = getDebitIssuerBank();
        String debitBankAccount = getDebitBankAccount();
        int debitBalanceAmount = getDebitBalanceAmount();
        int debitPinNumber = getDebitPinNumber();

        if (debitClientName.isEmpty() || debitIssuerBank.isEmpty() || debitBankAccount.isEmpty()) 
        {
            JOptionPane.showMessageDialog(pnl1, "INVALID INPUT" + "\n" + "Fields cannot be empty","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (debitBalanceAmount < 0) 
        {
            JOptionPane.showMessageDialog(pnl1,"INVALID INPUT" + "\n" + "Balance Amount cannot be less than 0", "ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (debitCardId <= 0) 
        {
            JOptionPane.showMessageDialog(pnl1, "INVALID INPUT" + "\n" + "Card Id cannot be less than 0","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (debitPinNumber <= 0) 
        {
            JOptionPane.showMessageDialog(pnl1,"INVALID INPUT" + "\n" + "Pin Number cannot be less than 0","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (checkDebitCardUniqueCardId(debitCardId) == true)
        {
            list.add(new DebitCard(debitCardId, debitBankAccount, debitBalanceAmount, debitIssuerBank, debitClientName, debitPinNumber));
            JOptionPane.showMessageDialog(pnl1,"YOUR DEBIT CARD HAS BEEN ADDED!","Object Added",JOptionPane.INFORMATION_MESSAGE);
        }
        else 
        {
            JOptionPane.showMessageDialog(pnl1, "Please Enter Unique Card Id","Error box", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayDebitCard() 
    {
        for (BankCard obj : list) 
        {
            if (obj instanceof DebitCard) 
            {
                DebitCard debitCard = (DebitCard) obj;
                debitCard.display();
            }
        }
    }
    
    // withdrawal
    public int getWithdrawCardId() 
    {
        int withdrawCardId = INVALID;
        try {
            withdrawCardId = Integer.parseInt(wCardIdTxt.getText().trim());
            if (withdrawCardId <= 0) 
            {
                withdrawCardId = INVALID;
            }
        } catch (NumberFormatException ae) 
        {
            JOptionPane.showMessageDialog(pnl2, "INVALID INPUT" + "\n" + "Please enter valid Card Id",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw ae;
        }
        return withdrawCardId;
    }

    public int getWithdrawAmount() 
    {
        int withdrawamount = INVALID;
        try {
            withdrawamount = Integer.parseInt(withdrawalAmountTxt.getText().trim());
            if (withdrawamount <= 0) 
            {
                withdrawamount = INVALID;
            }
        } catch (NumberFormatException ae) 
        {
            JOptionPane.showMessageDialog(pnl2, "INVALID INPUT" + "\n" + "Please enter valid withdrawal amount",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw ae;
        }
        return withdrawamount;
    }

    public int getWithdrawPinNumber() 
    {
        int withdrawPinNumber = INVALID;
        try {
            withdrawPinNumber = Integer.parseInt(wPinNumberTxt.getText().trim());
            if (withdrawPinNumber <= 0) 
            {
                withdrawPinNumber = INVALID;
            }
        } catch (NumberFormatException ae) 
        {
            JOptionPane.showMessageDialog(pnl2, "INVALID INPUT" + "\n" + "Please enter valid Pin Number",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw ae;
        }
        return withdrawPinNumber;
    }

    public String getWithdrawalDate() 
    {
        String year = wyearbox.getSelectedItem().toString();
        String month = wmonthbox.getSelectedItem().toString();
        String day = wdaybox.getSelectedItem().toString();
        String date = (year + "-" + month + "-" + day);
        if (year.equals("Year") || month.equals("Month") || day.equals("Day") ||date.equals("Year-Month-Day") ) 
        {
            JOptionPane.showMessageDialog(pnl2, "INVALID INPUT" + "\n" + "Please enter valid date",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return null;
        } else 
        {
            date = (year + "-" + month + "-" + day);
            return date;
        }
        
    }

    public void Withdraw() 
    {
        int withdrawCardId = getWithdrawCardId();
        int withdrawPinNumber = getWithdrawPinNumber();
        int withdrawAmount = getWithdrawAmount();
        int debitPinNumber = getDebitPinNumber();
        String withdrawalDate = getWithdrawalDate();
        
        if (withdrawAmount == 0) 
        {
            JOptionPane.showMessageDialog(pnl2,"INVALID INPUT" + "\n" + "Withdraw Amount cannot be less than 1", 
            "ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (withdrawPinNumber <= 0 || debitPinNumber != withdrawPinNumber) 
        {
            JOptionPane.showMessageDialog(pnl2, "INVALID INPUT" + "\n" + "enter Correct Pin Number",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (withdrawalDate == null) 
        {
            JOptionPane.showMessageDialog(pnl2, "INVALID INPUT" + "\n" + "Enter Valid Withdrawal Date",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (withdrawCardId == 0) 
        {
            JOptionPane.showMessageDialog(pnl2, "INVALID INPUT" + "\n" + "Enter Valid Card ID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (BankCard obj : list) 
        {
            if (obj instanceof DebitCard) 
            {
                DebitCard debitCard = (DebitCard) obj;
                if (debitCard.getCardId() == withdrawCardId ) 
                {   //|| debitCard.getpinNumber() == pinNumber
                    debitCard.withdraw(withdrawAmount, withdrawPinNumber, withdrawalDate);
                    JOptionPane.showMessageDialog(pnl2, "YOUR WITHDRAW OF "+withdrawAmount+" WAS SUCCESSFULL",
                    "Withdraw", JOptionPane.INFORMATION_MESSAGE);
                } else 
                {
                    JOptionPane.showMessageDialog(pnl2, "Card Id Doesnot Matched" + "\n" + "Please Check Your Card Id And Enter Correctly",
                    "NOT FOUND", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

    }
    
    //credit card
    public int getCreditCardId() 
    {
        int creditCardid = INVALID;
        try {
            creditCardid = Integer.parseInt(creditCardIdTxt.getText().trim());
            if (creditCardid <= 0) 
            {
                creditCardid = INVALID;
            }
        } catch (NumberFormatException ae) 
        {
            JOptionPane.showMessageDialog(pnl3, "INVALID ERROR" + "\n" + "Please Enter Card Id In Number",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw ae;
        }
        return creditCardid;
    }

     public String getCreditClientName() 
    {
       String creditClientName = creditClientNameTxt.getText().trim();
        if (creditClientName.isEmpty() )
        {     
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Please Enter Client Textfields",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);   
        }
        return creditClientName;
    }

    public String getCreditIssuerBank() 
    {
        String creditIssuerBank = creditIssuerBankTxt.getText().trim();
        if(creditIssuerBank.isEmpty() )
        { 
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Please Enter Issuer Textfields",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return creditIssuerBank;
    }

    public String getCreditBankAccount() 
    {
        String creditBankAccount = creditBankAccountTxt.getText().trim();
        if(creditBankAccount.isEmpty()) 
        {  
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Please Enter Bank Textfields",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);   
        }
        return creditBankAccount;
    }
    
    public int getCreditBalanceAmount() 
    {
        int creditBalanceAmount = INVALID;
        try {
                creditBalanceAmount = Integer.parseInt(creditBalanceAmountTxt.getText().trim());
                if(creditBalanceAmount < 0) 
                {
                    creditBalanceAmount = INVALID;
                }
        } catch (NumberFormatException ae) 
                {
                    JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Please Enter Balance Amount In Number" ,
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
                    throw ae;
                }
        return creditBalanceAmount;
    }

    public int getCVCNumber() 
    {
        int CVCNumber = INVALID;
        try {
            CVCNumber = Integer.parseInt(cvcNumberTxt.getText());
            if (CVCNumber < 0) 
            {
                CVCNumber = INVALID;
            }
        } catch (NumberFormatException ae) 
        {
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Please Enter Valid CVC Number",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw ae;
        }
        return CVCNumber;
    }

    public double getInterestRate() {
        double interestRate = INVALID;
        try {
            interestRate = Double.parseDouble(interestRateTxt.getText());
            if(interestRate <= 0) 
            {
                interestRate = INVALID;
            }
        } catch (NumberFormatException ae) 
        {
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Please Enter Interest Rate",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw ae;
        }
        return interestRate;
    }

    public String getExpirationDate() 
    {
        String year = eyearbox.getSelectedItem().toString();
        String month = emonthbox.getSelectedItem().toString();
        String day = edaybox.getSelectedItem().toString();
        String date = (year + "-" + month + "-" + day);
        if (year.equals("Year") || month.equals("Month") || day.equals("Day") ||date.equals("Year-Month-Day") ) 
        {
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Please Enter Expiration Date",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            date = (year + "-" + month + "-" + day);
           return date;
        }
    }
    
    public boolean checkCreditCardUniqueCardID(int creditCardId) 
    {
        boolean result = true;
        for (BankCard obj : list) 
        {
            if (obj instanceof CreditCard) 
            {
                CreditCard list = (CreditCard) obj;
                if (list.getCardId() == creditCardId) 
                {
                    result = false;
                }
            }
        }
        return result;
    }

    public void addCredit() 
    {
        int creditCardId = getCreditCardId();
        String creditClientName = getCreditClientName();
        int creditBalanceAmount = getCreditBalanceAmount();
        String creditBankAccount = getCreditBankAccount();
        double interestRate = getInterestRate();
        String creditIssuerBank = getCreditIssuerBank();
        int CVCNumber = getCVCNumber();
        String expirationDate = getExpirationDate();
        if (creditCardId <= 0) 
        {
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (creditClientName.isEmpty() )
        {
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "please enter client textfield",//, issuer and bank textfields
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (creditBalanceAmount < 0) 
        {
            JOptionPane.showMessageDialog(pnl3,
            "INVALID INPUT" + "\n" + "Balance Amount cannot be less than 0", "ERROR MESSAGE",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(creditIssuerBank.isEmpty())
        {
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Please enter valid Issuer Bank in above panel issuer text field",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(creditBankAccount.isEmpty())
        {
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Please enter valid Bank Account",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (CVCNumber <= 0) 
        {
            JOptionPane.showMessageDialog(pnl3,
            "INVALID INPUT" + "\n" + "CVC Number cannot be less than 1", "ERROR MESSAGE",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (expirationDate == null) 
        {
            JOptionPane.showMessageDialog(pnl3, "INVALID INPUT" + "\n" + "Enter Valid Expiration Date",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (interestRate <= 0) 
        {
            JOptionPane.showMessageDialog(pnl3,
            "INVALID INPUT" + "\n" + "Rate cannot be less than 1",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (checkCreditCardUniqueCardID(creditCardId) == true )
        {
            list.add(new CreditCard(creditCardId,  creditIssuerBank, creditBankAccount, creditBalanceAmount,  CVCNumber,  interestRate,  expirationDate));
            JOptionPane.showMessageDialog(pnl3,"CREDITCARD ADDED" + "\n" + "Client Name: " + creditClientName + "\n" + "Card ID: " + creditCardId +"\n" 
            +"Issuer Bank: "+ creditIssuerBank + "\n" + "Bank Account: " + creditBankAccount + "\n" + "BalanceAmount: " + creditBalanceAmount + "\n"
            + "CVC Number: " + CVCNumber + "\n" + "Interest Rate: " + interestRate + "\n" + "Expiration Date: "
            + expirationDate,
            "DETAILS OF CARD", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(pnl3, "card id should be unique","Error box", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void displayCreditCard() 
    {
        for (BankCard obj : list) 
        {
            if( obj instanceof CreditCard)
            {
                CreditCard creditCard = (CreditCard) obj;
                creditCard.display();
            }
        }
    }
    
    //Credit Limit 
    public int getLimitCardId() 
    {
        int limitCardId = INVALID;
        try {
            limitCardId = Integer.parseInt(limitCardIdTxt.getText());
            if (limitCardId <= 0) 
            {
                JOptionPane.showMessageDialog(pnl4, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
                "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception ae) 
        {
            JOptionPane.showMessageDialog(pnl4, "INVALID INPUT" + "\n" + "Please enter valid Card ID",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return limitCardId;
    }

    public double getCreditLimit() 
    {
        double creditLimit = INVALID;
        try {
            creditLimit = Double.parseDouble(creditLimitTxt.getText());
            if (creditLimit <= 0) 
            {
                creditLimit = INVALID;
            }
        } catch (Exception ae) 
        {
            JOptionPane.showMessageDialog(pnl4, "INVALID INPUT" + "\n" + "Please enter valid CreditLimit",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }

        return creditLimit;
    }

    public int getGracePeriod() 
    {
        int graceperiod = INVALID;
        try {
            graceperiod = Integer.parseInt(gracePeriodTxt.getText());
            if (graceperiod <= 0) 
            {
                graceperiod = INVALID;
            }
        } catch (Exception ae) 
        {
            JOptionPane.showMessageDialog(pnl4, "INVALID INPUT" + "\n" + "Please enter valid GracePeriod",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return graceperiod;
    }

    public void addCreditLimit() 
    {
        int limitCardId = getLimitCardId();
        int creditCardId = getCreditCardId();
        double creditlimit = getCreditLimit();
        int gracePeriod = getGracePeriod();
        if (limitCardId == INVALID || limitCardId != creditCardId) {
            JOptionPane.showMessageDialog(pnl4, "INVALID INPUT" + "\n" + "Please Check Credit Card Id And Enter Correctly",
            "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (creditlimit ==  INVALID) 
        {
            JOptionPane.showMessageDialog(pnl4, "INVALID INPUT" + "\n" + "Credit Limit cannot be less than 1",
            "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (gracePeriod == INVALID) 
        {
            JOptionPane.showMessageDialog(pnl4, "INVALID INPUT" + "\n" + "Grace Period cannot be less than 1",
            "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        for (BankCard obj : list) 
        {
            if (obj instanceof CreditCard) 
            {
                CreditCard creditCard = (CreditCard) obj;
                if (creditCard.getCardId() == limitCardId) 
                {
                    creditCard.setCreditLimit((int)creditlimit, gracePeriod);
                    JOptionPane.showMessageDialog(pnl4, "Your Credit Limit Is Set",
                    "Credit Limit", JOptionPane.INFORMATION_MESSAGE);
                } else 
                {
                    JOptionPane.showMessageDialog(pnl4, "Card Id Not Found" + "\n" + "Enter Correct Card ID",
                            "NOT FOUND", JOptionPane.WARNING_MESSAGE);
                }
 
            }
        }
    }
    
    //cancel credit card
    public int getCancelCardId() 
    {
        int cancelCardId = INVALID;
        try {
            cancelCardId = Integer.parseInt(limitCardIdTxt.getText());
            if (cancelCardId <= 0) 
            {
                cancelCardId = INVALID;
            }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(pnl4, "INVALID INPUT" + "\n" + "Please Check Card Id And Enter Correctly",
            "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
        return cancelCardId;
    }

    public void cancelCreditCard()
    {
        boolean isfound = false;
        int cancelCardId = getCancelCardId();
        for(BankCard obj: list)
        {
            if(obj instanceof CreditCard)
            {
                CreditCard creditCard = (CreditCard) obj;
                if(creditCard.getCardId()==cancelCardId)
                {
                    isfound = true;
                    creditCard.cancelCreditCard();
                    break;
                }
            }
        }
        
        if (isfound == true) 
        {
            JOptionPane.showMessageDialog(pnl4, "Canceled credit card", "success box", JOptionPane.INFORMATION_MESSAGE);
        } else 
        {
            JOptionPane.showMessageDialog(pnl4, "Your CardId Doesnot Match", "error Box",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void main(String[] args) 
    {
        new BankGUI();
    }
}
