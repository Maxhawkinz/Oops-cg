import java.util.InputMismatchException;
import java.util.Scanner;
class ATM1
{
    double balance;
ATM(double initialization)
{
    this.balance=initialization;

}
double checkbalance()
{
    return balance;
}

void withdraw(double amount)
{
    if(amount<=0)
    {
        throw new IllegalArgumentException("Amount should be positive");
    }
    if(amount>balance)
    {
        throw new ArithmeticException("Insufficient balance");
    }
    balance = balance - amount;
    System.out.println("Withdrawal amount is successful. Withdraw amount is $"+amount);
    
}
void deposit(double amount)
{
    if(amount<=0)
    {
      throw new IllegalArgumentException("Deposit amount should be positive");

    }
    balance = balance + amount;
    System.out.println("Deposit amount is successful. Deposit amount is $"+amount);
}


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ATM a1 = new ATM(1000);
        boolean exit = false;
        while(!exit)
        {
            System.out.println("----ATM MENU----");
            System.out.println("1.Check Balance");
            System.out.println("2.Withdraw Amount");
            System.out.println("Deposit Amount");
            System.out.println("Exit");
            System.out.println("Choose an option");

            
      
            
       // }
        try
        {
            int choice = scanner.nextInt();
switch (choice)
{
case 1:
System.out.printf("Your current balance is: $%.2f%n", a1.checkbalance());
break;
case 2:
System.out.print("Enter amount to withdraw: ");
double withdrawAmount = scanner.nextDouble();
a1.withdraw(withdrawAmount);
break;
case 3:
System.out.print("Enter amount to deposit: ");
double depositAmount = scanner.nextDouble();
a1.deposit(depositAmount);
break;
case 4:
System.out.println("Thank you for using the ATM. Goodbye!");
exit = true;
break;
default:
System.out.println("Invalid option. Please select between 1-4.");
}

}
       
        
    
     catch (ArithmeticException e) {
        System.out.println("Error : "+e.getMessage());
            
        }
         catch (IllegalArgumentException e) {
        System.out.println("Invalid input : "+e.getMessage());
            
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid Input type. PLease enter numeric values");
            scanner.nextLine();
        }
        finally
        {
            System.out.println("Transaction complete");
        }
        // scanner.close();
        }
      //  sc.close();
    }
}
