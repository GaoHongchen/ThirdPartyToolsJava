package ghc.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽ��һ��ʮ�ֹ��϶���ǿ����ı������ߣ������������ֶλ������ַ�����У�飬
 * ������һ�ηǳ���̵ı��ʽ��䣬���ܹ�����ʵ��һ���ǳ����ӵ�ҵ���߼���
 * @author Gordon
 *
 */
public class RegExp {

	//���� 13��15��18��ͷ���ֻ���������ʽ
	private static final String patternPhoneNum = 
			"^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
	
	//���֤���������У�飬15 �� 18λ
	@SuppressWarnings("unused")
	private static final String patternIDNum15 = 
			"^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
	private static final String patternIDNum18 = 
			"^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
	
	//���У�飬��ȷ��2λС��
	private static final String patternMoney = "^[0-9]+(.[0-9]{2})?$";
	
	//��yyyy-mm-dd�� ��ʽ������У�飬�ѿ���ƽ����
	private static final String patternDate = 
			"^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
	
	//�ַ�������������
	private static final String patternChinese = "^[\\u4e00-\\u9fa5]{0,}$";
	
	//�����֡�26��Ӣ����ĸ���»�����ɵ��ַ���
	private static final String patternAlphaNumericUnderline = "^\\w+$";
	
	//�����ǿ�ȱ����ǰ�����Сд��ĸ�����ֵ���ϣ�����ʹ�������ַ���������8-10֮��
	private static final String patternPasswordStrength = 
			"^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$";
	
	//E-mail��ַ�Ϲ��Ե����������
	private static final String patternEMailAddr = 
			"[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
	
	//IP4 �� IP6 �������
	private static final String patternIPv4 = 
			"\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
	@SuppressWarnings("unused")
	private static final String patternIPv6 =
			"(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))";
	
	//��֤�ļ�·������չ��
	private static final String patternFilePath = 
			"^([a-zA-Z]\\:|\\\\)\\\\([^\\\\]+\\\\)*[^\\/:*?\"<>|]+\\.(pdf)$";
	
	//URL����
	private static final String patternURL = "(f|ht){1}(tp|tps):\\/\\/([\\w-]+\\.)+[\\w-]+(\\/[\\w- ./?%&=]*)?";
	
	//Color Hex Codes
	private static final String patternColorHexCodes = "\\#([a-fA-F]|[0-9]){3,6}";
	
	/**
	 * У���ֻ���
	 * @param phoneNum
	 * @return
	 */
	public static boolean verifyPhoneNumber(String numPhone) {
		Pattern pattern = Pattern.compile(patternPhoneNum,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(numPhone);		
		return matcher.matches();
	}
	
	/**
	 * У�����֤����
	 * @param numID
	 * @return
	 */
	public static boolean verifyIdentityCardNumber(String numID) {		
		return verify(patternIDNum18,numID);
	}
	
	/**
	 * У����
	 * @param money
	 * @return
	 */
	public static boolean verifyMoney(String money){
		return verify(patternMoney,money);
	}
	
	/**
	 * У������
	 * @param date
	 * @return
	 */
	public static boolean verifyDate(String date){
		return verify(patternDate,date);
	}
	
	/**
	 * У������
	 * @param chinese
	 * @return
	 */
	public static boolean verifyChinese(String chinese){
		return verify(patternChinese,chinese);
	}
	
	/**
	 * У���������֡�26��Ӣ����ĸ���»�����ɵ��ַ���
	 * @param alphanumericunderline
	 * @return
	 */
	public static boolean verifyAlphaNumericUnderline(String alphanumericunderline){		
		return verify(patternAlphaNumericUnderline,alphanumericunderline);
	}
	
	/**
	 * У������ǿ��
	 * @param password
	 * @return
	 */
	public static boolean verifyPasswordStrength(String password){		
		return verify(patternPasswordStrength,password);
	}
	
	/**
	 * У��E-Mail ��ַ
	 * @param addrEMail
	 * @return
	 */
	public static boolean verifyEMailAddress(String addrEMail){		
		return verify(patternEMailAddr,addrEMail);
	}
	
	/**
	 * У��IP��ַ
	 * @param ip
	 * @return
	 */
	public static boolean verifyIP(String ip){		
		return verify(patternIPv4,ip);
	}
	
	/**
	 * �ļ�·������չ��У��
	 * @param filepath
	 * @return
	 */
	public static boolean verifyFilePath(String filepath){
		return verify(patternFilePath,filepath);
	}
	
	/**
	 * ��ȡURL����
	 * @param strText
	 * @return
	 */
	public static String extractURL(String strText){
		return extract(patternURL,strText);
	}
	
	/**
	 * ��ȡ��ҳ�е���ɫ����
	 * @param strText
	 * @return
	 */
	public static String extractColorHexCodes(String strText){
		return extract(patternColorHexCodes,strText);
	}
	
	/**
	 * 
	 * @param strPattern
	 * @param strInput
	 * @return
	 */
	private static boolean verify(String strPattern,String strInput){
		Pattern pattern = Pattern.compile(strPattern);
		Matcher matcher = pattern.matcher(strInput);		
		return matcher.matches();
	}
	
	/**
	 * 
	 * @param strPattern
	 * @param strInput
	 * @return
	 */
	private static String extract(String strPattern,String strInput){
		Pattern pattern = Pattern.compile(strPattern);
		Matcher matcher = pattern.matcher(strInput);	
		if (matcher.find()) {
			return matcher.group(0);
		}else {
			return null;
		}
	}
}
