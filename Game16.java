//与えられた16個の文字を使いなるべく長い単語を作る
//*/user/share/dict/wordsを辞書として使う


import java.util.*;
import java.io.*;
public class Game16{
	public static void main(String[] args){
		//入力
		System.out.println("16文字のアルファベットを入力してください。");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.toLowerCase();//小文字に変換
		char[] words = sort(str);//Sortしてchar[]の配列chに代入

		//辞書
		char[][] dictionary = new char[300000][16];
		int i = 0;
		int j = 0;
		try{
			BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));
			String line = "";
			while((line = br.readLine()) != null){
				line = line.toLowerCase();
				dictionary[i] = sort(line);
				if(dictionary[i].length >= words.length){
					for(j = 0; j < words.length; j++){
						if(Arrays.equals(dictionary[i], words) == true){
							System.out.println(dictionary[i]);
						}
					}
				}else{
					for(j = 0; j < dictionary[i].length; j++){
						if(Arrays.equals(dictionary[i], words) == true){
							System.out.println(dictionary[i]);
						}
					}
				}
				i++;
			}
			br.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}
	//Sort
	static char[] sort(String str){
		char[] a = new char[str.length()];
		for(int i = 0; i < str.length(); i++){
			a[i] = str.charAt(i);
		}
		for(int i = 0; i < str.length()-1; i++){
			for(int j = 0; j < str.length()-1; j++){
				if(a[j] > a[j+1]) {
					char x = a[j];
					a[j] = a[j+1];
					a[j+1] = x;
				}
			}
		}
		return a;
	}
}