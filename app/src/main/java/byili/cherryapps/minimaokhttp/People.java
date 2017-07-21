package byili.cherryapps.minimaokhttp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by anelelizabethcervantes on 7/21/17.
 */

public class People implements Parcelable{

    private String name;
    private int age;
    private double grade;


    protected  People(Parcel in) {
        this.name   = in.readString();
        this.age    =  in.readInt();
        this.grade  = in.readDouble();
    }

    public static final Parcelable.Creator<People> CREATOR = new Parcelable.Creator<People>() {

        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    public People(String name, int age, double grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeDouble(this.grade);
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
