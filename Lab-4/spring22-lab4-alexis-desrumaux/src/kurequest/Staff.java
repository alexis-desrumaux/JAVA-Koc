package kurequest;

import java.util.ArrayList;

public class Staff {
	private int staffIdNumber;
  private String staffName;
  private String departmentName;
  private String staffPositionName;
  private ArrayList<Request> requests;
  private static ArrayList<Staff> allStaff = new ArrayList<Staff>();

  public Staff() {
    this.staffIdNumber = -1;
    this.staffName = "";
    this.departmentName = "";
    this.staffPositionName = "";
    this.requests = new ArrayList<Request>();
  }

  public Staff(String staffName, String departmentName, String staffPositionName) {
    allStaff.add(this);
    this.staffIdNumber = allStaff.size();
    this.staffName = staffName;
    this.departmentName = departmentName;
    this.staffPositionName = staffPositionName;
    this.requests = new ArrayList<Request>();
  }

  public int getStaffIdNumber() {
    return this.staffIdNumber;
  }

  public void setStaffIdNumber(int staffIdNumber) {
    this.staffIdNumber = staffIdNumber;
  }

  public String getStaffName() {
    return this.staffName;
  }

  public void setStaffName(String staffName) {
    this.staffName = staffName;
  }

  public String getDepartmentName() {
    return this.departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getStaffPositionName() {
    return this.staffPositionName;
  }

  public void setStaffPositionName(String staffPositionName) {
    this.staffPositionName = staffPositionName;
  }

  public ArrayList<Request> getRequests() {
    return this.requests;
  }

  public ArrayList<Staff> getAllStaff() {
    return allStaff;
  }

  public void assignRequest(Request request) {
    this.requests.add(request);
    request.setRequestResolver(this);
  }

  public void closeRequest(int requestNumber) {
    Request selectedRequest;
    try {
      selectedRequest = this.requests.get(requestNumber - 1);
    } catch (Exception e) {
      return;
    }
    selectedRequest.setIsResolved(true);
  }

  public void addCommentToRequest(int requestNumber, String comment) {
    Request selectedRequest;
    try {
      selectedRequest = this.requests.get(requestNumber - 1);
    } catch (Exception e) {
      return;
    }
    selectedRequest.addAComment(this.staffName + ": " + comment);
  }

  public String toString() {
    return String.format("Staff: ID: %d, Name: %s, Department: %s, Position: %s\n", this.staffIdNumber, this.staffName, this.departmentName, this.staffPositionName);
  }
}
