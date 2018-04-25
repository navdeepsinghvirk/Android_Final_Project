package com.mrvirk.parkingsystem.Model;

public class Signup {
    private String fname;
    private String email;
    private String password;

    public Signup(String fname, String email, String password) {
        this.fname = fname;
        this.email = email;
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
