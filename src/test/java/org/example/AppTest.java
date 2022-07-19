package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Unit test for simple App.
 */

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 滑动窗口。找重复字符串
        List<String> out = new ArrayList<>();
        HashSet<String> set = new HashSet<String>();
        String tmp;
        if(s.length()<=10){
            // System.out.println("长度不够");
            return out;
        }
        for(int i = 0,j = 9; j < s.length(); i++,j++){
            tmp = s.substring(i,j+1);
            if(set.contains(tmp)){
                if(!out.contains(tmp)){
                    out.add(tmp);
                }
                // System.out.println("out:"+tmp);
            }else {
                set.add(tmp);
            }
            // System.out.println(tmp+"   set.size:"+set.size()+"   循环次数："+(i+1));
        }
        return out;
    }
}

public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void myTest01(){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Solution solution01 = new Solution();
        solution01.findRepeatedDnaSequences(s);
    }
}
