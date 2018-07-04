package leetcode_Easy;

/*551 You are given a string representing an attendance record for a student.
The record only contains the following three characters:
'A' : Absent.		'L' : Late.			'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than
one 'A' (absent) or more than two continuous 'L' (late). You need to return
whether the student could be rewarded according to his attendance record.
Input: "PPALLP"		Output: True
Input: "PPALLL"		Output: False											 */

public class StudentAttendanceRecordI {
	
	public boolean checkRecord(String stringInput) {
		
		return stringInput.indexOf("A") == stringInput.lastIndexOf("A") 
				&& !stringInput.contains("LLL");
	}
}
