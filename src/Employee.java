public class Employee {
    //Task3 :Employee sinfi var: name, department, salary, age.
    //Bu siyahıdan:
    //ən yüksək maaşlı işçini tap (Optional ilə),
    //bütün işçilərin orta maaşını hesabla,
    //yaşı 30-dan böyük olanların ümumi maaş cəmini tap.

    private String name;
    private String department;
    private Double salary;
    private Integer age;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee(String name, String department, Double salary, Integer age) {
        this.name = name;
        this.department = department;
        this.salary =  salary;
        this.age = age;
    }
}
