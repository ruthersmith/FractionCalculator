package testing;

import com.company.Fraction;
import com.company.FractionCalculator;
import org.junit.Test;

public class TestFraction {
    @Test
    public void testgcd(){
        assert  Fraction.gcd(105,147) == 21;
    }

    @Test
    public void testToLowestTerm(){
        Fraction fraction = new Fraction(4,6);
        fraction.toLowestTerm();
        assert fraction.getNumerator() == 2 && fraction.getDenominator() == 3;
    }

    @Test
    public void testEquals(){
        Fraction fraction = new Fraction(4,6);
        Fraction other = new Fraction(2,3);
        assert fraction.equals(other);
    }

    @Test
    public void testIsValidOperation(){
        assert FractionCalculator.isValidOperation("*").equals("*");
        assert FractionCalculator.isValidOperation("p") == null;
    }

    @Test
    public void testAddFraction(){
        Fraction fraction = new Fraction(2,3);
        Fraction other = new Fraction(2,4);
        Fraction result = fraction.add(other);
        assert result.equals(new Fraction(14,12));
    }

    @Test
    public void testMultiplyFraction(){
        Fraction fraction = new Fraction(1,5);
        Fraction other = new Fraction(2,3);
        Fraction result = fraction.multiply(other);
        assert result.equals(new Fraction(2,15));
    }

    @Test
    public void testDivideFraction(){
        Fraction fraction = new Fraction(4,5);
        Fraction other = new Fraction(2,3);
        Fraction result = fraction.divide(other);
        assert result.equals(new Fraction(12,10));
    }
}
