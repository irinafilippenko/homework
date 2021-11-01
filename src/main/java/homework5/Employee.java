package homework5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String fullName) {
        this(fullName, "company member", "email@bestcompany.com", "89000000000", 0, 0);
    }

    void displayInformation1() {
        String phone1 = phone.substring(0, 1);
        String phone2 = phone.substring(1, 4);
        String phone3 = phone.substring(4, 7);
        String phone4 = phone.substring(7, 9);
        String phone5 = phone.substring(9, 11);
        String symbolArrow = "►";
        System.out.printf("Сотрудник %s \n%s должность: %s \n%s email: %s \n%s телефон: %s %s-%s-%s-%s \n%s зарплата: %d \n%s возраст: %d\n", fullName, symbolArrow, position, symbolArrow, email, symbolArrow, phone1, phone2, phone3, phone4, phone5, symbolArrow, salary, symbolArrow, age);
    }

    void displayInformation2() {
        System.out.println(this);
    }

    public String toString() {
        String phone1 = phone.substring(0, 1);
        String phone2 = phone.substring(1, 4);
        String phone3 = phone.substring(4, 7);
        String phone4 = phone.substring(7, 9);
        String phone5 = phone.substring(9, 11);
        String symbolSquare = "■";
        return String.format("Сотрудник %s занимает должность %s \n%s email: %s \n%s телефон: %s %s-%s-%s-%s \n%s зарплата: %d \n%s возраст: %d", fullName, position, symbolSquare, email, symbolSquare, phone1, phone2, phone3, phone4, phone5, symbolSquare, salary, symbolSquare, age);
    }

    public int getAge() {
        return age;
    }
}



