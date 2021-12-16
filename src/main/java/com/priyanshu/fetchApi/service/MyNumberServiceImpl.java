package com.priyanshu.fetchApi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanshu.fetchApi.dao.MyNumberDAO;
import com.priyanshu.fetchApi.entity.MyNumber;

@Service
public class MyNumberServiceImpl implements MyNumberService {
	
	@Autowired
	private MyNumberDAO myNumberDAO;
	
	public MyNumberServiceImpl() {
	}

	public int digitSum(int n) {
		int sum = 0;
		while(n!=0) {
			sum += n % 10;
			n /= 10;
		}
		
		return sum;
	}
	
	public int findNextNumber(int n) {
		int ans = 0;
		for(int i=n+1;i<=Integer.MAX_VALUE;i++) {
			if(digitSum(i)==n) {
				ans = i;
				break;
			}
		}
		
		//Introducing a delay of 5 seconds overall to the minimum.
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ans;
	}
	
	@Override
	public Map<String,Integer> updateMyNumber(String categoryCode) {
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		MyNumber myNumber = myNumberDAO.getById(categoryCode);
		int oldValue = myNumber.getValue();
		result.put("Old value",Integer.valueOf(oldValue));		
		int newValue = findNextNumber(oldValue);
		myNumber.setValue(newValue);
		result.put("New value", Integer.valueOf(newValue));
		return result;
	}

	
//	public void main(String[] args) {
//		
//		System.out.println(new MyNumberServiceImpl().digitSum(10));
//		System.out.println(findNextNumber(20));
//	}

}
