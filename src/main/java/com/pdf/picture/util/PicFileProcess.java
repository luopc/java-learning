package com.pdf.picture.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PicFileProcess {

    public static boolean mergeImage(String storePath, String imageName, List<BufferedImage> imgList) {
        int len = imgList.size();
        if (len < 1) {
            System.out.println("pics len < 1");
            return false;
        }
        int[][] ImageArrays = new int[len][];
        int dst_height = 0;
        int dst_width = 0;
        for (int i = 0; i < len; i++) {
            BufferedImage image = imgList.get(i);

            int width = image.getWidth();
            int height = image.getHeight();

            dst_width = dst_width > width ? dst_width : width;
            dst_height += height;

            ImageArrays[i] = new int[width * height];
            ImageArrays[i] = image.getRGB(0, 0, width, height,ImageArrays[i], 0, width);
        }

        System.out.println(dst_width);
        System.out.println(dst_height);

        try {
            BufferedImage ImageNew = new BufferedImage(dst_width, dst_height, BufferedImage.TYPE_USHORT_555_RGB);
            int height_i = 0;
            for (int i = 0; i < imgList.size(); i++) {
                BufferedImage image = imgList.get(i);
                ImageNew.setRGB(0, height_i, dst_width, image.getHeight(), ImageArrays[i], 0, dst_width);
                height_i += image.getHeight();
                image.flush();
            }
            File outFile = new File(storePath + File.separator + imageName);
            ImageIO.write(ImageNew, "png", outFile);
            ImageNew.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static void pdf2Pic(String pdfPath, String storePath) throws Exception {
        File file_dir = new File(pdfPath);
        File[] fileList = file_dir.listFiles();
        PDDocument doc = null;
        PDFRenderer renderer = null;
        if(fileList != null && fileList.length > 0){
            for (File inFile : fileList) {
                String fileName = inFile.getName();
                if(fileName.substring(fileName.lastIndexOf(".") +1) .equalsIgnoreCase("pdf")) {
                    doc = PDDocument.load(inFile);
                    renderer = new PDFRenderer(doc);
                    List<BufferedImage> imageList = new ArrayList<>();
                    int pageCount = doc.getNumberOfPages();
                    //String imgName = fileName.substring(0, fileName.lastIndexOf(".")) + ".png";
                    for (int i = 0; i < pageCount; i++) {
                        BufferedImage rendImage = renderer.renderImageWithDPI(i, 296);
                        imageList.add(rendImage);
                    }
                    mergeImage(storePath, fileName.substring(0, fileName.lastIndexOf(".")) + ".png", imageList);
                    doc.close();
                }
            }
            if(doc != null) doc.close();
        }
    }

    public static void subImage(String inPath, String storePath) throws IOException {
        //BufferedImage getSubImage (int x, int y, int w, int h);
        File file_dir = new File(inPath);
        File[] fileList = file_dir.listFiles();
        if(fileList != null && fileList.length > 0) {
            for (File inFile : fileList) {
                String fileName = inFile.getName();
                if (fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("png")) {
                    BufferedImage bufImage = ImageIO.read(inFile);
                    int width = bufImage.getWidth();
                    int height = bufImage.getHeight();
                    System.out.println("width: " + width + "; height: " + height);
                    bufImage = bufImage.getSubimage(0, 0, width, height > 19560 ? 19590 : height);
                    File outFile = new File(storePath + File.separator + fileName);
                    if(!outFile.exists()) outFile.mkdirs();
                    ImageIO.write(bufImage, "png", outFile);
                }
            }
        }

    }


    public static void main(String[] args) throws Exception {


        String filePath = "E:\\零基础学英语\\不一样的新概念\\不一样的新概念英语【第2辑】\\不一样的新概念（2）-讲义图片";
        String outPath = "E:\\零基础学英语\\不一样的新概念\\不一样的新概念英语【第2辑】\\second\\";
        //pdf2Pic(filePath, outPath);
        subImage(filePath, outPath);
    }
}
