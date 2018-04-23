package ie.uulster;

class Student
{
    public Student (String name, int mark, String grade, String stuID)
    {
        this.name= name;
        this.mark= mark;
        this.grade= grade;
        this.stuID= stuID;
    }
    private String name;
    private int mark;
    private String grade;
    private String stuID;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mark
	 */
	public int getMark() {
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the iD
	 */
	public String getStuID() {
		return stuID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

}