package com.example.bloodline.firebase_test;

import java.util.List;

public class User {
    String name;
    String email;
    Boolean cukorbetegseg ;
    Boolean liszterzekenyseg;
    Boolean laktozerzekenyseg ;
    Integer weight;
    Integer height;
    Boolean gender; //true = man, false = woman
    Double bmiindex;
    Boolean acctype; //true = admin, false = user


    public User(String name, String email, Boolean cukorbetegseg, Boolean liszterzekenyseg, Boolean laktozerzekenyseg, Integer weight, Integer height, Boolean gender, Double bmiindex, Boolean acctype) {
        this.name = name;
        this.email = email;
        this.cukorbetegseg = cukorbetegseg;
        this.liszterzekenyseg = liszterzekenyseg;
        this.laktozerzekenyseg = laktozerzekenyseg;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.bmiindex = bmiindex;
        this.acctype = acctype;
    }

    public String getName() {
        return name;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCukorbetegseg() {
        return cukorbetegseg;
    }

    public void setCukorbetegseg(Boolean cukorbetegseg) {
        this.cukorbetegseg = cukorbetegseg;
    }

    public Boolean getLiszterzekenyseg() {
        return liszterzekenyseg;
    }

    public void setLiszterzekenyseg(Boolean liszterzekenyseg) {
        this.liszterzekenyseg = liszterzekenyseg;
    }

    public Boolean getLaktozerzekenyseg() {
        return laktozerzekenyseg;
    }

    public void setLaktozerzekenyseg(Boolean laktozerzekenyseg) {
        this.laktozerzekenyseg = laktozerzekenyseg;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getBmiindex() {
        return bmiindex;
    }

    public void setBmiindex(Double bmiindex) {
        this.bmiindex = bmiindex;
    }

    public Boolean getAcctype() {
        return acctype;
    }

    public void setAcctype(Boolean acctype) {
        this.acctype = acctype;
    }
}
