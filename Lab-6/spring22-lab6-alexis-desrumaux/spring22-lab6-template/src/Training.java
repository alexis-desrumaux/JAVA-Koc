import java.util.*;

public class Training {
  private String name;
  private String code;
  private String term;
  private Engineer engineer;
  private Branch branch;
  private int capacity;
  private double credits;
  public ArrayList<Intern> interns;
  public ArrayList<Intern> waitlist;

  public Training(String name, String code, String term, Engineer engineer, Branch branch, int capacity,
      double credits) {
    this.name = name;
    this.code = code;
    this.term = term;
    this.engineer = engineer;
    this.branch = branch;
    this.capacity = capacity;
    this.credits = credits;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getTerm() {
    return this.term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public Engineer getEngineer() {
    return this.engineer;
  }

  public void setEngineer(Engineer engineer) {
    this.engineer = engineer;
  }

  public Branch getBranch() {
    return this.branch;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public double getCredits() {
    return this.credits;
  }

  public boolean addIntern(Intern intern) {
    if (capacity == this.interns.size()) {
      this.waitlist.add(intern);
      return false;
    }
    this.interns.add(intern);
    return true;
  }

  public boolean removeIntern(Intern intern) {
    boolean result = this.interns.remove(intern);
    if (result == false)
      return false;
    if (this.waitlist.size() != 0) {
      this.interns.add(this.waitlist.get(0));
      this.waitlist.remove(0);
      return true;
    }
    return true;
  }

}
