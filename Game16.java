//与えられた16個の文字を使いなるべく長い単語を作る
//*/usr/share/dict/wordsを辞書として使う


import java.util.*;
import java.io.*;
public class Game16{
	static int i = 0;
	static int k = 0;
	static char[][] dictionary = new char[300000][16];
	static char[][] normalDictionary = new char[300000][16];
	public static void main(String[] args) throws IOException{
		//入力
		System.out.println("16文字のアルファベットを入力してください。");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.toLowerCase();//小文字に変換
		char[] words = sort(str);//Sortしてchar[]の配列chに代入

		//辞書
		BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));//辞書から読み込み
		//辞書と比較して、その言葉の添字を返す
		int number = 0;
		number = compareToDictionary(words, br, number);
		//numberには、辞書の該当する添字が入っている
		System.out.println(number);

		//普通の辞書で値を返す。
		System.out.println(dictionary[number]);
		System.out.println(normalDictionary[number]);
		//もし当てはまらなかったら15文字で考える
		if(number == 0){
			for(int h = 0; h < words.length; h++){
				words[h] = null;
				number = compareToDictionary(words, br, number);
			}
		}
	}
	//辞書と比較
	static int compareToDictionary(char[] words, BufferedReader br, int number) throws IOException{
		String line = "";
		while((line = br.readLine()) != null){			
			line = line.toLowerCase();
			normalDictionary[k] = line.toCharArray();//普通の辞書を配列に格納
			dictionary[i] = sort(line);
			if(dictionary[i].length >= words.length){
				for(int j = 0; j < words.length; j++){
					if(Arrays.equals(dictionary[i], words) == true){
						number = i;			
					}
				}
			}else{
				for(int j = 0; j < dictionary[i].length; j++){
					if(Arrays.equals(dictionary[i], words) == true){
						number = i;
					}
				}
			}
			i++;
			k++;
		}
		br.close();
		return number;
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