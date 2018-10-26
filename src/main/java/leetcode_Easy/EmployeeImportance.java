package leetcode_Easy;

import java.util.List;

/*690 You are given a data structure of employee information, which includes
the employee's unique id, his importance value and his direct subordinates' id.
For example, employee 1 is the leader of employee 2, and employee 2 is the
leader of employee 3. They have importance value 15, 10 and 5, respectively.
Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has
[2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is
also a subordinate of employee 1, the relationship is not direct. Now given the
employee information of a company, and an employee id, you need to return the
total importance value of this employee and all his subordinates.
Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1		Output: 11
Employee 1 has importance value 5, and he has two direct s					 */

public class EmployeeImportance {
	/*public int getImportance(List<Employee> employees, int id) {
		int result = 0;
		
		for (int i = 0; i < employees.size(); i++) {
			
			if (id == employees.get(i).id) {
				
				result += employees.get(i).importance;
				
				for (int j = 0; j < employees.get(i).subordinates.size(); j++) {
					result += getImportance(employees, employees.get(i).subordinates.get(j));
				}
			}
		}
		return result;
	}*/
}
