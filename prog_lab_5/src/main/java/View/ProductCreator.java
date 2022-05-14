package View;

import Model.Coordinates;
import Model.Organization;
import Model.Product;
import Model.UnitOfMeasure;
import util.UniquenessChecker;

import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class ProductCreator {
    static Scanner sc = new Scanner(System.in);
    public static String setName() {
        System.out.println("Enter product name");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Enter non-empty product name");
            name = sc.nextLine().trim();
        }
        return name;
    }
    public static Coordinates setCoordinates() {
        System.out.println("Enter product coordinates. X then Y");
        String stringCoordinates = sc.nextLine().trim();
        try {
            double x = Double.parseDouble(stringCoordinates.split(" ")[0]);
            Double y = Double.parseDouble(stringCoordinates.split(" ")[1]);
            if (y > 994) throw new SecurityException("Y is 994 max");
            return new Coordinates(x, y);
            }
        catch (RuntimeException e) {
            System.out.println("Enter proper coordinates. Number X, then Y");
            stringCoordinates = sc.nextLine().trim();
            double x = Double.parseDouble(stringCoordinates.split(" ")[0]);
            Double y = Double.parseDouble(stringCoordinates.split(" ")[1]);
            return new Coordinates(x, y);
        }
    }

    public static double setPrice() {
        System.out.println("Enter product price");
        try {
            Double price = Double.parseDouble(sc.nextLine().trim());
            if (price < 0) {
                System.out.println("Enter proper price. It should be a positive number");
                price = Double.parseDouble(sc.nextLine().trim());
            }
            return price;
        } catch (RuntimeException e) {
            System.out.println("Enter proper price");
            Double price = Double.parseDouble(sc.nextLine().trim());
            if (price < 0) {
                System.out.println("Enter proper price. It should be a positive number");
                price = Double.parseDouble(sc.nextLine().trim());
            }
            return price;
        }
    }
    public static String setPartNumber() {
        System.out.println("Enter part number");
        String partNumber = sc.nextLine().trim();
        if (UniquenessChecker.partNumberChecker(partNumber)) {
            return partNumber;
        }
        else {
            System.out.println("Enter unique part number");
            return sc.nextLine().trim();
        }
    }
    public static int setManufactureCost() {
        System.out.println("Enter manufacture cost");
        String string = sc.nextLine().trim();
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.out.println("Enter an integer");
            return Integer.parseInt(sc.nextLine().trim());
        }
    }
    public static UnitOfMeasure setUnitOfMeasure() {
        System.out.println("Enter unit of measure, one of: square_meters, milliliters, milligrams ");
        String string = sc.nextLine().trim();
        try {
            return UnitOfMeasure.valueOf(string.toUpperCase(Locale.ROOT));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Enter one of given options in proper way");
            return UnitOfMeasure.valueOf(sc.nextLine().toLowerCase(Locale.ROOT));
        }
    }
    public static Organization setManufacturer() {
        Integer id = Math.abs(UUID.randomUUID().hashCode());
        System.out.println("Enter manufacturer`s name");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Enter non-empty manufacturer`s name");
            name = sc.nextLine().trim();
        }
        System.out.println("Enter manufacturer`s full name");
        String fullName = sc.nextLine();
        if (name.isEmpty()) {
            System.out.println("Enter non-empty full name");
            fullName = sc.nextLine();
        }
        System.out.println("Enter manufacturer`s annual turnover");
        try {
            Double annualTurnover = Double.parseDouble(sc.nextLine().trim());
            if (annualTurnover < 0) {
                System.out.println("Enter proper turnover. It should be a positive number");
                annualTurnover = Double.parseDouble(sc.nextLine().trim());
            }
            System.out.println("Enter manufacturer`s amount of employees");
            Integer employeesCount = Integer.parseInt(sc.nextLine().trim());
            if (employeesCount < 0) {
                System.out.println("Enter proper amount of employees. It should be a positive number");
                employeesCount = Integer.parseInt(sc.nextLine().trim());
            }
            return new Organization(id, name, fullName, annualTurnover, employeesCount);
        } catch (RuntimeException e) {
            System.out.println("Annual turnover should be a double, amount of employees should be an integer");
            Double annualTurnover = Double.parseDouble(sc.nextLine().trim());
            if (annualTurnover < 0) {
                System.out.println("Enter proper turnover. It should be a positive number");
                annualTurnover = Double.parseDouble(sc.nextLine().trim());
            }
            System.out.println("Enter manufacturer`s amount of employees");
            Integer employeesCount = Integer.parseInt(sc.nextLine().trim());
            if (employeesCount < 0) {
                System.out.println("Enter proper amount of employees. It should be a positive number");
                employeesCount = Integer.parseInt(sc.nextLine().trim());
            }
            return new Organization(id, name, fullName, annualTurnover, employeesCount);
        }
    }
    public static Product setProduct() {
        return new Product(setName(), setCoordinates(), setPrice(), setPartNumber(),
                setManufactureCost(), setUnitOfMeasure(), setManufacturer());
    }
}
