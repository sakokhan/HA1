package hometask5;

public class ATMBuilder {
    private int numberOfBanknotes20;
    private int numberOfBanknotes50;
    private int numberOfBanknotes100;
    public ATMBuilder(int numberOfBanknotes20, int numberOfBanknotes50, int numberOfBanknotes100) {
        this.numberOfBanknotes20 = numberOfBanknotes20;
        this.numberOfBanknotes50 = numberOfBanknotes50;
        this.numberOfBanknotes100 = numberOfBanknotes100;
    }

    public int getNumberOfBanknotes20() {
        return numberOfBanknotes20;
    }

    public void setNumberOfBanknotes20(int numberOfBanknotes20) {
        this.numberOfBanknotes20 = numberOfBanknotes20;
    }

    public int getNumberOfBanknotes50() {
        return numberOfBanknotes50;
    }

    public void setNumberOfBanknotes50(int numberOfBanknotes50) {
        this.numberOfBanknotes50 = numberOfBanknotes50;
    }

    public int getNumberOfBanknotes100() {
        return numberOfBanknotes100;
    }
    public void setNumberOfBanknotes100(int numberOfBanknotes100) {
        this.numberOfBanknotes100 = numberOfBanknotes100;
    }
    public int getNumberOfBanknotesByNominal(int nominal) {
        int NumberOfBanknotes = 0;
        switch (nominal) {
            case 100 -> {NumberOfBanknotes = getNumberOfBanknotes100();}
            case 50 -> {NumberOfBanknotes = getNumberOfBanknotes50();}
            case 20 -> {NumberOfBanknotes = getNumberOfBanknotes20();}
        }
        return NumberOfBanknotes;
    }
    public void setNumberOfBanknotesByNominal(int nominal) {
        switch (nominal) {
            case 100 -> {setNumberOfBanknotes100(nominal);}
            case 50 -> {setNumberOfBanknotes50(nominal);}
            case 20 -> {setNumberOfBanknotes20(nominal);}
        }
    }
    public int amountOfMoneyInAtm() {
        int amount = getNumberOfBanknotes100() * 100 + getNumberOfBanknotes50() * 50 + getNumberOfBanknotes20() * 20;
        return amount;
    }

    public void addBanknotes(int nominal, int additionalOfBanknotes) {
        switch (nominal) {
            case 20 -> {
                numberOfBanknotes20 = getNumberOfBanknotes20() + additionalOfBanknotes;
            }
            case 50 -> {
                numberOfBanknotes50 = getNumberOfBanknotes50() + additionalOfBanknotes;
            }
            case 100 -> {
                numberOfBanknotes100 = getNumberOfBanknotes100() + additionalOfBanknotes;
            }
        }
    }

    public boolean isSuccessfulOperation(int sum) {

        if (amountOfMoneyInAtm() < sum) {
            System.out.println("Недостаточно средств. Уменьшите запрашиваемую сумму.");
            return false;
        } else if (sum >= 20 && sum % 10 == 0 && sum!=30){
            BanknotesNominal[] nominals = BanknotesNominal.values();
            int[] countBanknotes = new int[nominals.length];
            int nom = 0;
            for (int i = 0; i < countBanknotes.length; i++) {
                if(sum==60 || sum==80){
                    nom = Integer.parseInt(nominals[countBanknotes.length-1].getTitle());
                    countBanknotes[countBanknotes.length-1] = Math.min(sum / nom, getNumberOfBanknotesByNominal(nom));
                    sum = sum - (countBanknotes[countBanknotes.length-1] * nom);
                    break;
                }else {
                    nom = Integer.parseInt(nominals[i].getTitle());
                    countBanknotes[i] = Math.min(sum / nom, getNumberOfBanknotesByNominal(nom));
                    sum = sum - (countBanknotes[i] * nom);
                }
            }
            if(sum>0){System.out.println("Банкомат выдает купюры номиналом: 100, 50 или 20 руб. Отсутствуют купюры требуемого номинала. Скорректируйте запрашиваемую сумму.");
                return false;
            }else {
                for (int i = 0; i < countBanknotes.length; i++) {
                    if (countBanknotes[i] > 0) {
                        System.out.println("Выдано " + countBanknotes[i] + " купюр номиналом " + Integer.parseInt(nominals[i].getTitle()) + " рублей.");
                    }
                    switch (nominals[i]) {
                        case HUNDRED -> {setNumberOfBanknotes100(getNumberOfBanknotes100() - countBanknotes[i]);}
                        case FIFTY -> {setNumberOfBanknotes50(getNumberOfBanknotes50() - countBanknotes[i]);}
                        case TWENTY -> {setNumberOfBanknotes20(getNumberOfBanknotes20() - countBanknotes[i]);}
                    }
                }
            }

        } else{
            System.out.println("Банкомат выдает купюры номиналом: 100, 50 или 20 руб. Скорректируйте запрашиваемую сумму.");
            return false;
        }
        return true;
    }

}