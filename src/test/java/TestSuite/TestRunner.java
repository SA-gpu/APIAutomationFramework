package TestSuite;

import APITest.Testcase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        Testcase.class,
})

public class TestRunner {

}
