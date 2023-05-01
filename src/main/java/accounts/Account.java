package accounts;

import java.util.LinkedList;
import java.util.List;

public abstract class Account {

    protected double balance;
    private int accountNumber;
    private String customerName;
    private String cpf;

    private boolean active = true;
    private int operationsAccountant;
    private List<String> extract = new LinkedList<>();

    public Account(int accountNumber, String customerName,String cpf) {
        super();
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.cpf = cpf;

    }

    public void debit (double value){
        if(value <= 0){
            System.out.println("Valor inválido!");
        } else if(value <= this.balance){
            this.balance -= value;
            this.extract.add("Débito:\tR$ -"+ value);
        } else {
            System.out.println("Saldo Insuficiente!");
        }
        performOperation();
    }
    public void credit (double value){
        if (value <= 0) {
            System.out.println("Valor inválido!");
        } else{
            this.balance += value;
            this.extract.add("Crédito:\tR$ "+value);
        }
        performOperation();
    }

    public void printExtract(){
        int i =0;
        for (String operations : extract){
            i++;
            System.out.println(i+":"+operations);
        }
        showBalance();
    }

    public void showBalance(){
        System.out.println("Saldo atual: R$ "+ this.getBalance());
    }
    public void performOperation(){
        this.operationsAccountant++;
        showBalance();
    }

    public int getOperationsAccountant(){
        return operationsAccountant;
    }


    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }
}