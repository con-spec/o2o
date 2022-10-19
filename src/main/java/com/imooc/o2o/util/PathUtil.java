package com.imooc.o2o.util;

public class PathUtil {
    private static String seperator = "/";
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/Image";
        }else {
            basePath = "/home/zxw/img";
        }

        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/images/item/shop/" + shopId + "/";
        System.out.println(imagePath);;
        return imagePath.replace("/",seperator);
    }
}
