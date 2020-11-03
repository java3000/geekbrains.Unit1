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
        sb.append("ФИО: " + this.fio + "\n");
        sb.append("Должность: " + this.title + "\n");
        sb.append("E-mail: " + this.email + "\n");
        sb.append("Телефон: " + this.phone + "\n");
        sb.append("Оклад: " + this.salary + "\n");
        sb.append("Возраст: " + this.age + "\n");

        System.out.println(sb.toString());
    }
}


