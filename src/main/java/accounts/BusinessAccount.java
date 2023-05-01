package accounts;

import java.util.Scanner;

public class BusinessAccount extends Account{

    Scanner input = new Scanner(System.in);

    private double maximumValue = 10000.00;
    private double loanAmount;
    private char acceptLoan = 'N';

    public BusinessAccount(int accountNumber, String customerName, String cpf){
        super(accountNumber,customerName,cpf);
    }

    public void makeLoan(){
        System.out.println("Você tem R$ "+ maximumValue +" liberados para emprestimo.");
        System.out.println("Deseja utilizar (S/N) ?");
        acceptLoan = input.next().charAt(0);

        if (acceptLoan == 'S' || acceptLoan == 's'){
            System.out.println("Valor do emprestimo: R$");
            loanAmount = input.nextDouble();

            if(loanAmount > maximumValue){
                System.out.println("Valor indisponível!\nTenter novamente :");
            }

            if(loanAmount <= maximumValue){
                super.credit(loanAmount);
                if(loanAmount > 0){
                    maximumValue -= loanAmount;
                } else {
                    System.out.println("Valor invalido. Emprestimo não concluido.");
                }
            }
        }
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public char getAcceptLoan() {
        return acceptLoan;
    }

    public void setAcceptLoan(char acceptLoan) {
        this.acceptLoan = acceptLoan;
    }
}
