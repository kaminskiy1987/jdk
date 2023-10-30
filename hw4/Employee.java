package  jdk.hw4;

import java.time.LocalDate;

/**
 * Каждый сотрудник имеет следующие атрибуты:
 * Табельный номер
 * Номер телефона
 * Имя
 * Стаж
 */
public class Employee {

    private int id;
    private String name;
    private String phone;
    private LocalDate hireDate;

    private static int counter = 1000;

    {
        id = ++counter;
    }

    public Employee(String name, String phone, LocalDate hireDate) {
        this.name = name;
        this.phone = phone;
        this.hireDate = hireDate;
    }

    public int getExperience() {
        if(hireDate != null) {
            int startWorking = hireDate.getYear();
            int now = LocalDate.now().getYear();
            return now - startWorking;
        }
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", hireDate=" + hireDate + '\'' +
                ", experience=" + getExperience() +
                '}';
    }
}