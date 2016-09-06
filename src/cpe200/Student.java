package cpe200;

public class Student {
    protected static final String DEFAULT_NAME = "John Doe";
    protected static final String DEFAULT_ID = "560610000";
    protected static final int DEFAULT_YEAR = 1990;
    protected static final boolean DEFAULT_ACTIVE = false;
    private String name;
    private String id;
    private int year;
    private boolean active;
    public Student() {
        this.name = DEFAULT_NAME;
        this.id = DEFAULT_ID;
        this.year = DEFAULT_YEAR;
        this.active = DEFAULT_ACTIVE;
    }

    public Student(String name,String ID)
    {
        this.name = name;

        if(isValidStudent_id(ID)){
            this.id = ID;
            }
        else {this.id = DEFAULT_ID;}


        this.year = DEFAULT_YEAR;
        this.active = DEFAULT_ACTIVE;
    }
    public Student(String name,String ID,int year)
    {
        this.name = name;
        if(isValidStudent_id(ID)){
            this.id = ID;
        }
        else {this.id = DEFAULT_ID;}
        if(isValidYOB(year)) {
            this.year = year;
        }
        else {
            this.year = DEFAULT_YEAR;
        }
        this.active = DEFAULT_ACTIVE;
    }
    public Student(String name,String ID,int year,boolean active)
    {
        this.name = name;
        if(isValidStudent_id(ID)){
            this.id = ID;
        }
        else {this.id = DEFAULT_ID;}
        if(isValidYOB(year)) {
            this.year = year;
        }
        else {
            this.year = DEFAULT_YEAR;
        }
        this.active = active;
    }
    // implement all missing constructors here

    // implement all get and set methods here

    @Override
    public String toString() {
        String status ;
        if(this.active == true)
        {
            status = "ACTIVE";
        }
        else {
            status = "INACTIVE";
        }

        String o = this.name+" "+"("+this.id+")"+" was born in "+this.year+" is an "+status+" student." ;

        return o;
    }

    public String getStudent_id()
    {
        return  this.id;
    }
    public int getYearOfBirth(){return this.year;}
    public boolean isActive(){
        return this.active;
    }


    private boolean isValidStudent_id(String id) {
        if(id.length() > 9)
        {
            return  false;
        }
        int int_id;
        int_id = Integer.parseInt(id);
        int a = int_id / 10000000;
        int c = int_id / 1000;
        c = c % 10;
        int d = int_id % 1000;


        if (a >= 56 && a <= 59 && c >= 0 && c < 3 && d >= 0 && d <= 2999) {
             return true;
        }
       else {
           return  false;
        }

    }

    private boolean isValidYOB(int yob)
    {
        if(yob >1990) {
            return  true;
        }
        else {
            return  false;
        }
    }

    public void getname(String name)
    {
        this.name = name;
    }


    public void setName(String name) {
        if(name == " ") {
            this.name = name;
        }
    }

    public void setStudent_id(String student_id) {
        if(isValidStudent_id(student_id)){
            this.id = student_id;
        }



    }

    public void setYearOfBirth(int yearOfBirth) {
        if(isValidYOB(yearOfBirth)) {
            this.year = yearOfBirth;
        }

    }

    public String getName() {
        return this.name;
    }
}