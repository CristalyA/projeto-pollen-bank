package accounts;

public class CheckingAccount extends Account{

    private final int MAXIMO_CHECKBOOK= 3;
    private int checkbook;
    private final int CHECKBOOK_PRICE = 30;

    public CheckingAccount(int accountNumber, String customerName ,String cpf){
        super(accountNumber,customerName, cpf);
    }

    public void askCheckbook(char choice){
        if(choice == 'S' && canCheckbook()){
            checkbook++;
            super.debit(getCHECKBOOK_PRICE());
            System.out.println("Debitando da conta!");
            System.out.println("Operação realizada com sucesso !");
            super.showBalance();
        }

    }

    public boolean canCheckbook(){
        return getCHECKBOOK_PRICE() <= super.getBalance() && getCheckbook() < getMAXIMO_CHECKBOOK();
    }


    public int getMAXIMO_CHECKBOOK() {
        return MAXIMO_CHECKBOOK;
    }

    public int getCheckbook() {
        return checkbook;
    }

    public void setCheckbook(int checkbook) {
        this.checkbook = checkbook;
    }

    public double getCHECKBOOK_PRICE() {
        return CHECKBOOK_PRICE;
    }
}
