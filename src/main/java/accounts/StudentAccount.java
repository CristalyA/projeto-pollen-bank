package accounts;

import java.util.Scanner;

public class StudentAccount extends Account{

    Scanner input = new Scanner(System.in);

    private double maximumStudentValue = 5000.00;
    private char useLoan;


    public StudentAccount(int accountNumber, String customerName , String cpf){
        super(accountNumber,customerName, cpf);
    }

    public void loanMenu(){
        double requestValue = 0;
        char useLoan;
        System.out.println("Caro estudante, você tem R$ "+maximumStudentValue+" liberados para emprestimo pessoal.");
        System.out.println("Realizar emprestimo (S/N) ?");
        useLoan = input.next().toUpperCase().charAt(0);

        if(useLoan == 'S'){
            System.out.println("Valor do emprestimo: R$ ");
            requestValue = input.nextDouble();
            if ( requestValue <= maximumStudentValue){
                credit(requestValue);
                if(requestValue > 0){
                    maximumStudentValue -= requestValue;
                } else  {
                    System.out.println("Valor invalido. Transição não concluida!");
                }
            } else {
                System.out.println("O valor solicitado é maior que o disponível!");
            }
        }
        super.showBalance();

    }

    public double getMaximumStudentValue() {
        return maximumStudentValue;
    }

    public char getUseLoan() {
        return useLoan;
    }
}
