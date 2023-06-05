package payments;

import java.util.HashMap;

public class Itau extends PaymentMethod{
    public Itau(HashMap<Long, BankCard> availableCards) {
        super(availableCards);
    }
}
