package com.forward.po;

public class User {
    int user_id;
    String user_name;
    int password;
    double salary;

    public User() {
        super();
    }

    public User(int user_id, String user_name, int password, double salary) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.salary = salary;
    }

    public User(int user_id, String user_name) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", user_name=" + user_name
                + ", password=" + password + ", salary=" + salary + "]";
    }
}
