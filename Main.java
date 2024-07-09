class Dollar {
    private amount;

    Dollar(int amount) {
       this.amount= amount;
    }

    Dollar times(int multiplier) {
       return new Dollar(amount * multiplier);
    }

    Money times(int multiplier)  {
        return new Dollar(amount * multiplier);
    }
 }

 public void testMultiplication() {
    Dollar five = new Dollar(5);
    assertEquals(new Dollar(10), five.times(2));
    assertEquals(new Dollar(15), five.times(3));
 }

 public void testEquality() {
    assertTrue(Money.dollar(5).equals(Money.dollar(5)));
    assertFalse(Money.dollar(5).equals(Money.dollar(6)));
    assertTrue(Money.franc(5).equals(Money.franc(5)));
    assertFalse(Money.franc(5).equals(Money.franc(6)));
    assertFalse(Money.franc(5).equals(Money.dollar(5)));
 }

 public void testFrancMultiplication() {
    Money five = Money.franc(5);
    assertEquals(Money.franc(10), five.times(2));
    assertEquals(Money.franc(15), five.times(3));
 }

 public boolean equals(Object object)  {
    Dollar dollar = (Dollar) object;
    return amount == dollar.amount;
 }

 public void testMultiplication() {
    Money five = Money.dollar(5);
    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));
 }
 
 class Franc {   
    private int amount;					
    
    Franc(int amount) {      
       this.amount= amount;
    }		

    Franc times(int multiplier)  {      
        return new Franc(amount * multiplier);					
    }

    public boolean equals(Object object) {					
        Franc franc = (Franc) object;      
        return amount == franc.amount;					
    }
    
    Money times(int multiplier)  {
        return new Dollar(amount * multiplier);
    }
 }

 abstract class Money  {
    protected int amount;
    
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }

    static Dollar dollar(int amount)  {
        return new Dollar(amount);
    }
      
    abstract Money times(int multiplier);

    static Money dollar(int amount)  {
        return new Dollar(amount);
    }
     
     static Money franc(int amount) {
        return new Franc(amount);
    } 
 }

