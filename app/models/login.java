package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Constraint;
import java.util.ArrayList;
import java.util.List;


@Entity
public class login extends Model {
    @Id
    @Constraints.Email
    public String Email;
    public String FirstName;
    public String LastName;
    public String Password;
    public String confirmPassword;


    public static Finder<String,login> find = new Finder<>(login.class);



}