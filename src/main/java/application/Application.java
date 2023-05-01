package application;

import accounts.*;
import menu.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;



public class Application {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        char op;
        double value = 0 ;
        int choice,numberAccount ;
        String name , cpf = null;

        Bank.showLogo();

        System.out.println("Olá pessoa seja bem vinda ! \nQual seu nome? ");
        name = input.next().toUpperCase();

        System.out.println("Qual o número da sua conta (5 digítos) ?");
        numberAccount = input.nextInt();

        while (numberAccount < 10000 || numberAccount > 99999){
            System.out.println("Numero da conta incorreto.\nTente novamente !");
            System.out.println("Digite os 5 dígitos do número da sua conta :");
            numberAccount = input.nextInt();
        }

        System.out.println("Qual o número do seu cpf (Somente digitos - 11 digitos) ?");
        cpf = input.next();


//        while (numberAccount > 10000 || numberAccount > 99999){
//            System.out.println("Numero da conta incorreto.\nTente novamente !");
//            System.out.println("Digite os 5 dígitos do número da sua conta :");
//            numberAccount = input.nextInt();
//        }

        while (cpf.length() != 11){
        System.out.println("Numero dp cpf incorreto.\nTente novamente !");
        System.out.println("Digite os 11 digitos do seu cpf: ");
        cpf = input.next();
        }


        SavingsAccount savingsAccount = new SavingsAccount(numberAccount, name, cpf);
        CheckingAccount checkingAccount = new CheckingAccount(numberAccount,name, cpf);
        SpecialAccount specialAccount = new SpecialAccount(numberAccount, name,cpf);
        BusinessAccount businessAccount = new BusinessAccount(numberAccount,name, cpf);
        StudentAccount studentAccount  = new StudentAccount(numberAccount,name,cpf);

        List<Account> accounts = new ArrayList<>();
        accounts.add(savingsAccount);
        accounts.add(checkingAccount);
        accounts.add(specialAccount);
        accounts.add(businessAccount);
        accounts.add(studentAccount);

        List<String> accountNames = new ArrayList<>();

        accountNames.add("\nCONTA POUPANÇA");
        accountNames.add("\nCONTA CORRENTE");
        accountNames.add("\nCONTA ESPECIAL");
        accountNames.add("\nCONTA EMPRESARIAL");
        accountNames.add("\nCONTA ESTUDANTIL");

        do {
            do {

                Bank.showLogo();
                System.out.println("Olá "+name+ " seja bem vinda (o) !");
                System.out.println("1 - CONTA POUPANÇA");
                System.out.println("2 - CONTA CORRENTE");
                System.out.println("3 - CONTA ESPECIAL");
                System.out.println("4 - CONTA EMPRESARIAL");
                System.out.println("5 - CONTA ESTUDANTIL");
                System.out.println("6- SAIR \n");
                System.out.println("DIGITE O CODIGO DA OPÇÃO DESEJADA:");
                choice = input.nextInt();
                if(choice< 1 || choice >6 ){
                    System.out.println("Opção invalida ! \nTente novamente");
                }
                if(choice == 6){
                    break;
                }

            } while (choice<1 || choice > 6);
            if(choice == 6){
                break;
            }
            choice--;

            do {
                Bank.showLogo();
                System.out.println(accountNames.get(choice));
                System.out.println("MOVIMENTAÇÕES : \nD- Débito \nC- Crédito \nE- Extrato");
                op = input.next().toUpperCase().charAt(0);

                if(op == 'D'){
                    System.out.println("Debitar: R$");
                    value = input.nextDouble();
                    accounts.get(choice).debit(value);

                } else if (op =='C'){
                    System.out.println("Creditar: R$");
                    value = input.nextDouble();
                    accounts.get(choice).credit(value);

                } else if (op == 'E' ){
                    System.out.println("Extrato: ");
                    accounts.get(choice).printExtract();

                } else {
                    System.out.println("Opção inválida");
                }

                // Savings Account

                if (choice == 0){
                    while (true){
                        if (value >0 && op != 'E' && savingsAccount.getBalance() >= value){
                            int requestDate;
                            System.out.println("Informe o dia: ");
                            requestDate = input.nextInt();

                            if (requestDate <= 0 || requestDate > 31){
                                System.out.println("Dia inválido !");
                            } else if (requestDate == savingsAccount.getBirthdaySavings()) {
                                savingsAccount.adjustBalance();
                                break;
                            } else {
                                savingsAccount.showBalance();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                // END SAVINGS

                // BUSINESS ACCOUNT
                if (choice == 3 ){
                    businessAccount.makeLoan();
                }
                // END

                // STUDENT ACCOUNT
                if (choice == 4){
                    studentAccount.loanMenu();
                }

                //END

                System.out.println("Deseja continua ? (S/N)");
                op = input.next().toUpperCase().charAt(0);


                while (op != 'N' && op != 'S' ){
                    System.out.println("Opção inválida !");
                    System.out.println("Deseja continuar ? (S/N)");
                    op = input.next().toUpperCase().charAt(0);
                }

            } while (op == 'S'  && accounts.get(choice).getOperationsAccountant()<10);

            // CHECKING ACCOUNT

            if(choice == 1 && checkingAccount.canCheckbook()){
                char askCheckbook = 'S';
                while ( askCheckbook == 'S' && checkingAccount.canCheckbook()){
                    askCheckbook = 'N';
                    System.out.println("\nTALÕES DE CHEQUE");
                    System.out.println("\nTalões pedidos: "+checkingAccount.getCheckbook()+"\nLimites de talão no mês é: "+checkingAccount.getMAXIMO_CHECKBOOK());
                System.out.println("\nCusto R$:" +checkingAccount.getCHECKBOOK_PRICE());
                    System.out.println("Gostaria de comprar o talão de cheque ? (S/N)");
                    askCheckbook = input.next().toUpperCase().charAt(0);
                    checkingAccount.askCheckbook(askCheckbook);
                }

                // END CHECKING ACCOUNT
            }

        }while (true);

        Bank.by();

    }

}
