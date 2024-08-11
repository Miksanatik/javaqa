package Animals;

public class Bowl {
    private int food;
    public Bowl(int food){
        this.food = food;
    }
    public void addFood(int quantity){
        this.food += quantity;
    }

    public boolean feed(int quantity) {
        if (quantity <= this.food) {
            this.food = this.food - quantity;
            return true;
        }
        else
            return false;
    }
}
