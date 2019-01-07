package leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

public class UniqueEmailAddressesBeck {
	public int uniqueEmailAddress(String[] emails) {

		List<String> modEmails = new ArrayList<>();

		for (String email : emails) {

			for (int i = 0; i < email.length(); i++) {

				String localName = null;

				char c = email.charAt(i);

				if (c == '@') {
					modEmails.add(localName);
				} else {

					if (c == '+') {

						localName = "";
					} else {

						localName += c;
					}
				}
			}
		}
		return 0;
	}
}
