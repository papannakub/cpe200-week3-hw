package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {
    protected static final String DEFAULT_NAME = "TBA";
    protected static final String DEFAULT_CID = "000000";
    protected static final String DEFAULT_LECTURER = "TBA";
    protected static final int DEFAULT_MAX= 30;
    protected static final int DEFAULT_CURRENT = 0;
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;
    public Course() {
        this.course_name = DEFAULT_NAME;
        this.course_id = DEFAULT_CID;
        this.lecturer = DEFAULT_LECTURER;
        this.max_students = DEFAULT_MAX;
        this.no_students = DEFAULT_CURRENT;

    }

    public Course(String n, String cid) {
        this.course_name = n;
        if(isValidCourse_id(cid))
        {
            this.course_id = cid;
        }
        this.lecturer = DEFAULT_LECTURER;
        this.max_students = DEFAULT_MAX;
        this.no_students = DEFAULT_CURRENT;

    }

    public Course(String n, String cid, String l) {
        this.course_name = n;
        if(isValidCourse_id(cid))
        {
            this.course_id = cid;
        }
        this.lecturer = l;
        this.max_students = DEFAULT_MAX;
        this.no_students = DEFAULT_CURRENT;
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        if(isValidCourse_id(cid))
        {
            this.course_id = cid;
        }
        this.lecturer = l;
        this.max_students = max;
        this.no_students = DEFAULT_CURRENT;
    }

    public String getCourse_name() {
        return this.course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;
    }

    // implement the other get and set methods here
    public String getLecturer() {

        return this.lecturer;
    }

    public void setLecturer(String lecturer) {
        if(lecturer != "")
        {
            this.lecturer = lecturer;
        }

    }

    public int getMax_students() {


        return this.max_students;
    }

    public void setMax_students(int max_students) {
        if(max_students>0 &&max_students<=60) {

            this.max_students = max_students;
        }
    }

    public int getNo_students() {

        return this.no_students;
    }

    public void setNo_students(int no_students) {
        if(no_students >0 && no_students<this.max_students)
        this.no_students= no_students;
    }

    @Override
    public String toString() {
        String status ;
        String o;
        if(this.no_students == 0)
        {
            status = "NO";
             o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has "+ status +" student, [maximum: "+this.max_students+"]" ;
        }
        else if(this.no_students == 1)
        {
            status = "NO";
            o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has "+ "ONE" +" student, [maximum: "+this.max_students+"]" ;
        }


        else {


             o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has " + this.no_students+" students, [maximum: "+this.max_students+"]" ;
        }
        // implement the rest here

        return o;
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);
        if(m.find() && id.length() == 6)
        {
            return  true;
        }

        else {
            return  false;
        }



    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "\\d{6}";

    // all private attributes

}
