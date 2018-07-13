package org.jz.controller;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
public class Test {


    public static void main(String [] args){
        String tar = "\n" +
                "\t\t\t\t合资    \t\t    \t\t\t&nbsp;&nbsp;|&nbsp;&nbsp;50-150人    \t\t    \t\t    \t\t\t&nbsp;&nbsp;|&nbsp;&nbsp;通信/电信/网络设备,计算机服务(系统、数据服务、维修)    \t\t\t\t\t";
        String str1 = tar.trim().split("\\|")[0].replaceAll("&nbsp;","").trim();
        String str2 = tar.split("\\|")[1].replaceAll("&nbsp;","").trim();
        String str3 = tar.split("\\|")[2].replaceAll("&nbsp;","").trim();
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
