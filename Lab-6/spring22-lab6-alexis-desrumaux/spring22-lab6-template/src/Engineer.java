import java.util.ArrayList;
import java.util.List;

// NOTE: Do not modify this class.
public class Engineer {
	
	private String name;
	private String title;
	private List<Branch> branches;
	private List<Training> trainings;
	
	
	public Engineer(String name, String title) {
		super();
		this.name = name;
		this.title = title;
		branches = new ArrayList<Branch>();
		trainings = new ArrayList<Training>();
	}


	public void addBranch(Branch d) {
		branches.add(d);
	}
	
	public void addTraining(Training c) {
		trainings.add(c);
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return title + ". " + name;
	}
	
	
	

}
