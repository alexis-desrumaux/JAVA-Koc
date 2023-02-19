package kurequest;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Request {
  private int requestId;
  private boolean isResolved;
  private int satisfactionPoints;
  private Student requestCreator;
  private Staff requestResolver;
  private LocalDateTime creationTime;
  private String title;
  private ArrayList<String> comments;
  static private ArrayList<Request> requests = new ArrayList<Request>();

  public Request(Student requestCreator, LocalDateTime creationTime, String title) {
    requests.add(this);
    this.requestId = requests.size();
    this.isResolved = false;
    this.satisfactionPoints = 0;
    this.requestCreator = requestCreator;
    this.requestResolver = new Staff();
    this.creationTime = LocalDateTime.now();
    this.title = title;
    this.comments = new ArrayList<String>();
  }

  public int getRequestId() {
    return this.getRequestId();
  }

  public void setRequestId(int requestId) {
    this.requestId = requestId;
  }

  public boolean getIsResolved() {
    return this.isResolved;
  }

  public void setIsResolved(boolean isResolved) {
    this.isResolved = isResolved;
  }

  public int getSatisfactionPoints() {
    return this.satisfactionPoints;
  }

  public void setSatisfactionPoints(int satisfactionPoints) {
    if (satisfactionPoints >= 0 && satisfactionPoints <= 5 && this.isResolved) {
      this.satisfactionPoints = satisfactionPoints;
    }
  }

  public Student getRequestCreator() {
    return this.requestCreator;
  }

  public void setRequestCreator(Student requestCreator) {
    this.requestCreator = requestCreator;
  }

  public Staff getRequestResolver(Staff requestResolver) {
    return this.requestResolver;
  }

  public void setRequestResolver(Staff requestResolver) {
    this.requestResolver = requestResolver;
  }

  public LocalDateTime getCreationTime() {
    return this.creationTime;
  }

  public void setCreationTime(LocalDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ArrayList<String> getComments() {
    return this.comments;
  }

  public void addAComment(String comment) {
    this.comments.add(comment);
  }

  public static ArrayList<Request> getRequests() {
    return requests;
  }

  public String toString() {
    String allComments = "";

    for (int i = 0; i != this.comments.size(); i += 1) {
      allComments += this.comments.get(i) + '\n';
    }

    return "Request:\n"
    + String.format("ID: %d, Title: %s, Resolved: %s, Creation Time: %s, Satisfaction: %d\n", this.requestId, this.title, this.isResolved ? "Yes" : "No", this.creationTime.toString(), this.satisfactionPoints)
    + String.format("Creator: ", this.requestCreator.toString())
    + String.format("Resolver: ", this.requestResolver.toString())
    + "Comments\n"
    + allComments;
  }
}
