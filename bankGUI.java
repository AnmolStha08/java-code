import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;


class BankCard {
    // instance variable declaration
    private int cardId;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private int balanceAmount;

    public BankCard(int cardId, String issuerBank, String bankAccount, int balanceAmount, String clientName) {
        // bank class constructor
        this.cardId = cardId;
        this.issuerBank = issuerBank;
        this.bankAccount = bankAccount;
        this.balanceAmount = balanceAmount;
        this.clientName = "";
    }

    // getter method for each property
    public int getCardId()

    {
        return cardId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getIssuerBank() {
        return issuerBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public int getBalanceAmount() {
        return balanceAmount;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setBalanceAmount(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    // attributes value display
    public void display() {
        if (clientName == "") {
            System.out.println("name not found error");
        } else {
            System.out.println("CardId: " + cardId);
            System.out.println("ClientName :" + clientName);
            System.out.println("IssuerBank : " + issuerBank);
            System.out.println("BankAccount : " + bankAccount);
            System.out.println("BalanceAmount : " + balanceAmount);
        }
    }
}


class CreditCard extends BankCard
{ 
    //instance variable declaration
    private int CVCNumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;
    //credit card constructor
    public CreditCard(int cardId, String issuerBank, String clientName, String bankAccount, int balanceAmount, int CVCNumber, double interestRate, String expirationDate)
    {
        super( cardId, issuerBank, bankAccount, balanceAmount, clientName);
        setClientName(clientName);
        this.interestRate = interestRate;
        this.CVCNumber = CVCNumber;
        this.expirationDate = expirationDate;
        this.isGranted = false;
    }
    //getter method for each property
    public int getCVCNumber()
    {
        return this.CVCNumber;
    }
    public double getCreditLimit()
    {
        return this.creditLimit;
    }
    public double getInterestRate()
    {
        return this.interestRate;
    }
    public int Graceperiod()
    {
        return this.gracePeriod;
    }
    public boolean IsGranted()
    {
        return this.isGranted;
    }
    // this is a credit limit setter method
    public void setCreditLimit(int newcreditLimit, int newGracePeriod)
    {
        if(newcreditLimit<=2.5*super.getBalanceAmount() )
        {
            this. creditLimit = newcreditLimit;
            this.gracePeriod = newGracePeriod;
            this.isGranted = true;
            System.out.println("Credit card is granted now.");
        }
        else
        {
            System.out.println("credit cannot be issued");
        }
    }
    //to Override Property Values
    public void cancelCreditCard()
    {
        this.CVCNumber = 0;
        this.creditLimit = 0;
        this.gracePeriod = 0;
        this.isGranted = false;
        System.out.println("Your credit card has been cancelled.");
    }
    // displaying
    public void display()
    {
        
        if(isGranted==true)
        {
            super.display();
            System.out.println("CVCNumber:" + CVCNumber);
            System.out.println("InterestRate:" + interestRate);
            System.out.println("ExperationDate:" + expirationDate);
            System.out.println("CreditLimit:" + creditLimit);
            System.out.println("GracePeriod:" + gracePeriod);
        }
        else {
    
         System.out.println("InterestRate:" + interestRate);
            System.out.println("ExperationDate:" + expirationDate);     
        System.out.println("Credit has not been issued");
    }
    }
    
}
    

class DebitCard extends BankCard
{
    private int pinNumber; 
    private int withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;
    //creating constructor with six parameters
    public DebitCard(int cardId, String bankAccount, int balanceAmount,String issuerBank,String clientName,int pinNumber)
    {
        super(cardId, issuerBank, bankAccount, balanceAmount, clientName);
        super.setClientName(clientName);
        this.withdrawalAmount=0;
        this.dateOfWithdrawal="";
        this.pinNumber=pinNumber;
        this.hasWithdrawn=false;
    }
    //Creating an accessor method for instance variable of Debitcard class
    public int getPinNumber()
    {
        return this.pinNumber;
    }
    public int getWithdrawalAmount()
    {
        return this.withdrawalAmount;
    }
    public String getDateOfWithdrawal()
    {
        return this.dateOfWithdrawal;
    }
    public boolean getHasWithdrawn()
    {
        return this.hasWithdrawn;
    }
    //Mutator method for removelAmount
    public void setWithdrawalAmount(int withdrawalAmount)
    {
        this.withdrawalAmount=withdrawalAmount;
    }
    //withdrawal method
    public void withdraw(int withdrawalAmount,int pinNumber,String dateOfWithdrawal)
    {
        if(this.pinNumber==pinNumber && getBalanceAmount()>=withdrawalAmount){
            setWithdrawalAmount(withdrawalAmount);
            this.dateOfWithdrawal=dateOfWithdrawal;
            this.hasWithdrawn=true;
            setBalanceAmount(getBalanceAmount()-withdrawalAmount);
            System.out.println(withdrawalAmount + " has been withdrawn sucessfully. Remaining amount is : " + getBalanceAmount());
        } 
        else{
            System.out.println("Your current balanceamount is "+getBalanceAmount()+" and sorry we cannot process your transaction"); 
        }
    }
    @Override
    //Create a display method of non-return type that is overridden by the display method of the BankCard class.
        public void display()
        {
            super.display();
            if(this.hasWithdrawn == true){
                System.out.println("Your pin number of debitcard is "+this.pinNumber);
                System.out.println("Your amount is withdrawan at "+this.dateOfWithdrawal);
                System.out.println("The withdrwan amount is "+this.withdrawalAmount);
            }
            else{
                System.out.println("Your current balance is "+getBalanceAmount());
            }
        }
    }






public class BankGUI  {
    private JFrame mainFrame;

    private JPanel debitPanel, creditPanel, panelwithdraw, creditLimitPanel, creditCancelPanel;
    private JLabel  firstLabel, secondLabel, thridLabel, fifthLabel, sixthLabel, seventhLabel, edithLebel, ninthLabel;
    private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8,
            textField9, textField10, textField11, textField12, textField13, textField14,
            textField15, textField16, textField17, textField18, textField19, textField20;
    private JButton firstButton, secondButton, third;
    private JComboBox<String> comboBox1, comboBox2, comboBox3, comboBox4, comboBox5, comboBox6;
    private Font  fontmedium, fontbig;
    final static int INVALID = -1;
    ArrayList<BankCard> cards = new ArrayList<BankCard>();

    // #region for debit card
    public int getCardID() {
        int Card = INVALID;
        try {
            Card = Integer.parseInt(textField1.getText().trim());
            if (Card <= 0) {
                Card = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID ERROR" + "\n" + "Please enter valid CardId",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return Card;
    }

    public String getNameOfClient() {
        String Name = textField2.getText();
        return Name;
    }

    public String getBankIssuerInfo() {
        return textField3.getText().trim();
    }

    public String getAccountOfBank() {
        if(textField4.isEmpty()){
            JOptionPane.showMessageDialog(, cards, getAccountOfBank(), INVALID);
        }
        return textField4.getText().trim();
    }

    public double getAmountBalance() {
        int balance = INVALID;
        try {
            balance = Integer.parseInt(textField5.getText().trim());
            if (balance <= 0) {
                balance = INVALID;

            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Card Id",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);

        }
        return balance;
    }

    public int getPinNumber() {
        int pin = INVALID;
        try {
            pin = Integer.parseInt(textField6.getText().trim());
            if (pin <= 0) {
                pin = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Pin Number",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return pin;
    }

    public void addDebit() {
        String clientName = getNameOfClient();
        String issuerBank = getBankIssuerInfo();
        String Account = getAccountOfBank();
        int card = getCardID();
        double balance = getAmountBalance();
        int pin = getPinNumber();

        if (clientName.isEmpty() || issuerBank.isEmpty() || Account.isEmpty()) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Fields cannot be empty",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);

            return;
        }
        if (balance < 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Balance Amount cannot be less than 0", "ERROR MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (card <= 0) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (pin <= 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Pin Number cannot be less than 0",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        if (checkCardIdUnique(card) == true) {
            cards.add(new DebitCard((int) balance, "" + card, Integer.parseInt(Account), issuerBank, clientName, pin));
            JOptionPane.showMessageDialog(null,
                    "DEBIT CARD ADDED!",
                    "Object Added",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "card id should be unique",
                    "Error box", JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean checkCardIdUnique(int cardId) {
        boolean result = true;
        for (BankCard obj : cards) {
            if (obj instanceof DebitCard) {
                DebitCard cards = (DebitCard) obj;
                if (cards.getCardId() == cardId) {
                    result = false;
                }
            }
        }
        return result;
    }

    public boolean checkCreditCardIdUnique(int cardId) {
        boolean result = true;
        for (BankCard obj : cards) {
            if (obj instanceof CreditCard) {
                CreditCard cards = (CreditCard) obj;
                if (cards.getCardId() == cardId) {
                    result = false;
                }
            }
        }
        return result;
    }

    public void displayDebit() {
        for (BankCard obj : cards) {
            if (obj instanceof DebitCard) {
                DebitCard debitCard = (DebitCard) obj;
                debitCard.display();
            }
        }
    }

    public void CreditDisplay() {
        for (BankCard obj : cards) {
            if (obj instanceof CreditCard) {
                CreditCard creditCard = (CreditCard) obj;
                creditCard.display();
            }

        }
    }

    // #endregion

    // #region for credit card
    public int getCreditCardID() {
        int cardid = INVALID;
        try {
            cardid = Integer.parseInt(textField7.getText().trim());
            if (cardid <= 0) {
                cardid = INVALID;

            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID ERROR" + "\n" + "Please enter valid CardId",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return cardid;
    }

    public String getCreditClientName() {
        return textField8.getText().trim();
    }

    public String getCreditIssuerBank() {
        return textField9.getText().trim();
    }

    public String getCreditBankAccount() {
        return textField10.getText().trim();

    }

    public double getCreditBalanceAmount() {
        int balanceAmount = INVALID;
        try {
            balanceAmount = Integer.parseInt(textField11.getText().trim());
            if (balanceAmount < 0) {
                balanceAmount = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Card Id",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return balanceAmount;
    }

    public int getCVCNumber() {
        int CVCNumber = INVALID;
        try {
            CVCNumber = Integer.parseInt(textField12.getText());
            if (CVCNumber < 0) {
                CVCNumber = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid CVC Number",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }

        return CVCNumber;
    }

    public double getInterestRate() {
        double rate = INVALID;
        try {
            rate = Double.parseDouble(textField13.getText());
            if (rate <= 0) {
                rate = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Interest Rate",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }

        return rate;
    }

    public String getExpirationDate() {
        String date = "";
        String year = comboBox6.getSelectedItem().toString();
        String month = comboBox5.getSelectedItem().toString();
        String day = comboBox4.getSelectedItem().toString();

        if (year.equals("YEAR") || month.equals("MONTH") || day.equals("DAY")) {
            date = null;
        } else {
            date = (year + "-" + month + "-" + day);
        }
        return date;
    }

    public void addCredit() {
        String clientName = getCreditClientName();
        String issuerBank = getCreditIssuerBank();
        String Account = getCreditBankAccount();
        int card = getCreditCardID();
        double balance = getCreditBalanceAmount();
        double rate = getInterestRate();
        int CVCNumber = getCVCNumber();
        String expirationDate = getExpirationDate();

        if (clientName.isEmpty() || issuerBank.isEmpty() || Account.isEmpty()) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Fields cannot be empty",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);

            return;
        }

        if (CVCNumber <= 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "CVC Number cannot be less than 1", "ERROR MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (balance < 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Balance Amount cannot be less than 0", "ERROR MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (expirationDate == null) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Enter Valid Expiration Date",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (card <= 0) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (rate <= 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Rate cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (checkCreditCardIdUnique(card) == true) {
            cards.add(new CreditCard(Integer.parseInt(clientName), issuerBank, Account, "" + card, (int) balance,
                    CVCNumber, rate, expirationDate));
            JOptionPane.showMessageDialog(null,
                    "CREDITCARD ADDED" + "\n" + "Client Name: " + clientName + "\n" + "Card ID: " + card
                            + "Issuer Bank: "
                            + issuerBank + "\n" + "Bank Account: " + Account + "\n" + "BalanceAmount: " + balance + "\n"
                            + "CVC Number: " + CVCNumber + "\n" + "Interest Rate: " + rate + "\n" + "Expiration Date: "
                            + expirationDate,
                    "DETAILS OF CARD", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "card id should be unique",
                    "Error box", JOptionPane.ERROR_MESSAGE);
        }
    }

    // #endregion

    // #region for withdrawal
    public int getWCardId() {
        int cardId = INVALID;
        try {
            cardId = Integer.parseInt(textField14.getText().trim());
            if (cardId <= 0) {
                cardId = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Card Id",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return cardId;
    }

    public int getWithdrawAmount() {
        int withdrawamount = INVALID;
        try {
            withdrawamount = Integer.parseInt(textField15.getText().trim());
            if (withdrawamount <= 0) {
                withdrawamount = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid withdrawal amount",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return withdrawamount;
    }

    public int getPinnumber() {
        int pinNumber = INVALID;
        try {
            pinNumber = Integer.parseInt(textField16.getText().trim());
            if (pinNumber <= 0) {
                pinNumber = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Pin Number",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return pinNumber;
    }

    public String getWithdrawalDate() {
        String date = "";
        String year = comboBox3.getSelectedItem().toString();
        String month = comboBox2.getSelectedItem().toString();
        String day = comboBox1.getSelectedItem().toString();

        if (year.equals("YEAR") || month.equals("MONTH") || day.equals("DAY")) {
            date = null;
        } else {
            date = (year + "-" + month + "-" + day);
        }
        return date;
    }

    public void Withdraw() {
        int pinNo = getPinnumber();
        int withdrawAmount = getWithdrawAmount();
        String withdrawalDate = getWithdrawalDate();
        int cardId = getWCardId();

        if (getWithdrawAmount() == INVALID) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Withdraw Amount cannot be less than 1", "ERROR MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (getPinnumber() <= 0) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Pin Number cannot be less than 0",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (getWithdrawalDate() == null) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Enter Valid Withdrawal Date",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (getWCardId() == INVALID) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Enter Valid Card ID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (BankCard obj : cards) {
            if (obj instanceof DebitCard) {
                DebitCard debitCard = (DebitCard) obj;
                if (debitCard.getCardId() == cardId) {
                    debitCard.withdraw(withdrawAmount, Integer.parseInt(withdrawalDate), "" + pinNo);
                    JOptionPane.showMessageDialog(null, "Withdrawal Successful",
                            "Withdraw", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "CARD ID NOT FOUND" + "\n" + "Enter correct Card ID",
                            "NOT FOUND", JOptionPane.WARNING_MESSAGE);
                }

            }
        }

    }

    // #endregion

    // #region for credit limit
    public int getCardid() {
        int cardid = INVALID;
        try {
            cardid = Integer.parseInt(textField17.getText());
            if (cardid <= 0) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
                        "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Card ID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return cardid;
    }

    public double getCreditLimit() {
        double creditLimit = INVALID;
        try {
            creditLimit = Double.parseDouble(textField18.getText());
            if (creditLimit <= 0) {
                creditLimit = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid CreditLimit",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }

        return creditLimit;
    }

    public int getGracePeriod() {
        int graceperiod = INVALID;
        try {
            graceperiod = Integer.parseInt(textField19.getText());
            if (graceperiod <= 0) {
                graceperiod = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid GracePeriod",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return graceperiod;
    }

    public void creditLimit() {
        int cardid = getCardid();
        double creditlimit = getCreditLimit();
        int gracePeriod = getGracePeriod();
        if (cardid == INVALID) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (creditlimit == INVALID) {

            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Credit Limit cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (gracePeriod == INVALID) {

            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Grace Period cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (BankCard obj : cards) {
            if (obj instanceof CreditCard) {
                CreditCard creditCard = (CreditCard) obj;
                if (creditCard.getCardId() == cardid) {
                    creditCard.setCreditLimit((int) creditlimit, gracePeriod);
                    JOptionPane.showMessageDialog(null, "Credit Limit has been set",
                            "Credit Limit", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "CARD ID NOT FOUND" + "\n" + "Enter correct Card ID",
                            "NOT FOUND", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }
    // #endregion

    // #region for cancel credit card
    public int getCancelCardId() {
        int cardId = INVALID;
        try {
            cardId = Integer.parseInt(textField20.getText());
            if (cardId <= 0) {
                cardId = INVALID;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid card Id",
                    "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
        return cardId;
    }

    public void cancelCreditCard() {
        boolean isfound = false;
        int cardID = getCancelCardId();

        for (BankCard obj : cards) {
            if (obj instanceof CreditCard) {
                CreditCard creditCard = (CreditCard) obj;
                if (creditCard.getCardId() == cardID) {
                    isfound = true;
                    creditCard.cancelCreditCard();
                    break;
                }
            }
        }
        if (isfound == true) {
            JOptionPane.showMessageDialog(null, "Canceled credit card", "success box",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panelwithdraw, "cardId doesnt match", "error Box",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public bankGUI() {

        fontbig = new Font(Font.DIALOG, Font.BOLD, 60);
        fontmedium = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20);

        String day[] = { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
        String month[] = { "Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec" };
        String year[] = { "Year", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014",
                "2013" };



        debitPanel = new JPanel();
        debitPanel.setBackground(Color.white);
        debitPanel.setLayout(null);

        firstLabel = new JLabel("Card Id: ");
        firstLabel.setBounds(10, 10, 200, 30);
        firstLabel.setFont(fontmedium);
        debitPanel.add(firstLabel);

        secondLabel = new JLabel("Client Name: ");
        secondLabel.setBounds(10, 50, 200, 30);
        secondLabel.setFont(fontmedium);
        debitPanel.add(secondLabel);

        thridLabel = new JLabel("Issuer Bank: ");
        thridLabel.setBounds(10, 90, 200, 30);
        thridLabel.setFont(fontmedium);
        debitPanel.add(thridLabel);

        fifthLabel = new JLabel("Bank Account: ");
        fifthLabel.setBounds(10, 130, 200, 30);
        fifthLabel.setFont(fontmedium);
        debitPanel.add(fifthLabel);

        sixthLabel = new JLabel("Balance Amount: ");
        sixthLabel.setBounds(10, 170, 200, 30);
        sixthLabel.setFont(fontmedium);
        debitPanel.add(sixthLabel);

        seventhLabel = new JLabel("Pin Number: ");
        seventhLabel.setBounds(10, 210, 200, 30);
        seventhLabel.setFont(fontmedium);
        debitPanel.add(seventhLabel);

        textField1 = new JTextField();
        textField1.setBorder(BorderFactory.createLineBorder(Color.black));
        textField1.setBounds(220, 10, 200, 30);
        debitPanel.add(textField1);

        textField2 = new JTextField();
        textField2.setBorder(BorderFactory.createLineBorder(Color.black));
        textField2.setBounds(220, 50, 200, 30);
        debitPanel.add(textField2);

        textField3 = new JTextField();
        textField3.setBorder(BorderFactory.createLineBorder(Color.black));
        textField3.setBounds(220, 90, 200, 30);
        debitPanel.add(textField3);

        textField4 = new JTextField();
        textField4.setBorder(BorderFactory.createLineBorder(Color.black));
        textField4.setBounds(220, 130, 200, 30);
        debitPanel.add(textField4);

        textField5 = new JTextField();
        textField5.setBorder(BorderFactory.createLineBorder(Color.black));
        textField5.setBounds(220, 170, 200, 30);
        debitPanel.add(textField5);

        textField6 = new JTextField();
        textField6.setBorder(BorderFactory.createLineBorder(Color.black));
        textField6.setBounds(220, 210, 200, 30);
        debitPanel.add(textField6);

        firstButton = new JButton("Add Debit Card");
        firstButton.setBounds(460, 50, 200, 40);
        firstButton.setFont(fontmedium);
        firstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                addDebit();
            }
        });
        debitPanel.add(firstButton);

        secondButton = new JButton("Display");
        secondButton.setBounds(460, 100, 200, 40);
        secondButton.setFont(fontmedium);
        secondButton.addActionListener((e) -> {
                displayDebit();
        });
        debitPanel.add(secondButton);

        third = new JButton("Clear");
        third.setBounds(460, 150, 200, 40);
        third.setFont(fontmedium);
        debitPanel.add(third);
        third.addActionListener((e) -> {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");

        });



      

        creditPanel = new JPanel();
        creditPanel.setBackground(Color.white);
        creditPanel.setLayout(null);

       
        firstLabel = new JLabel("Card ID: ");
        firstLabel.setBounds(10, 10, 200, 30);
        firstLabel.setFont(fontmedium);
        creditPanel.add(firstLabel);

        secondLabel = new JLabel("Client Name: ");
        secondLabel.setBounds(10, 50, 200, 30);
        secondLabel.setFont(fontmedium);
        creditPanel.add(secondLabel);

        thridLabel = new JLabel("Issuer Bank: ");
        thridLabel.setBounds(10, 90, 200, 30);
        thridLabel.setFont(fontmedium);
        creditPanel.add(thridLabel);

        fifthLabel = new JLabel("Bank Account: ");
        fifthLabel.setBounds(10, 130, 200, 30);
        fifthLabel.setFont(fontmedium);
        creditPanel.add(fifthLabel);

        sixthLabel = new JLabel("Balance Amount: ");
        sixthLabel.setBounds(10, 170, 200, 30);
        sixthLabel.setFont(fontmedium);
        creditPanel.add(sixthLabel);

        seventhLabel = new JLabel("CVC Number: ");
        seventhLabel.setBounds(10, 210, 200, 30);
        seventhLabel.setFont(fontmedium);
        creditPanel.add(seventhLabel);

        edithLebel = new JLabel("Interest Rate: ");
        edithLebel.setBounds(10, 250, 200, 30);
        edithLebel.setFont(fontmedium);
        creditPanel.add(edithLebel);

        ninthLabel = new JLabel("Expiration Date: ");
        ninthLabel.setBounds(10, 290, 200, 30);
        ninthLabel.setFont(fontmedium);
        creditPanel.add(ninthLabel);

        textField7 = new JTextField();
        textField7.setBorder(BorderFactory.createLineBorder(Color.black));
        textField7.setBounds(220, 10, 200, 30);
        creditPanel.add(textField7);

        textField8 = new JTextField();
        textField8.setBorder(BorderFactory.createLineBorder(Color.black));
        textField8.setBounds(220, 50, 200, 30);
        creditPanel.add(textField8);

        textField9 = new JTextField();
        textField9.setBorder(BorderFactory.createLineBorder(Color.black));
        textField9.setBounds(220, 90, 200, 30);
        creditPanel.add(textField9);

        textField10 = new JTextField();
        textField10.setBorder(BorderFactory.createLineBorder(Color.black));
        textField10.setBounds(220, 130, 200, 30);
        creditPanel.add(textField10);

        textField11 = new JTextField();
        textField11.setBorder(BorderFactory.createLineBorder(Color.black));
        textField11.setBounds(220, 170, 200, 30);
        creditPanel.add(textField11);

        textField12 = new JTextField();
        textField12.setBorder(BorderFactory.createLineBorder(Color.black));
        textField12.setBounds(220, 210, 200, 30);
        creditPanel.add(textField12);

        textField13 = new JTextField();
        textField13.setBorder(BorderFactory.createLineBorder(Color.black));
        textField13.setBounds(220, 250, 200, 30);
        creditPanel.add(textField13);

        comboBox4 = new JComboBox<>(day);
        comboBox4.setBounds(215, 290, 75, 30);
        creditPanel.add(comboBox4);

        comboBox5 = new JComboBox<>(month);
        comboBox5.setBounds(285, 290, 90, 30);
        creditPanel.add(comboBox5);

        comboBox6 = new JComboBox<>(year);
        comboBox6.setBounds(370, 290, 85, 30);
        creditPanel.add(comboBox6);

        firstButton = new JButton("Add Credit Card");
        firstButton.setBounds(460, 30, 200, 40);
        firstButton.setFont(fontmedium);
        firstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                addCredit();
            }
        });
        creditPanel.add(firstButton);

        secondButton = new JButton("Display");
        secondButton.setBounds(460, 145, 200, 40);
        secondButton.setFont(fontmedium);
        secondButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                CreditDisplay();
            }
        });
        creditPanel.add(secondButton);

        third = new JButton("Clear");
        third.setBounds(460, 260, 200, 40);
        third.setFont(fontmedium);
        third.addActionListener((e) -> {
                textField7.setText("");
                textField8.setText("");
                textField9.setText("");
                textField10.setText("");
                textField11.setText("");
                textField12.setText("");
                textField13.setText("");
                comboBox4.setSelectedIndex(0);
                comboBox5.setSelectedIndex(0);
                comboBox6.setSelectedIndex(0);
        });
        creditPanel.add(third);

    


        panelwithdraw = new JPanel();
        panelwithdraw.setBackground(Color.white);
        panelwithdraw.setLayout(null);

    

        firstLabel = new JLabel("Card ID: ");
        firstLabel.setBounds(10, 15, 200, 30);
        firstLabel.setFont(fontmedium);
        panelwithdraw.add(firstLabel);

        secondLabel = new JLabel("Withdrawal Amount: ");
        secondLabel.setBounds(10, 65, 200, 30);
        secondLabel.setFont(fontmedium);
        panelwithdraw.add(secondLabel);

        thridLabel = new JLabel("Date of Withdrawal: ");
        thridLabel.setBounds(10, 115, 200, 30);
        thridLabel.setFont(fontmedium);
        panelwithdraw.add(thridLabel);

        fifthLabel = new JLabel("Pin Number: ");
        fifthLabel.setBounds(10, 165, 200, 30);
        fifthLabel.setFont(fontmedium);
        panelwithdraw.add(fifthLabel);

        textField14 = new JTextField();
        textField14.setBorder(BorderFactory.createLineBorder(Color.black));
        textField14.setBounds(220, 15, 200, 30);
        panelwithdraw.add(textField14);

        textField15 = new JTextField();
        textField15.setBorder(BorderFactory.createLineBorder(Color.black));
        textField15.setBounds(220, 65, 200, 30);
        panelwithdraw.add(textField15);

        comboBox1 = new JComboBox<>(day);
        comboBox1.setBounds(215, 115, 75, 30);
        panelwithdraw.add(comboBox1);

        comboBox2 = new JComboBox<>(month);
        comboBox2.setBounds(285, 115, 90, 30);
        panelwithdraw.add(comboBox2);

        comboBox3 = new JComboBox<>(year);
        comboBox3.setBounds(370, 115, 85, 30);
        panelwithdraw.add(comboBox3);

        textField16 = new JTextField();
        textField16.setBorder(BorderFactory.createLineBorder(Color.black));
        textField16.setBounds(220, 165, 200, 30);
        panelwithdraw.add(textField16);

        firstButton = new JButton("Withdraw");
        firstButton.setBounds(460, 30, 200, 40);
        firstButton.setFont(fontmedium);
        firstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Withdraw();
            }
        });
        panelwithdraw.add(firstButton);

        third = new JButton("Clear");
        third.setBounds(460, 140, 200, 40);
        third.setFont(fontmedium);
        third.addActionListener((e) -> {
                textField14.setText("");
                textField15.setText("");
                textField16.setText("");
                comboBox1.setSelectedIndex(0);
                comboBox2.setSelectedIndex(0);
                comboBox3.setSelectedIndex(0);
        });
        panelwithdraw.add(third);

      

     
    

        mainFrame = new JFrame("Bank Card GUI");
        mainFrame.setSize(2000, 3000);
        mainFrame.setLayout(new GridLayout(2, 2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        panelwithdraw.setBorder(BorderFactory.createTitledBorder("Title 1"));
        creditPanel.setBorder(BorderFactory.createTitledBorder("Title 2"));
        debitPanel.setBorder(BorderFactory.createTitledBorder("Title 2"));


        panelwithdraw.setBackground(Color.pink);
        creditPanel.setBackground(Color.YELLOW);
        debitPanel.setBackground(Color.GREEN);
        mainFrame.add(panelwithdraw);
        mainFrame.add(creditPanel);
        mainFrame.add(debitPanel);

    }

    public static void main(String[] args) {
        BankGUI obj = new BankGUI();
    }

}