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

    public int getNumberOfBanknotes50() {
        return numberOfBanknotes50;
    }
    public int getNumberOfBanknotes100() {
        return numberOfBanknotes100;
    }

    public void setNumberOfBanknotesByNominal(int nominal, int notesNumber) {
        switch (nominal){
            case 100 -> {this.numberOfBanknotes100 = notesNumber;}
            case 50 -> {this.numberOfBanknotes50 = notesNumber;}
            case 20 -> {this.numberOfBanknotes20 = notesNumber;}
        }
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
    public int amountOfMoneyInAtm() {
        int amount = getNumberOfBanknotes100() * 100 + getNumberOfBanknotes50() * 50 + getNumberOfBanknotes20() * 20;
        return amount;
    }
    public void addBanknotes(int nominal, int additionalOfBanknotes) {
        switch (nominal) {
            case 20 -> {numberOfBanknotes20 = getNumberOfBanknotes20() + additionalOfBanknotes;}
            case 50 -> {numberOfBanknotes50 = getNumberOfBanknotes50() + additionalOfBanknotes;}
            case 100 -> {numberOfBanknotes100 = getNumberOfBanknotes100() + additionalOfBanknotes;}
        }
    }
//метод для составления массива чисел, соответствующих существующим номиналам банкнот
    public int [] nominals(){
        BanknotesNominal [] nominals = BanknotesNominal.values();
        int [] allNominals = new int[nominals.length];
        for (int i = 0; i < nominals.length; i++) {
            allNominals[i] = Integer.parseInt(nominals[i].getTitle());
        }
        return allNominals;
    }

    //метод для получения количества банкнот в разрезе по номиналам
    public int [] notesNumber(int [] notes){
        int [] notesNumber = new int[notes.length];
        for (int i = 0; i < notes.length; i++) {
            notesNumber[i] = getNumberOfBanknotesByNominal(notes[i]);
        }
        return notesNumber;
    }
//вывод на экран отчета о количестве выданных купюр в разрезе по номиналам
    public void displayResult(int[] countBanknotes, int []allNominals){
        for (int i = 0; i < countBanknotes.length; i++) {
            if(countBanknotes[i]!=0){
                System.out.println("Выдано " + countBanknotes[i] + " купюр номиналом " + allNominals[i] + " рублей.");
            }
        }
    }

    public boolean withdrawCash(int []allNominals, int sum) {
        int[] countBanknotes = new int[allNominals.length];
        int[] notesNumber = notesNumber(allNominals);
        if (sum <= amountOfMoneyInAtm()){
            int countNotes = 0;
            for (int i = 0; i < allNominals.length; i++) {
                if (allNominals[i] <= sum){

                    while (sum>=allNominals[allNominals.length-1]){
                        countNotes = sum/allNominals[i];
                        countBanknotes[i] = Math.min(countNotes, notesNumber[i]);
                        sum = sum - (countBanknotes[i] * allNominals[i]);
                        setNumberOfBanknotesByNominal(allNominals[i], notesNumber[i]-countBanknotes[i]);
                        i++;
                    }
                    if(sum>0){
                        sum = sum + (allNominals[allNominals.length-1-1]*countBanknotes[allNominals.length-1-1])+(allNominals[allNominals.length-1]*countBanknotes[allNominals.length-1]);
                        countBanknotes[allNominals.length-1-1] = 0;
                        countNotes = sum/allNominals[allNominals.length-1];
                        countBanknotes[allNominals.length-1] = Math.min(countNotes, notesNumber[allNominals.length-1]);
                        sum = sum - (countBanknotes[allNominals.length-1] * allNominals[allNominals.length-1]);
                        setNumberOfBanknotesByNominal(allNominals[allNominals.length-1], notesNumber[allNominals.length-1]-countBanknotes[allNominals.length-1]);
                    }

                }
            }
            if(sum>0) {
                System.out.println("Банкомат не может выдать запрашиваемую сумму.");
                return false;
            }else {
                displayResult(countBanknotes, allNominals);
            }
        } else{
            System.out.println("Банкомат не может выдать запрашиваемую сумму.");
            return false;
        }
        return true;
    }

}