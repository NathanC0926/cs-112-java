package lab3;

public class RomanNumeral {
    private String RomanNumeralString;
    private int RomanNumeralDecimal;

    public RomanNumeral(String RomamNumeral){
        // __init__
        this.RomanNumeralString = RomamNumeral;
        this.RomanNumeralDecimal = RomanNumeralStatic.convert(this.RomanNumeralString);
    }
    public String toString(){
        return this.RomanNumeralString;
    }
    public boolean equals(RomanNumeral RomamNumeral2){
        return (this.RomanNumeralString.equals(RomamNumeral2));
    }
    public int add(String RomamNumeral2){
        return (this.RomanNumeralDecimal + RomanNumeralStatic.convert(RomamNumeral2));
    
    }
}
