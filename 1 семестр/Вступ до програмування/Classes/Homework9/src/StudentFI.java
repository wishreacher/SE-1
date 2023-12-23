public class StudentFI extends Student{

    /**
     * StudentFI class constructor with no parameters. Sets name and faculty to default values
     */
    public StudentFI(){
        super();
        depressionLevel = 1;
        drugOfChoice = "alcohol";
    }

    /**
     * StudentFI class constructor with 3 parameters.
     *
     * @param name student's name
     * @param faculty student's faculty
     * @param drugOfChoice student's drug of choice
     */
    public StudentFI(String name, String faculty, String drugOfChoice){
        super(name, faculty);
        this.drugOfChoice = drugOfChoice;
    }

    /**
     * Increases student's depression level by 69
     */
    public void increaseDepressionLevel(){
        depressionLevel += 69;
    }

    /**
     * Returns student's depression level
     * @return
     */
    public int getDepressionLevel(){
        return depressionLevel;
    }

    /**
     * Overrides the toString() method to return student's name,
     * faculty, year of study, depression level and drug of choice
     */
    public String toString(){
        return super.toString() + " and is depressed at level " +
                depressionLevel + " and uses " + drugOfChoice;
    }

    private int depressionLevel = 1;
    private String drugOfChoice;
}
