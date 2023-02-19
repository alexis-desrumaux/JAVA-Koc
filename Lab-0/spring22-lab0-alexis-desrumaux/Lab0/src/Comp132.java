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

import java.io.*;
import java.util.*;

public class Comp132 {

	public static void main(String[] args) {

		String id = "<alexis-desrumaux-0078296>";

		for (int i = 0; i != id.length(); i += 1) {
			System.out.printf("%d\n", (int)id.charAt(i));
		}
	}

}
