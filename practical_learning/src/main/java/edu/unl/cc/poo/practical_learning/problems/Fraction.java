package edu.unl.cc.poo.practical_learning.problems;

import javax.print.attribute.standard.MediaSize;

/**
 *
 * @author Usuario iTC
 */
public class Fraction {

    private Integer numerator;
    private Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("No puede ser 0");
        }
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public Fraction addition(Fraction other) {
        Integer nuevoNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        Integer nuevoDenominator = this.denominator * other.denominator;
        return new Fraction(nuevoNumerator, nuevoDenominator);
    }

    public Fraction subtraction(Fraction other) {
        Integer nuevoNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        Integer nuevoDenominator = this.denominator * other.denominator;
        return new Fraction(nuevoNumerator, nuevoDenominator);
    }

    public Fraction multiplication(Fraction other) {
        Integer nuevoNumerator = this.numerator * other.numerator;
        Integer nuevoDenominator = this.denominator * other.denominator;
        return new Fraction(nuevoNumerator, nuevoDenominator);
    }

    public Fraction division(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        int nuevoNumerator = this.numerator * other.denominator;
        int nuevoDenominator = this.denominator * other.numerator;
        return new Fraction(nuevoNumerator, nuevoDenominator);
    }

    public Double Decimal() {
        return (double) (this.numerator) / (double) this.denominator;
    }

    public Fraction Investor() {
        if (this.numerator == 0) {
            throw new IllegalArgumentException("No se puede invertir por que el numerador es 0");
        }
        return new Fraction(this.denominator, this.numerator);
    }

    public Fraction simplify() {
        int gcd = mcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        return new Fraction(numerator, denominator);
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public String toString() {
        return "[" + numerator + "/" + denominator + ']';
    }

}
