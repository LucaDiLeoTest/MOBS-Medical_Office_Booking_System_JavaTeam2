package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor extends PersonEntity{

    private String officeContact;
    private String workplace;
    private String workingDays;


    public Doctor() {
    }

    public Doctor(Long id,String name,String surname,String email,String officeContact,String workplace,
                  String workingDays){
        super(id,name,surname,email);
        this.officeContact = officeContact;
        this.workplace = workplace;
        this.workingDays = workingDays;
    }

    public String getOfficeContact(){
        return officeContact;
    }

    public void setOfficeContact(String officeContact){
        this.officeContact = officeContact;
    }

    public String getWorkplace(){
        return workplace;
    }

    public void setWorkplace(String workplace){
        this.workplace = workplace;
    }

    public String getWorkingDays(){
        return workingDays;
    }

    public void setWorkingDays(String workingDays){
        this.workingDays = workingDays;
    }
}
