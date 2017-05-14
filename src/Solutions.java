import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		//Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

		Scanner sc = new Scanner(System.in);



		int T;
		int test_case;

		T = sc.nextInt();
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.

			int n = sc.nextInt();
			int s = sc.nextInt();

			int[] arr = new int[n+1];
			Arrays.fill(arr,0);
			int sum=0;
			int min = 100000;


			for( int i=1;i<=n;i++){
				arr[i] = sc.nextInt();
			}


			Queue<Integer> integers = new LinkedList<>();
			int cnt = 0;

			for(int i=1;i<=n;){

				while( i <= n && sum < s){
					sum+=arr[i];
					integers.add(arr[i]);
					i++;
					cnt++;
				}

				if( min > cnt ) {
					min = cnt;
				}

				while( sum >= s){
					if(min > integers.size())
						min = integers.size();
					if(integers.isEmpty() == false){
						sum = sum - integers.poll();
					}
				}
				cnt = integers.size();
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("#testcase" + test_case);
			if(cnt == n )
				System.out.println(0);
			else
				System.out.println(min);

		}
	}
}