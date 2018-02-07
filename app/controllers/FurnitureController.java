package controllers;

import models.furniture;
import play.data.Form;
import play.data.FormFactory;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.furnitures.*;

import javax.inject.Inject;
import java.util.List;

public class FurnitureController extends Controller {

    @Inject
    FormFactory formFactory;

   //all furnitures in the database
    public Result index(){
        List<furniture> furnitures = furniture.find.all();
        return ok(index.render(furnitures));
    }




    //requesting for a move or rescheduling a move date: GET
    public Result requestingMoveFurniture(Integer id) {
        furniture Furniture = furniture.find.byId(id);

        if (Furniture == null){
            return notFound("Furniture not found");
        }
        Form<furniture> requestForm= formFactory.form(furniture.class).fill(Furniture);
        return ok(requestingMoveFurniture.render(requestForm));

    }

    //requesting furniure form- POST
    public Result saveRequest(){
         Form<furniture> requestForm= formFactory.form(furniture.class).bindFromRequest();
        if (requestForm.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(requestingMoveFurniture.render(requestForm));
        }

         furniture Furniture = requestForm.get();
         furniture oldFurniture = furniture.find.byId(Furniture.id);

        if (oldFurniture == null){
            return notFound("Furniture not found");
        }


        oldFurniture.task = Furniture.task;
        oldFurniture.status = Furniture.status;
        oldFurniture.dateToCarryOutTheTask= Furniture.dateToCarryOutTheTask;
        oldFurniture.completedDate = Furniture.completedDate;
        oldFurniture.destinationDept = Furniture.destinationDept;
        oldFurniture.destinationBuildingNo = Furniture.destinationBuildingNo;
        oldFurniture.destinationFloorNo = Furniture.destinationFloorNo;
        oldFurniture.destinationRoom = Furniture.destinationRoom;
        oldFurniture.destinationSpaceType = Furniture.destinationSpaceType;
        oldFurniture.destinationSpaceCode = Furniture.destinationSpaceCode;

        oldFurniture.update();
        flash("success","Request Success");
        return redirect(routes.FurnitureController.index());
    }


    //sell request
    public Result sellRequest(Integer id) {
        furniture Furniture = furniture.find.byId(id);

        if (Furniture == null){
            return notFound("Furniture not found");
        }
        Form<furniture> sellForm= formFactory.form(furniture.class).fill(Furniture);
        return ok(sellRequest.render(sellForm));

    }

    //sell - POST
    public Result saveSell(){
        Form<furniture> sellForm = formFactory.form(furniture.class).bindFromRequest();
        if (sellForm.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(updateFurniture.render(sellForm));
        }

        furniture Furniture = sellForm.get();
        furniture oldFurniture = furniture.find.byId(Furniture.id);

        if (oldFurniture == null){
            return notFound("Furniture not found");
        }

        oldFurniture.task = Furniture.task;
        oldFurniture.status = Furniture.status;
        oldFurniture.completedDate = Furniture.completedDate;
        oldFurniture.soldAgent = Furniture.soldAgent;

        oldFurniture.update();
        flash("success","Update Success");
        return redirect(routes.FurnitureController.index());

    }



    //sell request
    public Result cancelRequest(Integer id) {
        furniture Furniture = furniture.find.byId(id);

        if (Furniture == null){
            return notFound("Furniture not found");
        }
        Form<furniture> cancelForm= formFactory.form(furniture.class).fill(Furniture);
        return ok(cancelRequest.render(cancelForm));

    }

    //sell - POST
    public Result saveCancel(){
        Form<furniture> cancelForm = formFactory.form(furniture.class).bindFromRequest();

        if (cancelForm.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(cancelRequest.render(cancelForm));
        }

        furniture Furniture = cancelForm.get();
        furniture oldFurniture = furniture.find.byId(Furniture.id);

        if (oldFurniture == null){
            return notFound("Furniture not found");
        }

        oldFurniture.task = Furniture.task;
        oldFurniture.status = Furniture.status;
        oldFurniture.dateToCarryOutTheTask = Furniture.dateToCarryOutTheTask;


        oldFurniture.update();
        flash("success","Update Success");
        return redirect(routes.FurnitureController.index());

    }


    //assing or updating furniture
    public Result updateFurniture(){
        Form<furniture> detailsForm1 = formFactory.form(furniture.class);
        return ok(updateFurniture.render(detailsForm1));
    }


    //saving the updates
    public Result saveUpdate(){
        Form<furniture> detailsForm1 = formFactory.form(furniture.class).bindFromRequest();
        if (detailsForm1.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(updateFurniture.render(detailsForm1));
        }
        furniture Furniture = detailsForm1.get();
        Furniture.save();
        flash("success","Update Success");
        return redirect(routes.FurnitureController.index());
    }



    //about furniture
    public Result aboutFurniture(Integer id){
        furniture Furniture = furniture.find.byId(id);
            if (Furniture == null){
                return notFound("Furniture not found");
            }
            return ok(aboutFurniture.render(Furniture));
    }




    //Repair furniture-GET
    public Result repairFurniture(Integer id){
        furniture Furniture = furniture.find.byId(id);

        if (Furniture == null){
            return notFound("Furniture not found");
        }

        Form<furniture> repairForm = formFactory.form(furniture.class).fill(Furniture);
        return ok(repairFurniture.render(repairForm));

    }


    //POST
    public Result saveRepair(){

        Form<furniture> repairForm = formFactory.form(furniture.class).bindFromRequest();

        if (repairForm.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(repairFurniture.render(repairForm));
        }
        furniture Furniture = repairForm.get();
        furniture oldFurniture = furniture.find.byId(Furniture.id);

        if (oldFurniture == null){
            return notFound("Furniture not found");
        }

        oldFurniture.task = Furniture.task;
        oldFurniture.status = Furniture.status;
        oldFurniture.dateToCarryOutTheTask= Furniture.dateToCarryOutTheTask;
        oldFurniture.completedDate = Furniture.completedDate;
        oldFurniture.repairDetails = Furniture.repairDetails;

        oldFurniture.update();
        flash("success","Update Success");
        return redirect(routes.FurnitureController.index());

    }


    //GET; Edit details
    public Result editDetails(Integer id){
        furniture Furniture = furniture.find.byId(id);

        if (Furniture == null){
            return notFound("Furniture not found");
        }

        Form<furniture> editForm = formFactory.form(furniture.class).fill(Furniture);
        return ok(editDetails.render(editForm));

    }

    //POST; Save edit
    public Result saveEdit(){
       Form<furniture> editForm = formFactory.form(furniture.class).bindFromRequest();

       if (editForm.hasErrors()){
            flash("danger","Please Correct The Form");
            return badRequest(editDetails.render(editForm));
        }

        furniture Furniture = editForm.get();
       furniture oldFurniture = furniture.find.byId(Furniture.id);

        if (oldFurniture == null){
            return notFound("Furniture not found");
        }

        oldFurniture.furnitureName = Furniture.furnitureName;
        oldFurniture.furnitureAcquisitionDate = Furniture.furnitureAcquisitionDate;
        oldFurniture.furnitureCost = Furniture.furnitureCost;
        oldFurniture.furnitureBarcode = Furniture.furnitureBarcode;
        oldFurniture.occupyingDept= Furniture.occupyingDept;
        oldFurniture.occupant = Furniture.occupant;
        oldFurniture.buildingNo = Furniture.buildingNo;
        oldFurniture.floorNo = Furniture.floorNo;
        oldFurniture.room = Furniture.room;
        oldFurniture.spaceType = Furniture.spaceType;
        oldFurniture.spaceCode = Furniture.spaceCode;
        oldFurniture.boughtAgent = Furniture.boughtAgent;
        oldFurniture.key = Furniture.key;

        oldFurniture.update();
        flash("success","Update success");
        return redirect(routes.FurnitureController.index());
    }


    //delete furniture
    public Result deleteFurniture(Integer id) {

        furniture Furniture = furniture.find.byId(id);
        if (Furniture == null){
            return notFound("Furniture not found");
    }
            Furniture.delete();
            return redirect(routes.FurnitureController.index());

    }





    //final display-GET
    public Result responseTaskFurniture(){
        return TODO;
    }





}
