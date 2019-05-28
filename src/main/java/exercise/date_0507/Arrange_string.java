package exercise.date_0507;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Arrange_string {
    public static void main(String[] args) {
        char[]chars = {'1','2','3','4'};
        perm(chars,0,3);
    }

    // 输入一个字符串打印改字符串中所有字符的排列
    public static void perm(char[] chars,int start,int end){
        if(start==end){//当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            for(int i=0;i<=end;i++){
                System.out.print(chars[i]);
            }
            System.out.println();
        }
        else{//多个字母全排列
            for(int i=start;i<=end;i++){
                char temp=chars[start];//交换数组第一个元素与后续的元素
                chars[start]=chars[i];
                chars[i]=temp;

                perm(chars,start+1,end);//后续元素递归全排列

                temp=chars[start];//将交换后的数组还原
                chars[start]=chars[i];
                chars[i]=temp;
            }
        }
    }
}
