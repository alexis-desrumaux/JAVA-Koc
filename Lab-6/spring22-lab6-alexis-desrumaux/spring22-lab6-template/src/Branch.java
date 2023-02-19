

public class Branch {
	
	
	//TODO: add variables and the constructor
	
	//TODO: implement printTrainings method
	
	//TODO implement printCommonEngineers method
	
	public void addEngineer(Engineer i) {
		engineers.add(i);
		i.addBranch(this);
	}
	
	public void addIntern(Intern s) {
		interns.add(s);
	}
	
	public void addTraining(Training c) {
		offeredTrainings.add(c);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public List<Engineer> getEngineers() {
		return engineers;
	}

	public void setEngineers(List<Engineer> engineers) {
		this.engineers = engineers;
	}
	public void printInterns() {
		System.out.printf("\nInterns in the %s branch: \n", this.name);
		for (Intern i:interns) 
			System.out.println(i);
	}

}
