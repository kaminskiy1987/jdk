package  jdk.hw4;

import java.util.*;

public class EmployeeList implements List<Employee> {

    private Employee[] employees;
    private int initCapacity = 100;

    private int index;

    public EmployeeList() {
        this.employees = new Employee[initCapacity];
    }
    public EmployeeList(int capacity) {
        this.employees = new Employee[capacity];
    }

    /**
     * Метод выводит номер телефона сотрудника по имени (может быть список)
     * @param name имя сотрудника
     * @return список номеров, найденных по имени сотрудника
     */
    public List<String> getPhone(String name) {
        List<String> result = new ArrayList<>();
        for (Employee employee: employees) {
            if(employee != null && employee.getName().equals(name)) {
                result.add(employee.getName() + "=" + employee.getPhone());
            }
        }
        return result;
    }

    /**
     * Метод ищет сотрудника по табельному номеру
     * @param tabNo табельный номер
     * @return возвращает сотрудника с данным табельным номером, если такой существует
     */
    public Employee getEmployeeByNo(int tabNo) {
        for (Employee employee: employees) {
            if(employee != null && employee.getId() == tabNo) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Метод ищет сотрудника по стажу (может быть список)
     * @param experience заданное значение стажа сотрудника
     * @return возвращает список сотрудников, имеющих заданный стаж
     */
    public List<Employee> getEmployeesByExp(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee != null && employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * Метод для добавления нового сотрудника в справочник сотрудников
     * @param employee элемент, который нужно дабавить в список сотрудников
     * @return возвращает true, если операция добавления завершена успешно
     */
    @Override
    public boolean add(Employee employee) {
        if(employee != null) {
            this.employees[this.index++] = employee;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Employee> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Employee> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Employee> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Employee get(int index) {
        return null;
    }

    @Override
    public Employee set(int index, Employee element) {
        return null;
    }

    @Override
    public void add(int index, Employee element) {

    }

    @Override
    public Employee remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Employee> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Employee> listIterator(int index) {
        return null;
    }

    @Override
    public List<Employee> subList(int fromIndex, int toIndex) {
        return null;
    }
}