//与えられた16個の文字を使いなるべく長い単語を作る
//*/usr/share/dict/wordsを辞書として使う


import java.util.*;
import java.io.*;
public class Game16{
	static char[][] dictionary = new char[300000][16];
	static char[][] normalDictionary = new char[300000][16];
	public static void main(String[] args) throws IOException{
		//入力
		System.out.println("16文字のアルファベットを入力してください。");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.toLowerCase();//小文字に変換
		char[] words = sort(str);//Sortしてchar[]の配列chに代入
		System.out.print("ソート後は");
		System.out.print(words);
		System.out.println("です。");
		//辞書
		//辞書と比較して、その言葉の添字を返す
		int[] number = new int[3];
		number = compareToDictionary(words);
		//numberには、辞書の該当する添字が入っている
//		System.out.println(number);

		//普通の辞書で値を返す。
		//もし当てはまらなかったら15文字で考える
		char[] words1 = new char[5];
		if(number[2] == 0){
			System.out.println("ここは");
			for(int h = 0; h < words.length; h++){
				int m = 0;
				for(int l = 0; l < words.length; l++){
					if(h != l){
						words1[m] = words[l];//新しい配列に、一文字少ない配列を作り直す
						m++;
					}
				}
				number = compareToDictionary(words1);
			}
		}
		//それでも当てはまらなかったら14文字
		System.out.println("それでは");
		char[] words2 = new char[5];
		if(number[2] == 0){
			System.out.println("if");
			for(int h = 0; h < words.length; h++){
				for(int j = h+1; j < words.length; j++){
					int m = 0;
					for(int l = 0; l < words.length; l++){
						if(h != l && j != l){
							System.out.println(m);
							words2[m] = words[l];
							m++;
						}
					}
					System.out.println(m);
					number = compareToDictionary(words2);
					System.out.println(words2);
				}
			}
		}
		//13文字
		char[] words3 = new char[5];
		if(number[2] == 0){
			for(int h = 0; h < words.length; h++){
				for(int j = h+1; j < words.length; j++){
					for(int k = j+1; k < words.length; k++){
						int m = 0;
						for(int l = 0; l < words.length; l++){
							if(h != l && j != l && k != l){
								words3[m] = words[l];
								m++;
							}
						}
						number = compareToDictionary(words3);
					}			
				}
			}
		}
		//12文字
		char[] words4 = new char[5];
		if(number[2] == 0){
			for(int h = 0; h < words.length; h++){
				for(int j = h+1; j < words.length; j++){
					for(int k = j+1; k < words.length; k++){
						for(int n = k+1; n < words.length; n++){
							int m = 0;
							for(int l = 0; l < words.length; l++){
								if(h != l && j != l && k != l && n != l){
									words4[m] = words[l];
									m++;
								}
							}
	//						System.out.println(words4);
							number = compareToDictionary(words4);
	//						System.out.println(number[2]);
						}
					}
				}
			}
		}



		System.out.print("見つかった単語は");
		System.out.print(normalDictionary[number[2]]);
		System.out.println("です。");
		System.out.print(number[2]);
		System.out.println("番目にありました。");
	}
	//辞書と比較
	static int[] compareToDictionary(char[] words) throws IOException{
		//i[0]は普通の辞書、i[1]はソートした辞書、i[2]は文字のあった場所
		int[] i = new int[3];
		BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));//辞書から読み込み		
		String line = "";
		while((line = br.readLine()) != null){			
			line = line.toLowerCase();
			normalDictionary[i[0]] = line.toCharArray();//普通の辞書を配列に格納
			dictionary[i[1]] = sort(line);
			if(dictionary[i[1]].length >= words.length){
				for(int j = 0; j < words.length; j++){
					if(Arrays.equals(dictionary[i[1]], words) == true){
						i[2] = i[1];			
					}
				}
			}else{
				for(int j = 0; j < dictionary[i[1]].length; j++){
					if(Arrays.equals(dictionary[i[1]], words) == true){
						i[2] = i[1];
					}
				}
			}
			i[0]++;
			i[1]++;
		}
		br.close();
		return i;
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