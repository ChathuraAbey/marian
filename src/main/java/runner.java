import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testsuite001.test;
import testsuite002.pet;

@RunWith(Suite.class)
@Suite.SuiteClasses({test.class, pet.class})
public class runner {

}
