package payments;

import java.util.HashMap;

public class Nequi extends PaymentMethod{
    public Nequi(HashMap<Long, BankCard> availableCards) {
        super(availableCards);
    }
}
