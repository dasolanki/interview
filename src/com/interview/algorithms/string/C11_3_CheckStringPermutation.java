package com.interview.algorithms.string;

import com.interview.java.basics.sort.QuickSorter;
import com.interview.utils.ArrayUtil;

/**
 * Problem:
 * 	Write a method to decide if two strings are anagrams or not.
 * 
 * Solution:
 * 	1. sort the two strings, and check if equal
 * 		time: O(NlogN), space: O(1)
 *  2. check contained character is same or not
 *  	time: O(N^2), space: O(1)
 * @author stefanie
 *
 */
public class C11_3_CheckStringPermutation {

	public boolean checkBySort(String str1, String str2){
        QuickSorter<Character> sorter = new QuickSorter<Character>();
        str1 = ArrayUtil.getString(sorter.sort(ArrayUtil.getCharArray(str1)));
        str2 = ArrayUtil.getString(sorter.sort(ArrayUtil.getCharArray(str2)));

		return str1.equals(str2);
	}
	
	public boolean checkByScan(String str1, String str2){
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		for(char ch : arr1){
			int num1 = 0;
			for(char ch1 : arr1){
				if(ch1 == ch) num1++;
			}
			int num2 = 0;
			for(char ch2 : arr2){
				if(ch2 == ch) num2++;
			}
			if(num1 != num2) return false;
		}
		return true;
	}
	
	public boolean checkByScanByIndex(String str1, String str2){
        int[] char_set = new int[256];
        for(char ch: str1.toCharArray()) char_set[ch]++;
        for(char ch: str2.toCharArray()) char_set[ch]--;
        for(int i = 0; i < 256; i++){
            if(char_set[i] != 0) return false;
        }
        return true;
    }
}
