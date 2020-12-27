package com.pdf.picture.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ReNameFile {

    public static Map<String, String>  getFileNameList(String inFilePath) {
        File inFile = new File(inFilePath);
        Map<String, String> nameMap = new HashMap<>();
        File[] files = inFile.listFiles();
        if (files != null && files.length > 0){
            for (File file : files) {
                String fileName = file.getName();
                String key = getFileNameKey_01(fileName);
                if (key != null) nameMap.put(key, fileName);
            }
        }
        return nameMap;
    }


    private static String getFileNameKey_01(String fileName) {
        if (fileName.indexOf("正课 ") > -1 && fileName.indexOf("_") > -1){
            String key = fileName.substring(fileName.indexOf("正课 ") + "正课 ".length(), fileName.indexOf("_"));
            return key.trim().substring(0,3);
        }
       return  null;
    }

    private static String getFileNameKey_02(String fileName){
        if (fileName.indexOf("正课 ") > -1 && fileName.indexOf("【") > -1) {
            String key = fileName.substring(fileName.indexOf("正课") + "正课 ".length(), fileName.indexOf("【"));
            return key.substring(0, 3);
        }
        return null;
    }


    public static void reName_01(String inputPath, String outputPath) {
//        String fileName_1 = "025.正课 005 _ 【词汇专题】常见国家及称谓.mp3";
//        String fileName_2 = "正课 001  【场景演练】表达感谢及询问.mp3";
//
//        System.out.println(getFileNameKey_01(fileName_1));
//        System.out.println(getFileNameKey_02(fileName_2));
        Map<String, String> nameMap = getFileNameList(inputPath);
        System.out.println(nameMap);
        File inFile = new File(outputPath);
        File[] files = inFile.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                String fileName = file.getName();
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                String key = getFileNameKey_02(fileName);
                String newName = fileName;
                if (key != null) {
                    System.out.println(key);
                    newName = nameMap.get(key) != null ? nameMap.get(key) : fileName;
                    System.out.println(newName);
                }
                String newFilePath = outputPath + File.separator + newName.substring(0, newName.lastIndexOf(".")) + suffix;
                System.out.println(newFilePath);
                File newFile = new File(newFilePath);
                file.renameTo(newFile);
            }
        }
    }

    public static void reName_02(String inputPath, String outputPath) {
        File inFile = new File(inputPath);
        File[] files = inFile.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                String fileName = file.getName();
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                String newName = fileName.substring(0, fileName.indexOf("_20"));

                String newFilePath = outputPath + File.separator + newName + suffix;
                System.out.println(newFilePath);
                File newFile = new File(newFilePath);
                file.renameTo(newFile);
            }
        }

    }

    public static void main(String[] args) {
            String inputPath = "E:\\迅雷下载\\restore_4";
            String outPutPath = "E:\\零基础学英语\\不一样的新概念\\不一样的新概念英语【第4辑】\\不一样的新概念（4）-音频";
            reName_02(inputPath, outPutPath);

    }

}
