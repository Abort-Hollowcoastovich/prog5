package Model;

public class Coordinates {
    private double x;
    private Double y; //Максимальное значение поля: 994, Поле не может быть null
    public Coordinates(double x, Double y){
        this.x = x;
        this.y = y;
    }

    public String asString() {
        return "X equals " + x +
                ", Y equals " + y + ".\n";
    }
}
