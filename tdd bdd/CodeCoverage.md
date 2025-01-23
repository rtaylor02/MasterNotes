# Code Coverage
Using IntelliJ, you can tell code coverage by running unit tests with coverage. Result will be annotated with gutter colouring green (covered), amber (partially covered), red (uncovered).

When you have a branch, it can be quite confusing to decipher and figure out what flow that you have not covered.

In this simple example, I have 3 boolean values that control the flow: 
```
public class Simple {
    public void simple(boolean bool1, boolean bool2, boolean bool3) {
        if (bool1 && bool2 && bool3) {
            System.out.println("both are true");
        }
    }
}
```

To analyse all possible scenarios/flows, ***start from all true condition***. This will have coverage of 50% (see below). 
```
public class SimpleTest extends TestCase {
    private Simple simple = new Simple();

    @Test
    public void testSimple() {
        simple.simple(true, true, true);
    }
}
```
Result:
![image](https://github.com/user-attachments/assets/37213323-58c4-43b9-ab22-bd9d9571ecde)  
With coverage: ![50percent_coverage](https://github.com/user-attachments/assets/ceb74f1c-7df5-47d7-9382-5d4676c000fc)  

Then, starting from most left condition (bool1), fulfil the missing `false` condition:
```
public class SimpleTest extends TestCase {
    private Simple simple = new Simple();

    @Test
    public void testSimple() {
        simple.simple(true, true, true);
    }

    @Test
    public void testSimple2() {
        simple.simple(false, true, true);
    }
}
```
Result:
![image](https://github.com/user-attachments/assets/d9827a10-a220-44d4-8ccd-9dd3c5039aa2)  
Resulting coverage: ![66percent_coverage](https://github.com/user-attachments/assets/5b31130d-d8e5-4802-a5e3-83041f633451)  

Continue with the next right:
```
public class SimpleTest extends TestCase {
    private Simple simple = new Simple();

    @Test
    public void testSimple() {
        simple.simple(true, true, true);
    }

    @Test
    public void testSimple2() {
        simple.simple(false, true, true);
    }

    @Test
    public void testSimple3() {
        simple.simple(true, false, true);
    }
}
```
Result:
![image](https://github.com/user-attachments/assets/b54c8ba5-b9d4-4783-96af-1986f115e8a1)    
Resulting coverage: ![83_percent_coverage](https://github.com/user-attachments/assets/a01ce95b-a9e6-4cb2-8e03-e1da1cdf3989)

Continue with the next one, the last boolean value:
```
public class SimpleTest extends TestCase {
    private Simple simple = new Simple();

    @Test
    public void testSimple() {
        simple.simple(true, true, true);
    }

    @Test
    public void testSimple2() {
        simple.simple(false, true, true);
    }

    @Test
    public void testSimple3() {
        simple.simple(true, false, true);
    }

    @Test
    public void testSimple4() {
        simple.simple(true, true, false);

    }
}
```
Result:
![image](https://github.com/user-attachments/assets/5657b5de-3a66-494b-a9dd-19a9f02298da)  
Resulting coverage: ![100percent_coverage](https://github.com/user-attachments/assets/2f619715-16f2-4b8a-af6f-78eb7b256a95)
