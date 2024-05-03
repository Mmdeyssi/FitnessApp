package com.example.login.DB;

public class users {
    String fullname,email,password;
    int id,phone;


    public users(String fullname, String email, int phone,String password ) {
        this.fullname = fullname;
        this.email = email;

        this.phone = phone;
        this.password = password;
    }

    public void setFname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }





    public int getPhone() {
        return phone;
    }
    public String getPassword() {
        return password;
    }
}
