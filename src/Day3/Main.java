package Day3;
class Main{
    public static void main(String[] args){
        Main atm = new Main();
        try {
            atm.withdraw(500);
            atm.withdraw(2000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    int balance = 1000;

    void withdraw(int amount) throws Exception {
        if(amount>balance){
            throw new Exception("Insufficient Balanace ");
        }
        balance-=amount;
        System.out.println("Withdrawal successful");
        System.out.println("Remaining balance: " + balance);

    }


}
