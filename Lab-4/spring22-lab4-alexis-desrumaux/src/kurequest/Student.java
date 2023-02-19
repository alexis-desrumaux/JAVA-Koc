package kurequest;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Student {
  private int studentIdNumber;
  private String studentName;
  private String facultyName;
  private ArrayList<Request> requests;
  private static ArrayList<Student> allStudents = new ArrayList<Student>();

  public Student(String studentName, String facultyName) {
    allStudents.add(this);
    this.studentIdNumber = allStudents.size();
    this.studentName = studentName;
    this.facultyName = facultyName;
    this.requests = new ArrayList<Request>();
  }

  public int getStudentIdNumber() {
    return studentIdNumber;
  }

  public void setStudentIdNumber(int studentIdNumber) {
    this.studentIdNumber = studentIdNumber;
  }

  public String getStudentName() {
    return this.studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getFacultyName() {
    return this.facultyName;
  }

  public ArrayList<Request> getRequests() {
    return requests;
  }

  public ArrayList<Student> getAllStudents() {
    return allStudents;
  }

  public ITRequest openITRequest(
      int type, LocalDateTime creationTime, String title, String classroomName, String computerName,
      int computerSerialNumber) {
    ITRequest newITRequest = new ITRequest(this, creationTime, title, type, classroomName, computerName,
        computerSerialNumber);
    this.requests
        .add(newITRequest);
    return newITRequest;
  }

  public HousingRequest openHousingRequest(
      int type,
      LocalDateTime creationTime,
      String title,
      String locationName,
      String roomName) {

    HousingRequest newHousingRequest = new HousingRequest(this, creationTime, title, type, locationName, roomName);
    this.requests.add(newHousingRequest);
    return newHousingRequest;
  }

  public void addCommentToRequest(int requestNumber, String comment) {
    Request selectedRequest;
    try {
      selectedRequest = this.requests.get(requestNumber - 1);
    } catch (Exception e) {
      return;
    }
    selectedRequest.addAComment(this.studentName + ": " + comment);
  }

  public void giveSatisfactionPoints(int requestNumber, int satisfactionPoints) {
    Request selectedRequest;
    try {
      selectedRequest = this.requests.get(requestNumber - 1);
    } catch (Exception e) {
      return;
    }
    selectedRequest.setSatisfactionPoints(satisfactionPoints);
  }

  public String toString() {
    return String.format("Student: ID: %d, Name: %s, Faculty: %s\n", this.studentIdNumber, this.studentName,
        this.facultyName);
  }
}
