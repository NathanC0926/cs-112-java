package lab4;
/*
 * Cat.java
 *
 * A simple class representing a cat.
 */

public class Cat extends Animal {
    private boolean isShortHaired;

    public Cat(String name, boolean isShortHaired) {
	super(name, 3);
    this.isShortHaired = isShortHaired;
    }

    public boolean isShortHaired() {
        return this.isShortHaired;
    }
    
    public boolean isExtroverted() {
        return false;
    }
    @Override
    public boolean isSleeping(int hour, int minute){
        return true;
    }
    public static void main(String[] args) {
        Abyssinian a = new Abyssinian("Abby");
        System.out.println("Short Haired: " + a.isShortHaired());
        System.out.println(a.isSleeping(0, 0));
        System.out.println(a.isExtroverted());

    }
}
