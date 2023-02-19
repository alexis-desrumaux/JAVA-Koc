package kurequest;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class ITRequest extends Request {
  private int type;
  private String classroomName;
  private String computerName;
  private int computerSerialNumber;
  static private ArrayList<ITRequest> ITRequests = new ArrayList<ITRequest>();

  public ITRequest(Student requestCreator, LocalDateTime creationTime, String title, int type, String classroomName,
      String computerName, int computerSerialNumber) {
    super(requestCreator, creationTime, title);
    ITRequests.add(this);

    this.type = type;
    if (type == 1) {
      this.computerName = computerName;
      this.computerSerialNumber = computerSerialNumber;
      this.classroomName = "";
    } else if (type == 2) {
      this.computerName = "";
      this.computerSerialNumber = 0;
      this.classroomName = classroomName;
    } else {
      this.computerName = "";
      this.classroomName = "";
      this.computerSerialNumber = 0;
    }
  }

  public int getType() {
    return this.type;
  }

  public void setType(int type) {
    this.type = type;
    if (type == 1) {
      this.computerName = "";
      this.computerSerialNumber = 0;
      this.classroomName = "";
    } else {
      this.computerName = "";
      this.computerSerialNumber = 0;
      this.classroomName = "";
    }
  }

  public String getClassRoomName() {
    return classroomName;
  }

  public void setClassRoomName(String classRoomName) {
    this.classroomName = classRoomName;
  }

  public String getComputerName() {
    return this.computerName;
  }

  public void setComputerName(String computerName) {
    this.computerName = computerName;
  }

  public int getComputerSerialNumber() {
    return this.computerSerialNumber;
  }

  public static ArrayList<ITRequest> getITRequests() {
    return ITRequests;
  }

  public String toString() {
    String firstLine = "IT" + super.toString();
    String secondLine = "";
    switch (this.type) {
      case 1:
        secondLine = String.format("Computer: Name: %s, Serial Number: %d\n", this.computerName, this.computerSerialNumber);
        break;
      case 2:
        secondLine = String.format("Classroom Location: %s\n", this.classroomName);
        break;
      default:
        break;
    }
    return firstLine + secondLine;
  }
}
