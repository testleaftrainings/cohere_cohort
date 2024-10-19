package sdet_FirstClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class subseq {
	@Test
	public void method1()
	{
	
	int[] in = {9,8,7,4,3,2};
	List<Integer> li = new ArrayList<Integer>();
	for(int i=0;i<in.length;i++)
	{
		li.add(in[i]);
		Collections.sort(li);
	}
	for(int m=0;m<li.size();m--)
	{
		
	}
	System.out.println(li);
	}
	

}
