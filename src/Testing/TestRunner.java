package Testing;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner{
    // Run the unit tests
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(Tester.class);
		
      // Save the results
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      // Print if the tests was successful or not
      System.out.println(result.wasSuccessful());
   }
}