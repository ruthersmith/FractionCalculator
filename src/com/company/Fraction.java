package com.company;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = checkDenominator(denominator);
        accountForNegative(numerator,denominator);
    }

    public Fraction(int numerator){
        this(numerator,1);
    }

    public Fraction(){
        this(0,1);
    }

    private int checkDenominator(int denominator){
        if (denominator == 0){
            throw new IllegalArgumentException ();
        }
        return denominator;
    }
    private void  accountForNegative(int numerator, int denominator){
        if (numerator < 0 && denominator < 0){
            this.numerator = Math.abs(numerator);
            this.denominator = Math.abs(denominator);
        }else if(denominator < 0){
            this.numerator = numerator * -1;
            this.denominator = Math.abs(denominator);
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble(){
        return (numerator * 1.0) /denominator;
    }

    private void makeCommonDenominator(Fraction other){
        if (!(this.denominator == other.getDenominator())){
            int oldden = this.denominator;
            this.denominator *= other.denominator;
            this.numerator *= other.denominator;
            other.denominator *= oldden;
            other.numerator *= oldden;
        }
    }

    private Fraction addOrSubtract(Fraction other, String command){
        Fraction fraction = null;
        makeCommonDenominator(other);

        if (this.denominator == other.getDenominator()){
            if ("add".equals(command)){
                fraction =  new Fraction(this.numerator + other.numerator,this.denominator);
            }else if ("sub".equals(command)){
                fraction =  new Fraction(this.numerator - other.numerator,this.denominator);
            }
        }else {
            System.err.println("An error has occurred Fraction adding");
        }

        if (fraction != null){
            fraction.toLowestTerm();
        }
        return fraction;
    }

    public Fraction add(Fraction other){
        return addOrSubtract(other,"add");
    }

    public Fraction subtract(Fraction other){
        return addOrSubtract(other,"sub");
    }

    public Fraction multiply(Fraction other){
            int newNum = this.numerator * other.numerator;
            int newden = this.denominator * other.denominator;
            Fraction fraction = new Fraction(newNum,newden);
            fraction.toLowestTerm();
            return fraction;
    }

    public Fraction divide(Fraction other){
        other.toReciprical();
        return this.multiply(other);
    }

    private void toReciprical(){
        int temp = this.numerator;
        this.numerator = this.denominator;
        this.denominator = temp;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof  Fraction)){
            return false;
        }
        Fraction other = (Fraction) obj;
        return other.getDenominator() * this.getNumerator() == other.getNumerator() * this.getDenominator();
    }

    public void toLowestTerm(){
        int divider = gcd(this.numerator,this.denominator);
        this.numerator = this.numerator / divider;
        this.denominator = this.denominator / divider;
    }

    public static int gcd(int a, int  b){
        if (b == 0){
            return a;
        }
        return gcd(b,a % b);
    }
}

