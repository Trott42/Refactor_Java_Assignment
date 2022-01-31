 package refactoringDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TESTreadInput {
  int testDay = 1;
  int testMonth = 2;
  int testYear = 2000;
  
  @Test
  
  public void testReadInputYear() {

    Date date = new Date(testDay, testMonth, testYear);
    Assert.assertTrue(date.getYear() == testYear);
    
  }
  
  @Test
 
  public void testReadInputMonth() {
    Date date = new Date(testDay, testMonth, testYear);
    Assert.assertTrue(date.getMonth() == testMonth);
    
  }

  
  @Test

  public void testReadInputDay() {

    Date date = new Date(testDay, testMonth, testYear);
    Assert.assertTrue(date.getDay() == testDay);
    
  
	}

}
