package controllers;

import models.office;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.office.*;


import javax.inject.Inject;
import java.util.List;

public class OfficeController extends Controller {


    @Inject
    FormFactory formFactory;

    //all office in the database
    public Result indexOffice(){
        List<office> Office = office.find.all();
        return ok(indexOffice.render(Office));
    }



    //relocation task GET
    public Result officeRelocation(Integer ID){
        office Office = office.find.byId(ID);

        if (Office == null){
            return notFound("Location not found");
        }
        Form<office> relForm= formFactory.form(office.class).fill(Office);
        return ok(officeRelocation.render(relForm));

    }



    //relocation task  POST
    public Result saveOfficeRelocation(){
        Form<office> relForm = formFactory.form(office.class).bindFromRequest();
        if (relForm.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(officeTask.render(relForm));
        }
        office Office = relForm.get();
        office oldOffice = office.find.byId(Office.id);

        if(oldOffice == null){
            return notFound("Location Not found");
        }

        oldOffice.todo = Office.todo;
        oldOffice.status = Office.status;
        oldOffice.dateToCarryOutTheTask = Office.dateToCarryOutTheTask;
        oldOffice.completedDate = Office.completedDate;
        oldOffice.destinedDept = Office.destinedDept;
        oldOffice.destinedOccupant = Office.destinedOccupant;
        oldOffice.destinedBuildingNo = Office.destinedBuildingNo;
        oldOffice.destinedFloorNo = Office.destinedFloorNo;
        oldOffice.destinedRoom = Office.destinedRoom;
        oldOffice.destinedSpaceType = Office.destinedSpaceType;
        oldOffice.destinedSpaceCode = Office.destinedSpaceCode;

        oldOffice.update();
        flash("success","Request Success");
        return redirect(routes.OfficeController.indexOffice());

    }


    public Result officeTask(Integer ID){
        office Office = office.find.byId(ID);

        if (Office == null){
            return notFound("Location not found");
        }
        Form<office> taskForm= formFactory.form(office.class).fill(Office);
        return ok(officeTask.render(taskForm));

    }


    //relocation task  POST
    public Result saveTask() {
        Form<office> taskForm = formFactory.form(office.class).bindFromRequest();
        if (taskForm.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(officeTask.render(taskForm));
        }
        office Office = taskForm.get();
        office oldOffice = office.find.byId(Office.id);

        if (oldOffice == null) {
            return notFound("Location Not found");
        }

        oldOffice.todo = Office.todo;
        oldOffice.status = Office.status;
        oldOffice.dateToCarryOutTheTask = Office.dateToCarryOutTheTask;
        oldOffice.completedDate = Office.completedDate;
        oldOffice.maintenanceCall = Office.maintenanceCall;
        oldOffice.callStatus = Office.callStatus;

        oldOffice.update();
        flash("success","Request Success");
        return redirect(routes.OfficeController.indexOffice());
    }


    //About tasks
    public Result aboutOfficeTask(Integer id){
        office Furniture = office.find.byId(id);
        if (Furniture == null){
            return notFound("Furniture not found");
        }
        return ok(aboutOfficeTask.render(Furniture));
    }


    //Add new locations
    public Result updateOffice(){
        Form<office> detailsForm1 = formFactory.form(office.class);
        return ok(newOffice.render(detailsForm1));
    }

    //saving the new location
    public Result saveUpdateOffice(){
        Form<office> locationForm = formFactory.form(office.class).bindFromRequest();
        if (locationForm.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(newOffice.render(locationForm));
        }

        office Office = locationForm.get();
        Office.save();
        flash("success","Update Success");
        return redirect(routes.OfficeController.indexOffice());
    }



    //GET; Edit details
    public Result editDetailsOffice(Integer id){
        office Office = office.find.byId(id);

        if (Office == null){
            return notFound("Location not found");
        }

        Form<office> editOffice = formFactory.form(office.class).fill(Office);
        return ok(editDetailsOffice.render(editOffice));

    }

    //POST; save edit
    public Result saveEditOffice(){
        Form<office> editForm = formFactory.form(office.class).bindFromRequest();
        if (editForm.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(editDetailsOffice.render(editForm));
        }

        office Office = editForm.get();
        office oldOffice = office.find.byId(Office.id);

        if (oldOffice == null){
            return notFound("Furniture not found");
        }

        oldOffice.occupyingDept = Office.occupyingDept;
        oldOffice.occupant = Office.occupant;
        oldOffice.occupyingBuildingNo = Office.occupyingBuildingNo;
        oldOffice.occupyingFloorNo = Office.occupyingFloorNo;
        oldOffice.occupyingRoom = Office.occupyingRoom;
        oldOffice.occupyingSpaceType = Office.occupyingSpaceType;
        oldOffice.occupyingSpaceCode = Office.occupyingSpaceCode;
        oldOffice.todo = Office.todo;

        oldOffice.update();
        flash("success","Update Success");
        return redirect(routes.OfficeController.indexOffice());
    }


    //delete furniture
    public Result deleteOffice(Integer id) {

        office Office = office.find.byId(id);
        if (Office == null){
            return notFound("Furniture not found");
        }
        Office.delete();
        return redirect(routes.OfficeController.indexOffice());

    }


}
