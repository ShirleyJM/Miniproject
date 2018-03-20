package com.java.miniproject;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneDBApp {

	public static void main(String[] args) throws IOException {

		int flag=0;

		
		
		
		while(true){
			
			System.out.println("**************************************");
			System.out.println("*        전화번호  관리  프로그램                    *");
			System.out.println("**************************************");
			
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료   ");
			System.out.println("--------------------------------------");
			System.out.print(">메뉴번호:");
			
			
			Scanner sc = new Scanner(System.in);
			int num;
			num=sc.nextInt();
			
			
		switch(num) {
		case 1: 
			List<PhoneDB> list = new ArrayList<PhoneDB>();
			Reader fr = new FileReader("phoneDB.txt");
			BufferedReader br = new BufferedReader(fr);
			String str ="";
			
			while(true){
				str = br.readLine();
				if(str==null){
					break;
				}
				
				String[] PersonInfo = str.split(",");
				PhoneDB pdb = new PhoneDB(PersonInfo[0],PersonInfo[1],PersonInfo[2]);
				list.add(pdb);
					
			}
				System.out.println("<1.리스트>");	
				
					for(int i=0;i<list.size();i++){
					System.out.print((i+1)+" ");
						list.get(i).showInfo();
					
					}
				break;
		case 2:
			List<PhoneDB> list2 = new ArrayList<PhoneDB>();
			Reader fr2 = new FileReader("phoneDB.txt");
			BufferedReader br2 = new BufferedReader(fr2);
			String str2 ="";
		
			while(true){
			str = br2.readLine();
				if(str==null){
					break;
			}
				
				String[] PersonInfo = str.split(",");
				PhoneDB pdb = new PhoneDB(PersonInfo[0],PersonInfo[1],PersonInfo[2]);
				list2.add(pdb);
					
			}
		
			Writer  fw = new FileWriter("phoneDB.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Scanner scan = new Scanner(System.in);
			
			String input1;
			String input2;
			String input3;
			
			System.out.print("이름: ");
			input1= scan.nextLine();
			System.out.print("휴대전화: ");
			input2= scan.nextLine();
			System.out.print("회사전화: ");
			input3= scan.nextLine();
			list2.add(new PhoneDB (input1,input2,input3));
			//list.add(new PhoneDB (input1,input2,input3));
			//scan.nextLine(),scan.nextLine(),scan.nextLine();
			
			for(int i=0;i<list2.size();i++){
				bw.write(list2.get(i).getName()+",");
				bw.write(list2.get(i).getHp()+",");
				bw.write(list2.get(i).getCompany());
				bw.newLine();
				
				}
			bw.close();
			System.out.println("등록되었습니다.");
			break;
				
		case 3:
			
			List<PhoneDB> list3 = new ArrayList<PhoneDB>();
			System.out.println("<3.삭제>");
			Scanner rmv = new Scanner(System.in);
			System.out.println(">번호: ");
			int a = rmv.nextInt();
			
			Reader fr3 = new FileReader("phoneDB.txt");
			BufferedReader br3 = new BufferedReader(fr3);
			String str3 ="";
			
			while(true){
				str = br3.readLine();
				if(str==null){
					break;
				}
				
				String[] PersonInfo = str.split(",");
				PhoneDB pdb = new PhoneDB(PersonInfo[0],PersonInfo[1],PersonInfo[2]);
				list3.add(pdb);
					
			}
			list3.remove(a-1);
			
			//메뉴번호랑 연결
			Writer  fw2 = new FileWriter("phoneDB.txt");
			BufferedWriter bw2 = new BufferedWriter(fw2);
			
			for(int i=0;i<list3.size();i++){
			bw2.write(list3.get(i).getName()+",");
			bw2.write(list3.get(i).getHp()+",");
			bw2.write(list3.get(i).getCompany()+",");
			bw2.newLine();
			
			}
			bw2.close();
			//remove();
			//System.out.println(PhoneDB.remove(num-1));
			System.out.println();
			System.out.println("삭제되었습니다.");
			break;
			
			
		case 4:
			//검색
			break;
			
			
		case 5:
			List<PhoneDB> list5 = new ArrayList<PhoneDB>();
			System.out.println("**************************************");
			System.out.println("*        감사합니다                   *");
			System.out.println("**************************************");
			flag=1;
			break;

	    default:  
	    	System.out.println("[ 다시 입력해 주세요 ]");
	    	System.out.println();
	    	
		}
		
		if(flag==1){
			break;
			}
		
		}//while
		
	}//main
}//class
	
