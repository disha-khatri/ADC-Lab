public class Billing implements java.io.Serializable
{
    private int InvoiceId, CustId, Amount;   
    private String CustName;
    private String InvoiceDate;
  
    public int getInvoiceId() 
    { 
      return InvoiceId; 
    } 
    public int getCustId() 
    { 
      return CustId; 
    } 
     public String getCustName() 
    { 
      return CustName; 
    }
    public String getInvoiceDate() 
    { 
      return InvoiceDate; 
    } 
    public int getAmount() 
    { 
      return Amount; 
    } 
    public void setInvoiceId(int InvoiceId) 
    { 
      this.InvoiceId = InvoiceId; 
    } 
    public void setCustId(int CustId) 
    { 
      this.CustId = CustId; 
    } 
     public void setCustName(String CustName) 
    { 
      this.CustName = CustName; 
    } 
    public void setInvoiceDate(String InvoiceDate) 
    { 
      this.InvoiceDate = InvoiceDate; 
    } 
    public void setAmount(int Amount) 
    { 
      this.Amount = Amount; 
    } 
}
