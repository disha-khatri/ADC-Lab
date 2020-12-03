public class Book implements java.io.Serializable
{
private int Bookid, BookPrice;
private String BookName, BookAuthor, BookStatus;

public int getBookid()
{
return Bookid;
}
public String getBookName()
{
return BookName;

}
public String getBookAuthor()
{
return BookAuthor;
}
public int getBookPrice()
{
return BookPrice;
}
public String getBookStatus()
{
return BookStatus;
}
public void setBookid(int Bookid)
{
this.Bookid = Bookid;
}
public void setBookName(String BookName)
{
this.BookName = BookName;
}
public void setBookAuthor(String BookAuthor)
{
this.BookAuthor = BookAuthor;
}

public void setBookPrice(int BookPrice)
{
this.BookPrice = BookPrice;
}
public void setBookStatus(String BookStatus)
{
this.BookStatus = BookStatus;
}
}