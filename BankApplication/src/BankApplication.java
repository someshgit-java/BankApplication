import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		BankAccount obj=new BankAccount("XYZ","B100001");
		obj.showMenu();
	}
}

class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname,String cid){
		String customerName=cname;
		String customerId=cid;
	}
	
	void deposit(int amount) {
		if(amount !=0) {
			balance=balance+amount;
			previousTransaction=balance-amount;
		}
	}
	void withdraw(int amount) {
		if(amount !=0) {
			balance=balance-amount;
			previousTransaction=-amount;
		}
	}
	void getpreviousTransaction() {
		if(previousTransaction >0) {
			System.out.println("Deposited:"+previousTransaction);
		}else if(previousTransaction <0) {
			System.out.println("Withdraw:"+Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction Occured");
		}	
	}
	
	void showMenu() {
		char option='\0';
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Welcome "+customerName);
		System.out.println("Your id is"+customerId);
		System.out.println("\n");
		
		System.out.println("A :Check your Balance");
		System.out.println("B :Deposit");
		System.out.println("C :Withdraw");
		System.out.println("D :previous Transaction");
		System.out.println("E :Exit");
		
		do {
			System.out.println("----------------------------------------------------");
			System.out.println("Enter an Option");
			System.out.println("----------------------------------------------------");
			option=scn.next().charAt(0);
		    System.out.println("\n");
		    
		    switch(option) {
		    
		    case 'A':
		    	System.out.println("---------------------------------------------------");
		    	System.out.println("Balance="+balance);
		    	System.out.println("---------------------------------------------------");
		    	System.out.println("\n");
		    	break;
		    	
		    case 'B':
		    	System.out.println("---------------------------------------------------");
		    	System.out.println("Enter an Amount to deposit");
		    	System.out.println("---------------------------------------------------");
		    	int amount=scn.nextInt();
		    	deposit(amount);
		    	System.out.println("\n");
		    	break;
		    	
		  case 'C':
			  System.out.println("-------------------------------------------------------");
			  System.out.println("Enter an Amount to Withdraw");
			  System.out.println("-------------------------------------------------------");
			  int amount2=scn.nextInt();
			  withdraw(amount2);
			  System.out.println("\n");
			  break;
			  
		  case 'D':
			  System.out.println("------------------------------------------------------ ");
			  getpreviousTransaction();
			  System.out.println("-------------------------------------------------------");
			  System.out.println("\n");
			  break;
			  
		default:
			System.out.println("Invalid Option Please Try Again");
			break;	  
		    }
		}while(option!='E');
		System.out.println("Thank You For Using Our Service");
		
	}
	
}
