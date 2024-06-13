//package org.pixels.goodjob;
//
//import org.opencv.core.*;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.objdetect.CascadeClassifier;
//
///**
// * @author ：ShangzheChe
// * @date ：Created in 2024/6/13 17:34
// * @description：
// */
//public class FirstOpenCV {
//    public static void detectFace(String imagePath, String outFile) throws Exception
//    {
//        System.out.println("开始人脸检测...");
//
//        // 加载人脸分类器
//        String xmlFile = "D://haarcascade_frontalface_alt.xml";
//        CascadeClassifier faceDetector = new CascadeClassifier(xmlFile);
//
//        Mat image = Imgcodecs.imread(imagePath);
//        // 在图片中检测人脸
//        MatOfRect faceDetections = new MatOfRect();
//        faceDetector.detectMultiScale(image, faceDetections);
//        System.out.println(String.format("检测到 %s个人脸", faceDetections.toArray().length));
//
//        // 绘制人脸框
//        Rect[] rects = faceDetections.toArray();
//        if (rects != null && rects.length > 1)
//        {
//            for (Rect rect : rects)
//            {
//                // 在每一个识别出来的人脸周围画出一个方框
//                Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0), 3);
//            }
//        }
//
//        // 存储
//        Imgcodecs.imwrite(outFile, image);
//        System.out.println(String.format("人脸检测结果，人脸检测图片文件为：%s", outFile));
//    }
//
//    public static void main(String[] args) throws Exception
//    {
//        try
//        {
////            String openCVDllName = "D:\\Java\\opencv\\build\\java\\x64\\opencv_java452.dll";
////            // 本文使用 openCV4.5.2
////            System.load(openCVDllName);
//            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        }
//        catch (SecurityException e)
//        {
//            System.out.println(e.toString());
//            System.exit(-1);
//        }
//        catch (UnsatisfiedLinkError e)
//        {
//            System.out.println(e.toString());
//            System.exit(-1);
//        }
//        // 人脸测试
//        String imagePath = "D:\\Test\\1553247564696949.jpg";
//        detectFace(imagePath, "D:\\face2.png");
//    }
//
//}
