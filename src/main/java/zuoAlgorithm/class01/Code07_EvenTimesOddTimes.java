package zuoAlgorithm.class01;

public class Code07_EvenTimesOddTimes {
	/*
	* 一组数组中只有一个数为奇数个，其他为偶数个，找出这个数
	* */
	public static void printOddTimesNum1(int[] arr) {
		int eor = 0;
		for (int cur : arr) {
			eor ^= cur;
		}
		System.out.println(eor);
	}
	
	
	
	/*
	* 一组数组中存在两个不同的数为奇数个，其他都是偶数个
	* 	两不同的数据异或结果位中必存在至少一个1，将该位为1和为0的分为两组即可看做两组中只有一个数存在奇数个
	* 	结合异或的性质将算法进行简化
	* */
	public static void printOddTimesNum2(int[] arr) {
		int eor = 0;
		for (int i = 0 ; i < arr.length;i++) {
			eor ^= arr[i];
		}
		// eor = a ^ b
		// eor != 0
		// eor必然有一个位置上是1
		int rightOne = eor & (~eor + 1); // 提取出最右的1
		int onlyOne = 0; // eor'
		for (int cur : arr) {
			if ((cur & rightOne) == 1) {
				onlyOne ^= cur;
			}
		}
		System.out.println(onlyOne + " " + (eor ^ onlyOne));
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 7;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println(a);
		System.out.println(b);

		int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
		printOddTimesNum1(arr1);

		int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
		printOddTimesNum2(arr2);

	}

}
