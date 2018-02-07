package models;


import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity

public class furniture extends Model{

    @Id

    //furniture details
    @Constraints.Required
    public Integer id;
    @Constraints.Required
    public String furnitureName;
    @Constraints.Required
    public String  furnitureAcquisitionDate;
    @Constraints.Required
    public String furnitureCost;
    @Constraints.Required
    public String furnitureBarcode;

    //location details
    @Constraints.Required
    public String occupyingDept;
    @Constraints.Required
    public String occupant;
    @Constraints.Required
    public String buildingNo;
    @Constraints.Required
    public String floorNo;
    @Constraints.Required
    public String room;
    @Constraints.Required
    public String spaceType;
    @Constraints.Required
    public String spaceCode;
    //public String UFA;
    //public int roomTotalCost;

    @Constraints.Required
      public String task;

      public String status;

      public String dateToCarryOutTheTask;

      public String completedDate;

      public String destinationDept;

      public String destinationDeptOccupant;

      public String destinationBuildingNo;

      public String destinationFloorNo;

      public String destinationRoom;

      public String destinationSpaceType;

      public String destinationSpaceCode;

      public String soldAgent;
      public String boughtAgent;
      public String repairDetails;
      public String key;



    public static Finder<Integer,furniture> find = new Finder<>(furniture.class);


}
