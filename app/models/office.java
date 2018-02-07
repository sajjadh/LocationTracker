package models;



import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Constraint;


@Entity
public class office extends Model {
    @Id
    //current location details
    @Constraints.Required
    public Integer id;
    @Constraints.Required
    public String occupyingDept;
    @Constraints.Required
    public String occupant;
    @Constraints.Required
    public String occupyingBuildingNo;
    @Constraints.Required
    public String occupyingFloorNo;
    @Constraints.Required
    public String occupyingRoom;
    @Constraints.Required
    public String occupyingSpaceType;
    @Constraints.Required
    public String occupyingSpaceCode;

    //relocating place
    public String destinedDept;
    public String destinedOccupant;
    public String destinedBuildingNo;
    public String destinedFloorNo;
    public String destinedRoom;
    public String destinedSpaceType;
    public String destinedSpaceCode;

    //task details
    public String todo;
    public String status;
    public String dateToCarryOutTheTask;
    public String completedDate;
    public String maintenanceCall;
    public String callStatus;

    public String referenceDetails;


    public static Finder<Integer, office> find = new Finder<>(office.class);

}



