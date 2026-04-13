package model;

public class Registro {

    private int campo1;
    private String campo2;
    private int campo3;
    private String campo4;
    private String campo5;
    private String campo6;
    private String campo7;
    private String campo8;
    private String campo9;
    private String campo10;
    private String campo11;
    private int campo12;

    public Registro(int total) {
        this.campo1 = total;
        this.campo2 = "CONTEO XML";
        this.campo3 = total * 2;
        this.campo4 = "A";
        this.campo5 = "B";
        this.campo6 = "C";
        this.campo7 = "D";
        this.campo8 = "E";
        this.campo9 = "F";
        this.campo10 = "G";
        this.campo11 = "H";
        this.campo12 = total;
    }

    // getters :. . / .

    public int getCampo1() {
        return campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public int getCampo3() {
        return campo3;
    }

    public String getCampo4() {
        return campo4;
    }

    public String getCampo5() {
        return campo5;
    }

    public String getCampo6() {
        return campo6;
    }

    public String getCampo7() {
        return campo7;
    }

    public String getCampo8() {
        return campo8;
    }

    public String getCampo9() {
        return campo9;
    }

    public String getCampo10() {
        return campo10;
    }

    public String getCampo11() {
        return campo11;
    }

    public int getCampo12() {
        return campo12;
    }
}
