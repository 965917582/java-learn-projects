package com.sdt.test;

public class Test {
    public static void main(String[] args) {
        String out = StringInverseSentence("a,b,c,d", ",");
        System.out.println(out);
    }

    public static String StringInverseSentence(String in,String sep){
        //结果字符串
        String out="";
        //按sep分割，分割结果存进数组
        String[] splits = in.split(sep);
        //从第一个开始和最后一个交换，交换到一半整个句子就倒置了
        for(int i=0;i<splits.length/2;i++){
            String tmp = splits[i];
            splits[i]=splits[splits.length-i-1];
            splits[splits.length-i-1]=tmp;
        }
        //拼接成结果
        for(int i=0;i<splits.length;i++){
            out=out+splits[i];
        }
        return out;
    }
}
