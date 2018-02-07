package controllers;

import models.login;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login.*;


import javax.inject.Inject;
import java.util.List;

public class LoginController extends Controller {

    @Inject
    FormFactory formFactory;

    //Registering;
    public Result registerUser() {
        Form<login> registrationForm = formFactory.form(login.class);
        return ok(registerUser.render(registrationForm));

    }
    //register post
    public Result saveUser(){
        Form<login> detailsForm1 = formFactory.form(login.class).bindFromRequest();
        if (detailsForm1.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(registerUser.render(detailsForm1));
        }
        login User= detailsForm1.get();
        User.save();
        flash("success","Update Success");
        return redirect(routes.LoginController.userDetails());
    }



    public Result userLogin() {
        Form<login> login = formFactory.form(login.class);
        return ok(userLogin.render(login));
    }


    //POST
    public Result authenticate() {
        Form<login> loginForm = formFactory.form(login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            flash("warning","User doesn't exist");
            return badRequest(userLogin.render(loginForm));
        } else {
            session().clear();
            session("Email", loginForm.get().Email);
            return redirect(
                    routes.HomeController.index()
            );
        }
    }

    //all user in the database
    public Result userDetails(){
        List<login> User = login.find.all();
        return ok(userDetails.render(User));
    }



}
