package kata5;

class Person {
    private final String name;
    private final String surname;
    private final String department;
    

    public Person(String name, String surname, String department) {
        this.name = name;
        this.surname = surname;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    
}
