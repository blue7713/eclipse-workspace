package exercise7;

import java.util.*;

public class Exercise7_8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> info = new HashMap<String, Integer>();
		
		System.out.println("** 포인트 관리 프로그램입니다 **");
		
		while(true) {
			System.out.print("이름과 포인트 입력>> ");
			String name = scanner.next();
			if(name.equals("그만")) {
				break;
			}
			int point = scanner.nextInt();
			
			if(info.containsKey(name)) { // 키가 존재하면 누적
				int value = info.get(name);
				value = value + point;
				info.put(name, value);
			} // 아니면 생성
			else {
				info.put(name, point);
			}
			
			Set<String> keys = info.keySet();
			Iterator<String> it = keys.iterator();
			
			while(it.hasNext()) {
				String key = it.next();
				int value = info.get(key);
				System.out.println("(" + key + ", " + value + ") ");
			}
		}
		scanner.close();
	}
}