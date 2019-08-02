package com.ilkiv.atm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "account")
    private double account;

    public User(long id, String firstName, String secondName, String accountNumber, String password, double account) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountNumber = accountNumber;
        this.password = password;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public double getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Double.compare(user.account, account) == 0 &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(accountNumber, user.accountNumber) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, accountNumber, password, account);
    }
}
