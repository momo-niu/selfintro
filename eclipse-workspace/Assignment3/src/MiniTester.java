import java.util.Iterator;
import java.util.NoSuchElementException;

public class MiniTester 
{	
	int scale = 2;
	String packageName;

	private String gradeString(int score, int maxScore, String comment)
	{
		return comment + "Score: " + Integer.toString(score * scale) + "/" + Integer.toString(maxScore * scale);
	}

	private void write(String string)
	{
		System.out.print(string + "\n");
	}

	public MiniTester()
	{
		Package p = MiniTester.class.getPackage();
		packageName = p != null ? p.getName() + "" : "";
	}

	
	//----------------------------------------------------------------------------------------------------------------------------------------
	//ADD CAT 12
	
	private int test_addCat_0(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test addCat where cat to add is senior to c and c.senior == null.\n";
		int maxScore = 2;
		int grade = 0;

		try {			
			
			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo b = new CatInfo("B", 85, 60, 240, 30);
			CatTree t = new CatTree(a);
			t.addCat(b);

			if (t.root.data.equals(a) && t.root.senior.data.equals(b)) {
				grade += 2;
			} else {
				comment = comment + "Error: structure of tree is wrong when adding a more senior cat and c.senior == null.\n";
			}

			write(gradeString(grade, maxScore, comment));

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}


	private int test_addCat_1(int testIdx) 
	{
		String comment = "[" + testIdx + "]:  Test addCat where cat to add is senior to c and c.senior != null.\n";
		int maxScore = 2;
		int grade = 0;

		try {

			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo b = new CatInfo("B", 85, 60, 240, 30);
			CatInfo g = new CatInfo("G", 85, 50, 247, 27);
			CatTree t = new CatTree(a);
			t.addCat(b);
			t.addCat(g);

			if (t.root.data.equals(a) && t.root.senior.data.equals(b) && t.root.senior.same.data.equals(g)) {
				grade += 2;
			} else {
				comment = comment + "Error: structure of tree is wrong when adding a more senior cat and c.senior != null.\n";
			}

			write(gradeString(grade, maxScore, comment));

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}

	private int test_addCat_2(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test addCat where cat to add is junior to c and c.junior == null.\n";
		int maxScore = 2;
		int grade = 0;

		try {
			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo c = new CatInfo("C", 88, 70, 248, 10);
			CatTree t = new CatTree(a);
			t.addCat(c);

			if (t.root.data.equals(a) && t.root.junior.data.equals(c)) {
				grade += 2;
			} else {
				comment = comment + "Error: structure of tree is wrong when adding a more junior cat and c.junior == null.\n";
			}

			write(gradeString(grade, maxScore, comment));

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
		
		
	}

	private int test_addCat_3(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test addCat where cat to add is junior to c and c.junior != null.\n";
		int maxScore = 2;
		int grade = 0;

		try {

			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo c = new CatInfo("C", 88, 70, 248, 10);
			CatInfo d = new CatInfo("D", 95, 55, 245, 50);
			CatTree t = new CatTree(a);
			t.addCat(c);
			t.addCat(d);

			if (t.root.data.equals(a) && t.root.junior.data.equals(c) && t.root.junior.junior.data.equals(d)) {
				grade += 2;
			} else {
				comment = comment + "Error: structure of tree is wrong when adding a more junior cat and c.junior != null.\n";
			}

			write(gradeString(grade, maxScore, comment));

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}

	private int test_addCat_4(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test addCat where cat to add has same seniority as c and is fluffier than c.\n";
		int maxScore = 2;
		int grade = 0;

		try {

			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo e = new CatInfo("E", 87, 55, 245, 20);
			CatTree t = new CatTree(a);
			t.addCat(e);

			if (t.root.data.equals(e) && t.root.same.data.equals(a)) {
				grade += 2;
			} else {
				comment = comment + "Error: structure of tree is wrong when adding a cat with the same seniority that is fluffier.\n";
			}

			write(gradeString(grade, maxScore, comment));

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}

	private int test_addCat_5(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test addCat where cat to add has same seniority to c and is less fluffy.\n";
		int maxScore = 2;
		int grade = 0;

		try {
			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo i = new CatInfo("I", 87, 45, 245, 20);
			CatTree t = new CatTree(a);
			t.addCat(i);

			if (t.root.data.equals(a) && t.root.same.data.equals(i)) {
				grade += 2;
			} else {
				comment = comment + "Error: structure of tree is wrong when adding a cat with the same seniority that is less fluffy.\n";
			}

			write(gradeString(grade, maxScore, comment));


		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}


	//----------------------------------------------------------------------------------------------------------------------
	//REMOVE CAT 22

	private int test_removeCat_0(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test removeCat when Node to remove is at root.\n";
		int maxScore = 4;
		int grade = 0;

		try {

			/*
			1. Node not in the tree		1
			2. at root (simple case)	3
			*/
			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo b = new CatInfo("B", 85, 60, 240, 30);
			CatInfo c = new CatInfo("C", 88, 70, 248, 10);
			
			CatTree t = new CatTree(a);
			t.addCat(b);
			
			t.removeCat(c);	//nothing should change since c not in tree
			
			if (t.root.data.equals(a) && t.root.senior.data.equals(b) && t.root.same == null && t.root.junior == null) {
				grade += 1;
			} else {
				comment = comment + "Error: removeCat changes the structure of the tree in some way when the cat to remove isn't in the tree.\n";
			}
			
			t.removeCat(a);
			
			if (t.root.data.equals(b) && t.root.same == null && t.root.senior == null && t.root.junior == null) {
				grade += 3;
			} else{
				comment = comment + "Error: unexpected tree structure when removing the root of a tree.\n";
			}

			write(gradeString(grade, maxScore, comment));	

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}

	private int test_removeCat_1(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test removeCat when same != null.\n";
		int maxScore = 6;
		int grade = 0;

		try {
			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo b = new CatInfo("B", 85, 60, 240, 30);
			CatInfo c = new CatInfo("C", 88, 70, 248, 10);
			CatInfo e = new CatInfo("E", 88, 55, 245, 20);
			
			CatTree t = new CatTree(a);
			t.addCat(b);
			t.addCat(c);
			t.addCat(e);
			
			t.removeCat(c);
			
			if (t.root.data.equals(a) && t.root.senior.data.equals(b) && t.root.junior.data.equals(e)) {
				grade += 6;
			} else {
				comment = comment + "Error: unexpected tree structure when removing an internal node when same != null.\n";
			}
			
			write(gradeString(grade, maxScore, comment));	
			
		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}

	//----------------------------------------------------------------------------------------------------------------------
	//MOST SENIOR

	private int test_mostSenior_0(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test mostSenior when c.senior == null\n";
		int maxScore = 4;
		int grade = 0;

		try {
			
			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo c = new CatInfo("C", 88, 70, 248, 10);
			CatInfo d = new CatInfo("D", 95, 55, 245, 50);
			CatInfo e = new CatInfo("E", 87, 55, 245, 20);
						
			CatTree t = new CatTree(a);
			t.addCat(c);
			t.addCat(d);
			t.addCat(e);
			
			int most = t.mostSenior();
			if (most == 87) {
				grade += 4;
			} else {
				comment = comment + "Error: MostSenior is incorrect when c.senior == null.\n";
			}
			
			write(gradeString(grade, maxScore, comment));	

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}


	//----------------------------------------------------------------------------------------------------------------------
	//FLUFFIEST

	private int test_fluffiest_0(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test fluffiest when root is fluffiest.\n";
		int maxScore = 3;
		int grade = 0;

		try {
			CatInfo a = new CatInfo("A", 87, 50, 243, 40);
			CatInfo b = new CatInfo("B", 85, 60, 240, 30);
			CatInfo c = new CatInfo("C", 88, 70, 248, 10);
			CatInfo d = new CatInfo("D", 95, 55, 245, 50);
			CatInfo e = new CatInfo("E", 87, 55, 245, 20);
			CatInfo f = new CatInfo("F", 86, 55, 247, 15);
			CatInfo g = new CatInfo("G", 85, 50, 247, 27);
			CatInfo h = new CatInfo("H", 85, 45, 247, 100);
						
			CatTree t = new CatTree(a);
			t.addCat(b);
			t.addCat(c);
			t.addCat(d);
			t.addCat(e);
			t.addCat(f);
			t.addCat(g);
			t.addCat(h);
			
			int most = t.root.senior.fluffiest();
			if (most == 60) {
				grade += 3;
			} else {
				comment = comment + "Error: fluffiest is incorrect when the root is the fluffiest.";
			}
			
			write(gradeString(grade, maxScore, comment));	



		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}


	//----------------------------------------------------------------------------------------------------------------------
	//HIREDFORMONTHS
	private int test_hired_0(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test hiredFromMonths when Cat is in c.junior.\n";
		int maxScore = 2;
		int grade = 0;

		try {
			CatInfo a = new CatInfo("A", 100, 40, 243, 40);
			CatInfo b = new CatInfo("B", 50, 60, 240, 30);
			CatInfo c = new CatInfo("C", 125, 75, 248, 10);
			CatInfo d = new CatInfo("D", 100, 15, 245, 50);
			CatInfo e = new CatInfo("E", 40, 25, 245, 20);
			CatInfo f = new CatInfo("F", 50, 35, 247, 15);
			CatInfo g = new CatInfo("G", 75, 40, 247, 27);
			CatInfo h = new CatInfo("H", 100, 50, 247, 27);
			CatInfo i = new CatInfo("I", 110, 65, 247, 100);
			CatInfo j = new CatInfo("J", 125, 75, 247, 100);
			CatInfo k = new CatInfo("K", 130, 15, 247, 100);
						
			CatTree t = new CatTree(a);
			t.addCat(b);
			t.addCat(c);
			t.addCat(d);
			t.addCat(e);
			t.addCat(f);
			t.addCat(g);
			t.addCat(h);
			t.addCat(i);
			t.addCat(j);
			t.addCat(k);
			
			int num = t.root.hiredFromMonths(130, 130);
			if (num == 1) {
				grade += 2;
			} else {
				comment = comment + "Error: hiredFromMonths when Cat is in junior branch.\n";
			}
			
			write(gradeString(grade, maxScore, comment));	

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}
	
	private int test_hired_1(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test hiredFromMonths when Cat is in c.same.\n";
		int maxScore = 2;
		int grade = 0;

		try {
			CatInfo a = new CatInfo("A", 100, 40, 243, 40);
			CatInfo b = new CatInfo("B", 50, 60, 240, 30);
			CatInfo c = new CatInfo("C", 125, 75, 248, 10);
			CatInfo d = new CatInfo("D", 100, 15, 245, 50);
			CatInfo e = new CatInfo("E", 40, 25, 245, 20);
			CatInfo f = new CatInfo("F", 50, 35, 247, 15);
			CatInfo g = new CatInfo("G", 75, 40, 247, 27);
			CatInfo h = new CatInfo("H", 100, 50, 247, 27);
			CatInfo i = new CatInfo("I", 110, 65, 247, 100);
			CatInfo j = new CatInfo("J", 125, 75, 247, 100);
			CatInfo k = new CatInfo("K", 130, 15, 247, 100);
						
			CatTree t = new CatTree(a);
			t.addCat(b);
			t.addCat(c);
			t.addCat(d);
			t.addCat(e);
			t.addCat(f);
			t.addCat(g);
			t.addCat(h);
			t.addCat(i);
			t.addCat(j);
			t.addCat(k);
			
			int num = t.root.hiredFromMonths(100, 100);
			if (num == 3) {
				grade += 2;
			} else {
				comment = comment + "Error: hiredFromMonths when Cat is in same branch.\n";
			}
			
			write(gradeString(grade, maxScore, comment));	

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}
	
	//----------------------------------------------------------------------------------------------------------------------
	//FLUFFIESTFROMMONTH
	private int test_fluffyFrom_0(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test fluffiestFromMonth when Cat is in the 'same' branch.\n";
		int maxScore = 2;
		int grade = 0;

		try {
			CatInfo a = new CatInfo("A", 100, 40, 243, 40);
			CatInfo b = new CatInfo("B", 50, 60, 240, 30);
			CatInfo c = new CatInfo("C", 125, 75, 248, 10);
			CatInfo d = new CatInfo("D", 100, 15, 245, 50);
			CatInfo e = new CatInfo("E", 40, 25, 245, 20);
			CatInfo f = new CatInfo("F", 50, 35, 247, 15);
			CatInfo g = new CatInfo("G", 75, 40, 247, 27);
			CatInfo h = new CatInfo("H", 100, 50, 247, 27);
			CatInfo i = new CatInfo("I", 110, 65, 247, 100);
			CatInfo j = new CatInfo("J", 125, 75, 247, 100);
			CatInfo k = new CatInfo("K", 130, 15, 247, 100);
						
			CatTree t = new CatTree(a);
			t.addCat(b);
			t.addCat(c);
			t.addCat(d);
			t.addCat(e);
			t.addCat(f);
			t.addCat(g);
			t.addCat(h);
			t.addCat(i);
			t.addCat(j);
			t.addCat(k);
			
			CatInfo ret = t.root.fluffiestFromMonth(100);
			if (ret.equals(h)) {
				grade += 2;
			} else {
				comment = comment + "Error: fluffiestFromMonth when Cat is in the 'same' branch.\n";
			}
			
			write(gradeString(grade, maxScore, comment));	

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}
	
	//----------------------------------------------------------------------------------------------------------------------
	//COSTPLANNING
	private int test_costPlan_0(int testIdx) 
	{
		String comment = "[" + testIdx + "]: Test costPlanning - test 0.\n";
		int maxScore = 2;
		int grade = 0;

		try {
			CatInfo a = new CatInfo("A", 100, 40, 243, 20);
			CatInfo c = new CatInfo("C", 125, 75, 248, 20);
			CatInfo d = new CatInfo("D", 100, 15, 245, 20);
									
			CatTree t = new CatTree(a);
			t.addCat(c);
			t.addCat(d);
						
			int []plan = t.root.costPlanning(75);
			if (plan.length == 75) {
				grade += 2;
			} else {
				comment = comment + "Error: costPlanning did not return an array of required size.\n";
			}
						
			write(gradeString(grade, maxScore, comment));	

		} catch (Exception e) {
			comment = comment + "Exception Found: " + e.toString() + "\n";
			e.printStackTrace();
			write(gradeString(0, maxScore, comment));
		}

		return grade;
	}

	public static void main(String[] args) 
	{
		MiniTester m = new MiniTester();
		int total = 0;

		//ADD CAT
		total += m.test_addCat_0(0);
		total += m.test_addCat_1(1);
		total += m.test_addCat_2(2);
		total += m.test_addCat_3(3);
		total += m.test_addCat_4(4);
		total += m.test_addCat_5(5);

		//REMOVE CAT
		total += m.test_removeCat_0(6);
		total += m.test_removeCat_1(7);

		//MOST SENIOR
		total += m.test_mostSenior_0(8);

		//FLUFFIEST
		total += m.test_fluffiest_0(9);

		//HIRED FROM MONTHS
		total += m.test_hired_0(10);
		total += m.test_hired_1(11);

		//FLUFFIEST FROM MONTH
		total += m.test_fluffyFrom_0(12);

		//COST PLANNING
		total += m.test_costPlan_0(13);
		
		//m.write(m.gradeString(total, 50, "Your Final Tester "));
	}
}

