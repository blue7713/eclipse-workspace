package exercise8;

import java.io.*;
import java.util.Scanner;

public class Exercise8_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileInputStream srcStream = null;
		FileInputStream destStream = null;
		
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		
		System.out.print("첫번째 파일 이름을 입력하세요>> ");
		String src = scanner.nextLine();
		
		System.out.print("두번째 파일 이름을 입력하세요>> ");
		String dest = scanner.nextLine();
		
		System.out.println(src + "와" + dest + "를 비교합니다.");
		try {
			srcStream = new FileInputStream(src);
			destStream = new FileInputStream(dest);
			if(compareFile(srcStream, destStream)) {
				System.out.println("파일이 같습니다.");
			}
			else {
				System.out.println("파일이 다릅니다.");
			}
			
			if(srcStream != null) {
				srcStream.close();
			}
			if(destStream != null) {
				destStream.close();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		scanner.close();
	}
	
	private static boolean compareFile(FileInputStream src, FileInputStream dest) throws IOException {
		byte[] srcBuf = new byte[1024]; // 1KB
		byte[] destBuf = new byte[1024]; // 1KB
		
		int srcCount = 0;
		int destCount;
		
		while(true) {
			srcCount = src.read(srcBuf, 0, srcBuf.length); // 최대 len개의 바이트를 읽어 srcBuf배열의 0 위치부터 저장
			destCount = dest.read(destBuf, 0, destBuf.length);
			if(srcCount != destCount) {
				return false;
			}
			if(srcCount == -1) {
				break;
			}
			for(int i = 0; i < srcCount; i++) {
				if(srcBuf[i] != destBuf[i]) {
					return false;
				}
			}
		}
		return true;
	}
}