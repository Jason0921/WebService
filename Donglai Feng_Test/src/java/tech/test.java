/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author lenovo
 */
public class test {
   /* public static void main(String[] args) {
		
		String input1 = stringClean("yyzzza");
		int result = maxBlock("abbCCCddBBBxx");
		String input2 = reorderBlock("bbAAccAadF");
		System.out.println(input1);
		System.out.println(result);
		System.out.println(input2);

	}*/
	//Q1
	public String stringClean(String input) {
		if(input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0;
		int fast = 0;
		while(fast < array.length) {
			if(array[slow] != array[fast]) {
				slow++;
				array[slow] = array[fast];
			}else {
				fast++;
			}
			
		}
		return new String(Arrays.copyOf(array, slow+1));
	}
	
	//Q2
	public  int maxBlock(String input) {
		if(input == null || input.length() == 0) {
			return 0;
			
		}
		char[] array = input.toCharArray();
		Map<Character, Integer> hm = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			if(! hm.containsKey(array[i])) {
				hm.put(array[i], 1);
			}else {
				hm.put(array[i], hm.get(array[i])+1);
			}
			
		}
		int global_max = Integer.MIN_VALUE;
		for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
			if(entry.getValue() > global_max) {
				global_max = entry.getValue();
				
			}
		}
		return global_max;
	}
	
	//Q3
	public  String reorderBlock(String input) {
		if(input == null || input.length() == 0) {
			return input;
			
		}
		char[] array = input.toCharArray();
		mergeSort(array , 0, array.length-1);
		return new String(array);
	}
	private  void mergeSort(char[] array, int left, int right) {
		int mid = left +(right - left)/2;
		if(left < right) {
			mergeSort(array,left,mid);
			mergeSort(array,mid+1,right);
			merge(array,left,mid, right);
		}
	}
	private  void merge(char[] array, int left, int mid, int right) {
		char[] result = new char[right - left + 1];
		int first = left;
		int firstEnd = mid;
		int second = mid +1;
		int secondEnd = right;
		int start = 0;
		while(first <= firstEnd && second <= secondEnd) {
			char c1 = array[first];
			char c2 = array[second];
			if(c1 >= 'A' && c1 <= 'Z') {
				c1 = (char)((int)c1+32);
			}
			if(c2 >= 'A' && c2 <= 'Z') {
				c2 = (char)((int)c2+32);
			}
			if(c1 <= c2) {
				result[start] = array[first];
				start++;
				first++;
			}else {
				result[start] = array[second];
				start++;
				second++;
			}
		}
		while(first<=firstEnd) {
			result[start]  =array[first];
			start++;
			first++;
		}
		while(second <= secondEnd) {
			result[start] = array[second];
			start++;
			second++;
		}
		for(int i = 0; i<result.length; i++) {
			array[left] = result[i];
			left++;
		}
	}
}
