package homework5;

public class Main {
    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Krupenin Daniil", "manager", "boss@bestcompany.com", "89107007707", 300000, 37);
        employeesArray[1] = new Employee("Miheeva Tatiyana", "accountant", "miheeva1976@bestcompany.com", "89104682525", 50000, 54);
        employeesArray[2] = new Employee("Saraev Viktor", "head of department", "vsaraev@bestcompany.com", "89207246578", 35000, 35);
        employeesArray[3] = new Employee("Lebedev Aleksandr", "engineer", "lebedev@bestcompany.com", "89510045932", 25000, 31);
        employeesArray[4] = new Employee("Korolev Aleksey", "electrician", "al_kor@bestcompany.com", "89511064539", 25000, 47);

        findInfoOlder(employeesArray, 40);
    }

    private static void findInfoOlder(Employee[] employeesArray, int limitAge) {
        for (Employee info : employeesArray) {
            if (info.getAge() > limitAge) {
//                info.displayInformation1();
                info.displayInformation2();
                System.out.println();
            }
        }
    }
}
