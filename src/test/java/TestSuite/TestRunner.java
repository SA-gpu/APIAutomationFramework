package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import APITest.Post;

 
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
        Post.class,
})

public class TestRunner {

}
