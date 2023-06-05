package payments;

import java.util.HashMap;

public class PaymentMethod {
    private final HashMap<Long, BankCard> availableCards;
    public PaymentMethod(HashMap<Long, BankCard> availableCards){
        this.availableCards = availableCards;
    }
    public PaymentMethod(){
        availableCards = new HashMap<>();
    }
    public BankCard bankCard(long number){
        return availableCards.get(number);
    }
}
