package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;


public class ImageUtil {
    static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);


    /**
     * 将CommonsMultipartFile转换为File类
     * @param cFile
     * @return
     * */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) throws IOException {

        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        }catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;

    }

    /**
     * 处理缩略图，并返回新生成图片的相对值路径
     * @param thumbnail
     * @param targetAddr
     * @return
     * */
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr){
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is:",relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnailInputStream).size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + "/shuiyin.jpg")),0.25f)
                    .outputQuality(0.8f).toFile(dest);
        }catch (IOException e)
        {
            logger.error(e.toString());
            e.printStackTrace();
        }

        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及的目录 /home/work/....
     **/
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        System.out.println(realFileParentPath);
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     **/
//    private static String getFileExtension(File cFile) {
//           String originalFileName = cFile.getName();
//           return originalFileName.substring(originalFileName.lastIndexOf("."));
//    }
    public static String getFileExtension(String fileName) {
       return fileName.substring(fileName.lastIndexOf("."));
    }



    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     * **/
    public static String getRandomFileName(){
        //获取随机的5位数
        int rannum = r.nextInt(89999)+10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }


    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("D:\\Image\\fenjin.jpg")).size(200,200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"\\shuiyin.jpg")),
                        0.25f).outputQuality(0.8f).toFile("D:\\Image\\xinde.jpg");
    }
}
