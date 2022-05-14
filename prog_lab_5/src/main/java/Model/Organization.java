package Model;

public class Organization {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String fullName; //Поле не может быть null
    private double annualTurnover; //Значение поля должно быть больше 0
    private Integer employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    public Organization(Integer id, String name, String fullName, double annualTurnover, Integer employeesCount){
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
    }

    public String asString() {
        return  "The organization is called " + name + ". " +
                "It`s full name is " + fullName + ". " +
                "Its` annual turnover is " + annualTurnover + ". " +
                "There are " + employeesCount + " employees working here. \n \n \n";
    }

    public double getAnnualTurnover() {
        return annualTurnover;
    }
}