package kurequest;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class HousingRequest extends Request {
  private int type;
  private String locationName;
  private String roomName;
  static private ArrayList<HousingRequest> HousingRequests = new ArrayList<HousingRequest>();

  public HousingRequest(Student requestCreator, LocalDateTime creationTime, String title, int type, String locationName, String roomName) {
    super(requestCreator, creationTime, title);
    HousingRequests.add(this);
    this.type = type;
    this.locationName = locationName;
    this.roomName = roomName;
  }

  public int getType() {
    return this.type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getLocationName() {
    return this.locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public String getRoomName() {
    return this.roomName;
  }

  public ArrayList<HousingRequest> getHousingRequests() {
    return HousingRequests;
  }

  public String toString() {
    String firstLine =  "Housing" + super.toString();
    String type = "";
    String secondLine = "";

    switch (this.type) {
      case 0:
        type = "Housing Life";
        break;
      case 1:
        type = "Planning";
        break;
      case 2:
        type = "Financial";
        break;
      case 3:
        type = "Student Conduct";
      default:
        break;
    }
    secondLine = String.format("Type: %s, Location: %s, Room: %s\n", type, this.locationName, this.roomName);
    return firstLine + secondLine;
  }
}
