package ghc.data;

import java.text.DecimalFormat;

public class TypeConvert {

	/**
	 * floatתString��������λС��
	 * @param number
	 * @return
	 */
	public static String FloatToString(float number){
		//���췽�����ַ���ʽ�������С������2λ,����0����.
		DecimalFormat decimalFormat=new DecimalFormat(".00");
		return decimalFormat.format(number);
	}
}
