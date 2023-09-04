import java.util.Scanner;
class ATM{
    String password = "1234";
    float balance=25000f;
    int transactions=0;
    String transactionHistory="";

    public boolean login() {
        boolean isLogin=false;
        Scanner sc=new Scanner(System.in);
        while(!isLogin) {
            System.out.println("Enter your Password:");
            String Password=sc.nextLine();
            if(Password.equals(password)) {
                System.out.println("Login Succeessful!");
                isLogin=true;
            }
            else {
                System.out.println("Incorrect Password");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.println("Enter Amount to withdraw:");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        try {
            if(balance>=amount) {
                transactions++;
                balance=balance-amount;
                System.out.println("\nAmount Withdrawn Successfully!");
                String str=amount+"Rs Withdrawned\n";
                transactionHistory=transactionHistory.concat(str);
            }
            else {
                System.out.println("\nInsufficient Balance!");
            }
        }
        catch(Exception e) {}
    }

    public void deposit() {
        System.out.print("\nEnter Amount to Deposit:");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        try {
            if(amount<=1000000f) {
                balance=balance+amount;
                System.out.println("\nAmount Deposited Successfully!");
                String str=amount+"Rs Deposited\n";
                transactionHistory=transactionHistory.concat(str);
            }
            else {
                System.out.println("Sorry limit is 1000000 Rs only");
            }
        }
        catch(Exception e){}
    }

    public void transfer() {
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter Reciepent's Name:");
        String Reciepent=sc.nextLine();
        System.out.print("\nEnter Amount to tranfer:");
        float amount=sc.nextFloat();
        try {
            if(balance>=amount) {
                if(amount<=50000f) {
                    transactions++;
                    balance=balance-amount;
                    System.out.println("\nSuccessfully tranfered to the reciepent " +Reciepent);
                    String str=amount+"Rs Transferred to " +Reciepent+"\n";
                    transactionHistory=transactionHistory.concat(str);
                }
                else {
                    System.out.println("\nSorry Limit is 50000.0");
                }
            }
            else {
                System.out.println("\nInsufficient Balance");
            }
        }
        catch (Exception e) {}
    }

    public void checkBalance() {
        System.out.println("\n"+balance+"Rs");
    }

    public void History() {
        if(transactions==0) {
            System.out.println("\nEmpty");
        }

        else {
            System.out.println("\n"+transactionHistory);
        }
    }
}

public class ATM_Interface {
    public static int takeIntegerInput(int limit) {
        int input=0;
        boolean flag=false;
        while(!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if(flag && input >limit || input<1) {
                    System.out.println("choose the number between 1 to"+limit);
                    flag=false;
                }
            }
            catch(Exception e) {
                System.out.println("Enter only integer value");
                flag=false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("1.ATM1\n2.Exit");
        System.out.print("Enter your Choice:");
        int option = takeIntegerInput(2);
        if(option==1) {
            ATM obj = new ATM();
            while(true)
            {
                System.out.println("1.Login \n2.Quit");
                System.out.print("Enter your choice:");
                int ch=takeIntegerInput(2);
                if(ch == 1)
                {
                    if(obj.login())
                    {
                        boolean isFinished=false;
                        while(!isFinished)
                        {
                            System.out.println("\n 1.Deposit \n 2.Withdraw \n 3.Transfer \n 4.Check balnce \n 5.Transaction history \n 6.Quit");
                            System.out.print("\nEnter Your Choice:");
                            int opt=takeIntegerInput(6);
                            switch (opt) {
                                case 1 -> {
                                    obj.deposit();
                                }
                                case 2 -> {
                                    obj.withdraw();
                                }
                                case 3 -> {
                                    obj.transfer();
                                }
                                case 4 -> {
                                    obj.checkBalance();
                                }
                                case 5 -> {
                                    obj.History();
                                }
                                case 6 -> {
                                    isFinished = true;
                                }
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }
}

