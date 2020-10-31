package com.haste.Utils;

/**
 * 作者：臧立昆
 * 获取文件名后缀
 * 2020/10/10 16:31
 */

public class Name {
    public static String GetExtensionFileName(String pathfilename) {
        if (pathfilename == null || pathfilename.length() < 1) {
            System.out.println("传入的文件名可能为空或有问题");
            return null;
        } else {
            String[] split = pathfilename.split("\\.");
            if(split.length >=2 ){
                for (int i = split.length - 1; i >= 0; i--) {
                    return "." + split[i];
                }
            }else {
                System.out.println("文件虽然不为空,但是你文件名有问题");
            }

        }
        return "";
    }

    public static String UpFirstCharThenlowOtherChars(String pathfilename) {
        if (pathfilename == null || pathfilename.length() < 1) {
            System.out.println("传入的文件名可能为空或有问题");
            return null;
        } else {
            return pathfilename.substring(0, 1).toUpperCase() + pathfilename.substring(1, pathfilename.length()).toLowerCase();
        }
    }

    public static void main(String[] args) {
        //UpFirstCharThenlowOtherChars(null);
        System.out.println(GetExtensionFileName("."));
    }
}
