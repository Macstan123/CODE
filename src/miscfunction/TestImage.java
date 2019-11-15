package miscfunction;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
 
public class TestImage {
	public TestImage() {}	 
	public static void buff2Image(byte[] b,String tagSrc) throws Exception
	    {
	        FileOutputStream fout = new FileOutputStream(tagSrc);
	        //���ֽ�д���ļ�
	        fout.write(b);
	        fout.close();
	    }

	public static byte[] image2Bytes(String imgSrc) throws Exception
	    {
	        FileInputStream fin = new FileInputStream(new File(imgSrc));
	        //�������,������Ͳ�����̫��,���̫���Ҫ������취������һ�δ���̶�����byte[]
	        byte[] bytes  = new byte[fin.available()];
	        //���ļ�����д���ֽ����飬�ṩ���Ե�case
	        fin.read(bytes);
	        
	        fin.close();
	        return bytes;
	    }	 
}

