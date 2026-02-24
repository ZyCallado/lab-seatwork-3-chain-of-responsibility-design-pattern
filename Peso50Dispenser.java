public class Peso50Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 50) {
            int num = cur.getAmount() / 50;
            int remainder = cur.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50 bills");
            if (remainder != 0) {
                if (this.chain != null) this.chain.dispense(new Currency(remainder));
                else System.out.println("Unable to dispense remainder: " + remainder);
            }
        } else {
            if (this.chain != null) this.chain.dispense(cur);
            else System.out.println("Unable to dispense amount: " + cur.getAmount());
        }
    }
}