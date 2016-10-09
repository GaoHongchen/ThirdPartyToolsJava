package ghc.files;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOpt {

	public FileOpt() {
		// TODO Auto-generated constructor stub
	}
	
	 /**
     * ׷�ӷ�ʽд�ļ���ʹ��FileWriter
     */
    public static void writeAppend(String fileName, String content) {
        try {
            //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	public static void downloadFile(String urlIn,String fileNameOut){
		try{            
            URL url = new URL(urlIn);
            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream(fileNameOut);
            byte[] buffer = new byte[2048];
            
            int length = 0;
            
            while ((length = inputStream.read(buffer)) != -1) {
               //System.out.println("Buffer Read of length: " + length);
               outputStream.write(buffer, 0, length);
            }
            
            inputStream.close();
            outputStream.close();
            
         }catch(Exception e){
            System.out.println("FileDownloadException: " + e.getMessage());
         }
	}
	
	/**
	 * ����ļ��в����� �������ļ��� 
	 * @param strDir
	 */
	public static void directoryCheckAndMake(String strDir){		
		File dir = new File(strDir);
		if (!dir.exists() && !dir.isDirectory()) {
			dir.mkdir();
		}
	}
	
	/**
	 * �ļ�ѡ��Ի���
	 * @param parent
	 * @return
	 */
	public static String chooseFile(Component parent){
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = 
				new FileNameExtensionFilter("ͼ���ļ�(JPG/PNG/BMP)", "jpg","png","bmp");
		fileChooser.setFileFilter(filter);
		int ret = fileChooser.showOpenDialog(parent);
		String filepath = "";
		if (ret == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			filepath = selectedFile.getPath();
		}
		return filepath;
	}
	
	/** 
     * ���Ƶ����ļ� 
     * @param oldPath String ԭ�ļ�·�� �磺c:/fqf.txt 
     * @param newPath String ���ƺ�·�� �磺f:/fqf.txt 
     * @return boolean 
     */ 
   public static void copyFile(String oldPath, String newPath) { 
       try { 
           int bytesum = 0; 
           int byteread = 0; 
           File oldfile = new File(oldPath); 
           if (oldfile.exists()) { //�ļ�����ʱ 
               InputStream inStream = new FileInputStream(oldPath); //����ԭ�ļ� 
               FileOutputStream fs = new FileOutputStream(newPath); 
               byte[] buffer = new byte[1444]; 
               while ( (byteread = inStream.read(buffer)) != -1) { 
                   bytesum += byteread; //�ֽ��� �ļ���С 
                   System.out.println(bytesum); 
                   fs.write(buffer, 0, byteread); 
               } 
               inStream.close(); 
           } 
       } 
       catch (Exception e) { 
           System.out.println("���Ƶ����ļ���������"); 
           e.printStackTrace(); 
       }
   }

}
