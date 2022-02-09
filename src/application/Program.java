package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialB = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double limit = sc.nextDouble();
			Account accont = new Account(number, name, initialB, limit);
			
			System.out.print("\nEnter amount for withdraw: ");
			double withdraw = sc.nextDouble();
			accont.withdraw(withdraw);
			System.out.println("New balance: " + String.format("%.2f", accont.getBalance()));
		}
		catch(BusinessExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}
}
