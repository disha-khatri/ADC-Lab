public class Student implements java.io.Serializable
{
    private int rollno;   
    private String sname, sub1, sub2, sub3;    
  
    public int getrollno() 
    { 
      return rollno; 
    } 
    public String getsname() 
    { 
      return sname; 
    } 
    public String getsub1() 
    { 
      return sub1; 
    } 
    public String getsub2() 
    { 
      return sub2; 
    } 
    public String getsub3() 
    { 
      return sub3; 
    } 
    public void setrollno(int rollno) 
    { 
      this.rollno = rollno; 
    } 
    public void setsname(String sname) 
    { 
      this.sname = sname; 
    } 
    public void setsub1(String sub1) 
    { 
      this.sub1 = sub1; 
    } 
    public void setsub2(String sub2) 
    { 
      this.sub2 = sub2; 
    } 
    public void setsub3(String sub3) 
    { 
      this.sub3 = sub3; 
    } 
}
