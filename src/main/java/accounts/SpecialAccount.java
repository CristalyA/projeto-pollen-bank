package accounts;

public class SpecialAccount extends Account{

    private double specialLimit = 1000.0;

    public SpecialAccount(int numberAccount, String customerName, String cpf) {
        super(numberAccount, customerName, cpf);
    }

    @Override
    public void debit(double value){
        if(value <= 0 ){
            System.out.println("Valor inválido!");
        } else if (value <= balance){
            System.out.println("");
            double balance;
            balance = super.getBalance();
            
            balance -= value;
            super.debit(value);
        } else if (value <= getBalance() + getSpecialLimit()) {
            System.out.println("Saldo insuficiente para realizar a transação.");
            System.out.println("Está sendo usado " +(value -getBalance())+"do limite especial.");
            if(value >0 ){
                specialLimit -= (value - getBalance());
                if(getBalance() > 0){
                    super.debit(getBalance());
                }
            }else {
                System.out.println("Limite insuficiente!");
            }
        } else if( getSpecialLimit() == 0 ){
            System.out.println("Limite especial totalmente utilizado! ");
        }
        System.out.println("Limite atual é R$ "+getSpecialLimit());
        performOperation();
    }

    public double getSpecialLimit() {
        return specialLimit;
    }
}
