/* *********** Pledge of Honor ************************************************ *
I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: Alexis Desrumaux, 0078296
********************************************************************************/

public class Main {

	public static void main(String[] args) {

		Branch tech = new Branch("Tech", "Technology");
		Branch man = new Branch("Man", "Management");
		Branch eth = new Branch("Eth", "Ethic");
		
		Engineer engineer1 = new Engineer("James Kelly", "Mr");
		Engineer engineer2 = new Engineer("Muhammed Noori", "Mr");
		Engineer engineer3 = new Engineer("Ali Yilmaz", "Mr");
		Engineer engineer4 = new Engineer("Cem Ege", "Mr");
		Engineer engineer5 = new Engineer("Kemal Gul", "Mr");
		Engineer engineer6 = new Engineer("Murat Yildirim", "Mr");
		
		tech.addEngineer(engineer1);
		man.addEngineer(engineer1);
		tech.addEngineer(engineer2);
		tech.addEngineer(engineer3);
		tech.addEngineer(engineer4);
		man.addEngineer(engineer6);
		eth.addEngineer(engineer5);

		Intern intern1 = new Intern("John Wick", "2");
		Intern intern2 = new Intern("Rogan Roy", "1");
		Intern intern3 = new Intern("Walter White", "0");
		Intern intern4 = new Intern("Bobby Axelrod", "3");
		Intern intern5 = new Intern("Elaine Benes", "4");
		Intern intern6 = new Intern("Luna Lovegood", "9");
		Intern intern7 = new Intern("Michael Scott", "8");
		Intern intern8 = new Intern("Chandler Bing", "7");
		Intern intern9 = new Intern("Cosmo Kramer", "6");
		Intern intern10 = new Intern("George Constanza", "5");
		
		tech.addIntern(intern1);
		tech.addIntern(intern2);
		tech.addIntern(intern3);
		tech.addIntern(intern4);
		man.addIntern(intern5);
		man.addIntern(intern6);
		man.addIntern(intern7);
		eth.addIntern(intern8);
		eth.addIntern(intern9);
		eth.addIntern(intern10);
		
		Training training1 = new Training("ICDL", "Tech01", "Fall21", engineer2, tech, 5, 4);
		Training training2 = new Training("E-commerce", "Tech02", "Spring21", engineer2, tech, 2, 4);
		Training training3 = new Training("IT management", "Tech03", "Fall21", engineer3, tech, 5, 2);
		Training training4 = new Training("Network", "Tech04", "Spring21", engineer4, tech, 2, 3);
		Training training5 = new Training("IT management", "man104", "Spring21", engineer5, man, 4, 5);
		Training training6 = new Training("sales and marketing ethic", "man104", "Spring21", engineer6, eth, 4, 5);

		
		intern1.enroll(training1);
		intern1.enroll(training2);
		intern1.enroll(training3);
		intern1.enroll(training5);
		intern5.enroll(training1);
		intern5.enroll(training2);
		intern5.enroll(training5);
		intern2.enroll(training2);
		intern2.enroll(training6);
		intern10.enroll(training4);
		intern10.enroll(training5);
		intern10.enroll(training6);

		intern1.addGrade(training1, 4.0);
		intern1.addGrade(training2, 3.5);
		intern1.addGrade(training3, 3.0);
		intern1.addGrade(training5, 3.0);
		
		System.out.println();
		System.out.printf("Intern %s SPA grade in term %s: %f\n", intern1.getName(), "Fall21", intern1.calculateSPA("Fall21"));
		System.out.printf("Intern %s SPA grade in term %s: %f\n", intern1.getName(), "Spring21", intern1.calculateSPA("Spring21"));
		intern1.unenroll(training2);
		System.out.printf("Intern %s SPA grade in term %s: %f\n", intern1.getName(), "Spring21", intern1.calculateSPA("Spring21"));

		tech.printTrainings();
		man.printTrainings();
		eth.printTrainings();
		
		tech.printInterns();
		man.printInterns();
		eth.printInterns();
		
		tech.printCommonEngineers(man);
		man.printCommonEngineers(tech);
		tech.printCommonEngineers(eth);
		
	

	}

}
