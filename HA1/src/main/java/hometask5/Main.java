package hometask5;

public class Main {
    public static void main(String[] args) {
        CreditCard card1 = new CreditCard("4520 5896 2569 8741");
        CreditCard card2 = new CreditCard("4520 5896 2569 5269");
        CreditCard card3 = new CreditCard("4520 5896 2569 5269", 3000);

        card1.addToBalance(5000);
        card2.addToBalance(8000);
        card3.withdrawFromBalance(1000);

        card1.cardInformation();
        card2.cardInformation();
        card3.cardInformation();

        ATMBuilder atm = new ATMBuilder(10,1,0);
        atm.addBanknotes(Integer.parseInt(BanknotesNominal.TWENTY.getTitle()), 30);
        atm.addBanknotes(Integer.parseInt(BanknotesNominal.FIFTY.getTitle()), 20);
        atm.addBanknotes(Integer.parseInt(BanknotesNominal.HUNDRED.getTitle()), 20);

        atm.withdrawCash(atm.nominals(), 3090);


    }
}
