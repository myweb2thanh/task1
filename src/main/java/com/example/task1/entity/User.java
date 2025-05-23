package com.example.task1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 2, max = 100, message = "Họ tên phải từ 2-100 ký tự")
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Size(min = 10, max = 15, message = "Số điện thoại phải từ 10-15 ký tự")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Size(max = 200, message = "Địa chỉ không được quá 200 ký tự")
    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private Integer age;

    // Constructors
    public User() {}

    public User(String fullName, String email, String phoneNumber, String address, Integer age) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public @NotBlank(message = "Họ tên không được để trống") @Size(min = 2, max = 100, message = "Họ tên phải từ 2-100 ký tự") String getFullName() {
        return fullName;
    }

    public void setFullName(@NotBlank(message = "Họ tên không được để trống") @Size(min = 2, max = 100, message = "Họ tên phải từ 2-100 ký tự") String fullName) {
        this.fullName = fullName;
    }

    public @NotBlank(message = "Email không được để trống") @Email(message = "Email không hợp lệ") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email không được để trống") @Email(message = "Email không hợp lệ") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Số điện thoại không được để trống") @Size(min = 10, max = 15, message = "Số điện thoại phải từ 10-15 ký tự") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank(message = "Số điện thoại không được để trống") @Size(min = 10, max = 15, message = "Số điện thoại phải từ 10-15 ký tự") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Size(max = 200, message = "Địa chỉ không được quá 200 ký tự") String getAddress() {
        return address;
    }

    public void setAddress(@Size(max = 200, message = "Địa chỉ không được quá 200 ký tự") String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

}