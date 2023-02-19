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

package main;

import kurequest.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

	public static ArrayList<ITRequest> findITRequestsbyDate(ArrayList<ITRequest> requests, LocalDateTime start,
			LocalDateTime end) {
		ArrayList<ITRequest> sortedITRequests = new ArrayList<ITRequest>();
		for (int i = 0; i != requests.size(); i += 1) {
			if (requests.get(i).getCreationTime().isBefore(end) && requests.get(i).getCreationTime().isAfter(start)) {
				sortedITRequests.add(requests.get(i));
			}
		}
		return sortedITRequests;
	}

	public static void averageStaffPoints(ArrayList<Staff> staffs) {
		for (int i = 0; i != staffs.size(); i += 1) {
			ArrayList<Request> requests = staffs.get(i).getRequests();
			int requestResolvedNumber = 0;
			float total = 0;
			for (int j = 0; j != requests.size(); j += 1) {
				if (requests.get(j).getIsResolved() == true) {
					total += requests.get(j).getSatisfactionPoints();
					requestResolvedNumber += 1;
				}
			}
			float average = total / requestResolvedNumber;
			System.out.printf("Average satisfaction points of staff %s: %.1f\n", staffs.get(i).getStaffName(), average);
		}
	}

	public static void main(String[] args) {

		Student student1 = new Student("Dogan Sagbili", "Engineering");
		Student student2 = new Student("Alexis Desrumaux", "Computer Engineering");

		Staff staff1 = new Staff("Can Kucuksozen", "Housing", "Coordinator");
		Staff staff2 = new Staff("Vahideh Hayyolalam", "IT", "Technician");
		Staff staff3 = new Staff("Oyku Bayramoglu", "IT", "Coordinator");

		HousingRequest Hrequest1 = student1.openHousingRequest(1,
				LocalDateTime.of(2022, 3, 10, 14, 45), "Request for Deposit Reimbursement", "Main Campus", "B 230");
		HousingRequest Hrequest2 = student2.openHousingRequest(0,
				LocalDateTime.of(2022, 2, 5, 12, 00), "Noise Complaint", "West Campus", "A2 419");

		ITRequest ITrequest1 = student1.openITRequest(2, LocalDateTime.of(2022, 2, 12, 13, 30), "Projector Broke",
				"ENG Z50", null, 0);
		ITRequest ITrequest2 = student2.openITRequest(2, LocalDateTime.of(2022, 1, 20, 15, 00), "Computer does not open",
				"SOS B20", null, 0);
		ITRequest ITrequest3 = student1.openITRequest(1, LocalDateTime.of(2022, 1, 28, 16, 30), "Cannot open Eclipse", null,
				"Dogan's PC", 342341214);
		ITRequest ITrequest4 = student2.openITRequest(1, LocalDateTime.of(2022, 12, 30, 9, 15), "Install new OS", null,
				"Alexis Desrumaux's PC", 128479180);

		staff1.assignRequest(Hrequest1);
		staff1.assignRequest(Hrequest2);

		staff2.assignRequest(ITrequest1);
		staff2.assignRequest(ITrequest3);

		staff3.assignRequest(ITrequest2);
		staff3.assignRequest(ITrequest4);

		student1.addCommentToRequest(1, "I have graduated, PLease, give my money back.");
		student1.addCommentToRequest(2, "It is Urgent, Need to teach my classmates with the projector.");
		student1.addCommentToRequest(3, "I need to finish my Comp 132 lab, Please !!");

		student2.addCommentToRequest(1,
				"At 420 they having a massive party, I need to study so, can they please lower it down?");
		student2.addCommentToRequest(2, "My projects and classes noooo!!!");
		student2.addCommentToRequest(3, "I hate windows please install Linux thx.");

		staff1.addCommentToRequest(1, "Your money is given to your account.");
		staff1.closeRequest(1);

		staff1.addCommentToRequest(2,
				"Exams are over since a week ago, please give yourself a break and join them if you want.");
		staff1.closeRequest(2);

		staff2.addCommentToRequest(1, "Fixed.");
		staff2.closeRequest(1);

		staff2.addCommentToRequest(2, "Installed Java JDK for you. it works now, pick it up from IT");
		staff2.closeRequest(2);

		staff3.addCommentToRequest(1, "Bring it to IT. Let's see what is wrong.");
		staff3.closeRequest(1);

		staff3.addCommentToRequest(2, "Alright bring to IT, will take about 30 min.");
		staff3.closeRequest(2);

		student1.giveSatisfactionPoints(1, 5);
		student2.giveSatisfactionPoints(1, 0);

		student1.giveSatisfactionPoints(2, 4);
		student2.giveSatisfactionPoints(2, 5);

		student1.giveSatisfactionPoints(3, 3);
		student2.giveSatisfactionPoints(3, 4);

		for (Request request : Request.getRequests()) {
			System.out.println(request + "\r\n\n");
		}
		averageStaffPoints(staff1.getAllStaff());
	}
}
