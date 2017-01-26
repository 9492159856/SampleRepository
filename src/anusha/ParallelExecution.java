package anusha;

import org.testng.annotations.Test;

public class ParallelExecution {
@Test
public void test1()
{
//Printing id of the thread on using which test	method got executed
	System.out.printf("Test1 with Thread id:-",Thread.currentThread().getId());
}
@Test()
public void test2()
{
	//Printing id of the thread on using which test	method got executed
		System.out.printf("Test2 with Thread id:-",Thread.currentThread().getId());
}
}