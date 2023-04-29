package accounts;

import java.text.DecimalFormat;

public class SavingsAccount extends Account{

    private final int birthdaySavings = 12;

    public SavingsAccount (int numberAccount, String customerName, String cpf){
        super(numberAccount,customerName, cpf);
    }

    public void adjustBalance(){
        double balances, adjustment;
        adjustment = 0.05*super.getBalance();
        balances = super.getBalance()+adjustment;
        System.out.println("Hojé é aniversário da sua conta.");
        System.out.println("\nTemos um presente para você !");
        System.out.println("\nSaldo R$ "+new DecimalFormat("0.00").format(balances));
        super.credit(adjustment);
    }

    public int getBirthdaySavings() {
        return birthdaySavings;
    }
}
