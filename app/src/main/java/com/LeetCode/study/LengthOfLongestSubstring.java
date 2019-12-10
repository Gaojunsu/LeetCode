package com.LeetCode.study;

import android.util.Log;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring implements ResultInterface<Integer>{

    private String s;


    public LengthOfLongestSubstring() {
    }

    public LengthOfLongestSubstring(String s) {

        this.s=s;

    }

    @Override
    public Integer result() {

        int n=s.length();
        Set<Character> characters = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(i<n && j<n){
            if (!characters.contains(s.charAt(j))){
                characters.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else{
                characters.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    @Override
    public void test() {

        s="abcabcabcabcdf";
        int result = result();
        Log.w("LeetCode",result+"");


    }
}
