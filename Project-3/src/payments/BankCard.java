package payments;

public class BankCard {
    public final long number;
    private final short password;
    public BankCard(long number, short password){
        this.number = number;
        this.password = password;
    }
    public boolean pay(short password){
        return password == this.password;
    }
}
