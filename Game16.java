//与えられた16個の文字を使いなるべく長い単語を作る
//*/usr/share/dict/wordsを辞書として使う


import java.util.*;
import java.io.*;
public class Game16{
	static char[][] dictionary = new char[235886][16];
	static char[][] normalDictionary = new char[235886][16];
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
		BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));//辞書から読み込み		
		String line = "";
		while((line = br.readLine()) != null){			
			line = line.toLowerCase();
			normalDictionary[number[1]] = line.toCharArray();//普通の辞書を配列に格納
			dictionary[number[1]] = sort(line);
			number[1]++;
		}
		br.close();
		number = compareToDictionary(words);
		//numberには、辞書の該当する添字が入っている

		//普通の辞書で値を返す。
		//もし当てはまらなかったら15文字で考える
		char[] words1 = new char[15];
		if(number[2] == 0){
			for(int h = 0; h < words.length; h++){
				int m = 0;
				for(int l = 0; l < words.length; l++){
					if(h != l){
						words1[m] = words[l];//新しい配列に、一文字少ない配列を作り直す
						m++;
					}
				}
				number = compareToDictionary(words1);
				if(number[2] != 0)break;
			}
		}
		//それでも当てはまらなかったら14文字
		char[] words2 = new char[14];
		if(number[2] == 0){
			for(int h = 0; h < words.length; h++){
				for(int j = h+1; j < words.length; j++){
					int m = 0;
					for(int l = 0; l < words.length; l++){
						if(h != l && j != l){
							words2[m] = words[l];
							m++;
						}
					}
					number = compareToDictionary(words2);
					if(number[2] != 0)break;
				}
				if(number[2] != 0)break;
			}
		}
		//13文字
		char[] words3 = new char[13];
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
						if(number[2] != 0)break;
					}
					if(number[2] != 0)break;
				}
				if(number[2] != 0)break;
			}
		}
		//12文字
		char[] words4 = new char[12];
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
							number = compareToDictionary(words4);
							if(number[2] != 0)break;
						}
						if(number[2] != 0)break;
					}
					if(number[2] != 0)break;
				}
				if(number[2] != 0)break;
			}
		}
		//11文字
		char[] words5 = new char[11];
		if(number[2] == 0){
			for(int h = 0; h < words.length; h++){
				for(int j = h+1; j < words.length; j++){
					for(int k = j+1; k < words.length; k++){
						for(int n = k+1; n < words.length; n++){
							for(int o = n+1; o < words.length; o++){
								int m = 0;
								for(int l = 0; l < words.length; l++){
									if(h != l && j != l && k != l && n != l && o != l){
										words5[m] = words[l];
										m++;
									}
								}
								number = compareToDictionary(words5);
								if(number[2] != 0)break;
							}
							if(number[2] != 0)break;
						}
						if(number[2] != 0)break;
					}
					if(number[2] != 0)break;
				}
				if(number[2] != 0)break;
			}
		}
		//10文字
		char[] words6 = new char[10];
		if(number[2] == 0){
			for(int h = 0; h < words.length; h++){
				for(int j = h+1; j < words.length; j++){
					for(int k = j+1; k < words.length; k++){
						for(int n = k+1; n < words.length; n++){
							for(int o = n+1; o < words.length; o++){
								for(int p = o+1; p < words.length; p++){
									int m = 0;
									for(int l = 0; l < words.length; l++){
										if(h != l && j != l && k != l && n != l && o != l && p != l){
											words6[m] = words[l];
											m++;
										}
									}
									number = compareToDictionary(words6);
									if(number[2] != 0)break;
								}
								if(number[2] != 0)break;
							}
							if(number[2] != 0)break;
						}
						if(number[2] != 0)break;
					}
					if(number[2] != 0)break;
				}
				if(number[2] != 0)break;
			}
		}
		//9文字,除去するのが7文字
		char[] words7 = new char[5];
		if(number[2] == 0){
			for(int h = 0; h < words.length; h++){
				for(int j = h+1; j < words.length; j++){
					for(int k = j+1; k < words.length; k++){
						for(int n = k+1; n < words.length; n++){
							for(int o = n+1; o < words.length; o++){
								for(int p = o+1; p < words.length; p++){
									for(int q = p+1; q < words.length; q++){
										int m = 0;
										for(int l = 0; l < words.length; l++){
											if(h != l && j != l && k != l && n != l && o != l && p != l && q != l){
												words7[m] = words[l];
												m++;
											}
										}
										number = compareToDictionary(words7);
										if(number[2] != 0)break;
									}
									if(number[2] != 0)break;
								}
								if(number[2] != 0)break;
							}
							if(number[2] != 0)break;
						}
						if(number[2] != 0)break;
					}
					if(number[2] != 0)break;
				}
				if(number[2] != 0)break;
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
		//i[1]は普通の辞書とソートした辞書、i[2]は文字のあった場所
		int[] i = new int[3];
		while(true){
			if(i[2] != 0 || i[1] == 235886){
				break;
			}else if(dictionary[i[1]].length >= words.length){
				if(Arrays.equals(dictionary[i[1]], words) == true){
					i[2] = i[1];			
				}
			}else{
				if(Arrays.equals(dictionary[i[1]], words) == true){
					i[2] = i[1];
				}
			}
			i[1]++;
		}
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