package hometask5;

public enum BanknotesNominal {
    HUNDRED("100"),
    FIFTY("50"),
    TWENTY("20");

    private String title;

    BanknotesNominal(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}

