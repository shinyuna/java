package main;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		int arr[] = new int[3];
		Random rn = new Random();

		arr[0] = rn.nextInt(10);

		do {
			arr[1] = rn.nextInt(10);
		} while (arr[0] == arr[1]);
		do {
			arr[2] = rn.nextInt(10);
		} while (arr[0] == arr[2] || arr[1] == arr[2]);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("야구 게임 시작 ");
		int user[] = new int[3];
		Scanner sc = new Scanner(System.in);
		int s, b, cnt = 0;

		do{
			s=b=0;
			cnt++;
		System.out.println("사용자는 3개의 숫자를 입력하세요 (띄어쓰기)");
		for (int i = 0; i < user.length; i++) {
			user[i] = sc.nextInt();
		}
		if(arr[0] == user[0])
			s++;
		else if(arr[0] == user[1] || arr[0] == user[2])
			b++;
		if(arr[1] == user[1])
			s++;
		else if(arr[1] == user[2] || arr[1] == user[0])
			b++;
		if(arr[2]==user[2])
			s++;
		else if(arr[2]==user[1]||arr[2]==user[0])
			b++;
		System.out.println("["+s+"S"+b+"B]");
		}while (s != 3);
		System.out.println("축하"+cnt+"만에 맞춤");
	}

}