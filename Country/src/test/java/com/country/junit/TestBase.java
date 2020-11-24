package com.country.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.thucydides.core.annotations.Step;

public class TestBase {
	@Step("#Verify value {1} is present in {0}")
	public void DataIsPresent(ArrayList<String> data,String value)
	{
		boolean flag=false;
		for(int i=0;i<data.size();i++)
		{
			if(data.get(i).equals(value))
			{
				flag=true;
				break;
			}
			
		}
		assertTrue(flag);
	}
	@Step("#Verify value {0} is present")
	public void DataIsPresent(List<String> data,String value)
	{
		boolean flag=false;
		for(int i=0;i<data.size();i++)
		{
			if(data.get(i).equals(value))
			{
				flag=true;
				break;
			}
			
		}
		assertTrue(flag);
	}

}
