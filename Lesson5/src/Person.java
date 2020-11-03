//* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
class Person {

    public String fio, title, email, phone;
    public int salary, age;


    //* Конструктор класса должен заполнять эти поля при создании объекта;
    public Person(String fio, String title, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    //* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void printInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ФИО: %s\n", this.fio));
        sb.append(String.format("Должность: %s\n", this.title));
        sb.append(String.format("E-mail: %s\n", this.email));
        sb.append(String.format("Телефон: %s\n", this.phone));
        sb.append(String.format("Оклад: %d\n", this.salary));
        sb.append(String.format("Возраст: %d\n", this.age));

        System.out.println(sb.toString());
    }
}


