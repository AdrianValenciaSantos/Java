import java.util.ArrayList;

public class Classes {
	
	private ArrayList<Double> grades;
	private String className;
	
	// Constructor method
	public Classes(String name) {
		this.grades = new ArrayList<Double>();
		this.className = name;
	}
	
	// Mutator method -> adds score //
	public void addGrade(double score) {
		this.grades.add(score);
	}
	
	// Returns the grades of a class
	public String getGrades() {
		return this.grades.toString();
	}
	
	// Returns the name of the class
	public String getName() {
		return this.className;
	}
	
	// Returns averal score of all classes
	public double getAverage() {
		double sum = 0;
		for(int i = 0; i < grades.size(); i++) {
			sum += this.grades.get(i);
		}
		return Math.round(sum/this.grades.size());
	}
	
	// Returns minimum score
	public double getMin() {
		if(grades.size() == 0) {
			return -1;
		}
		double min = this.grades.get(0);
		for(int i = 1; i < grades.size(); i++) {
			if(this.grades.get(i) < min) {
				min = this.grades.get(i);
			}
		}
		return min;
	}
	
	// Returns maximum score
	public double getMax() {
		if(grades.size() == 0) {
			return -1;
		}
		double max = this.grades.get(0);
		for(int i = 1; i < grades.size(); i++) {
			if(this.grades.get(i) > max) {
				max = this.grades.get(i);
			}
		}
		return max;
	}
	
	// Returns array list
	public ArrayList<Double> getScores(){
		return this.grades;
	}
	
  // Clears grades
	public void clearGrades() {
		this.grades.clear();
	}
	
	
}
