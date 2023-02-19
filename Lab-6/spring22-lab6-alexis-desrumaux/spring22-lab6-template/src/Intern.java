import java.util.*;

public class Intern {
  private String name;
  private String ID;
  private Map<String, Double> grades;
  private ArrayList<Training> takenTrainings;

  public Intern(String name, String ID) {
    this.name = name;
    this.ID = ID;
    this.grades = new HashMap<>();
    this.takenTrainings = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getID() {
    return this.ID;
  }

  public void setID(String id) {
    this.ID = id;
  }

  public Map<String, Double> getGrades() {
    return this.grades;
  }

  public void setGrades(Map<String, Double> grades) {
    this.grades = grades;
  }

  public ArrayList<Training> getTakenTrainings() {
    return this.takenTrainings;
  }

  public void setTakenTrainings(ArrayList<Training> takenTrainings) {
    this.takenTrainings = takenTrainings;
  }

  public void enroll(Training c) {
    this.takenTrainings.add(c);
    c.addIntern(this);
    this.grades.put(c.getCode(), c.getCredits());
  }

  public void unenroll(Training c) {
    int selectIndex = -1;

    for (int i = 0; i != this.takenTrainings.size(); i += 1) {
      if (this.takenTrainings.get(i).getCode() == c.getCode()) {
        selectIndex = i;
        break;
      }
    }

    if (selectIndex == -1) {
      return;
    }
    this.takenTrainings.remove(selectIndex);
    
  }
}
